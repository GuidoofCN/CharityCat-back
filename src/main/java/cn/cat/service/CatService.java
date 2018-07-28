package cn.cat.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import cn.cat.mapper.CatMapper;
import cn.cat.pojo.CatNotePicPojo;
import cn.cat.pojo.CatNotePojo;
import cn.cat.pojo.CatPojo;
import cn.cat.query.LimitQuery;
import cn.cat.util.FileHandle;
import cn.cat.util.RandomIdUtil;
import cn.cat.util.UrlUtil;

@Service
public class CatService {

	@Autowired
	private CatMapper mapper;
	
	@Autowired
	private UrlUtil urlUtil;
	

	
	public Map<String, Object> catList(LimitQuery query) {
		Map<String, Object> map = new HashMap<>();
		List<CatPojo> list = mapper.selectCatAll(query);
		if (!list.isEmpty()) {
			map.put("code", "200");
			map.put("data", list);
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "请求失败");
			return map;
		}
	}

	public Map<String, Object> catRelease(CatPojo cat, CatNotePojo note, List<MultipartFile> files) {
		List<String> imagesUrls = null;
		String catid = RandomIdUtil.randomOtherId();
		if (files.size() > 0) {
			imagesUrls = new LinkedList<>();
			int i = 0;
			for (MultipartFile file : files) {
				String extension = "." + FileHandle.getExtension(file.getOriginalFilename());
				String picFileName = FileHandle.getFileName() + i + extension;
				File outPutPath = FileHandle.getCatFilePath();
				System.out.println(outPutPath);
				String url = urlUtil.getCatBaseUrl() + FileHandle.transferTo(file, outPutPath, picFileName);
				System.out.println(url);
				imagesUrls.add(url);
				CatNotePicPojo pic = new CatNotePicPojo();
				pic.setCatid(catid);
				pic.setPic(url);
				mapper.insertCatNotePic(pic);
				i++;
			}
		}
		cat.setCatid(catid);
		note.setCatid(catid);
		note.setPosttime(new Date());
		Map<String, Object> map = new HashMap<>();
		if (mapper.insertCatNote(note) > 0 && mapper.insertCat(cat) > 0) {
			map.put("code", "200");
			map.put("message", "发布成功");
			map.put("imageUrls", imagesUrls);
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "发布失败");
			map.put("imageUrls", imagesUrls);
			return map;
		}
	}

	public Map<String, Object> catDetail(String catid) {
		CatPojo note = null;
		Map<String, Object> map = new HashMap<>();
		if ((note = mapper.selectCatNote(catid)) != null) {
			map.put("code", "200");
			map.put("data", note);
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "资源未找到");
			return map;
		}
	}
}
