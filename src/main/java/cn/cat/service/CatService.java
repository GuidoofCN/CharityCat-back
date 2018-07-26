package cn.cat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.cat.mapper.CatMapper;
import cn.cat.pojo.CatNotePojo;
import cn.cat.pojo.CatPojo;
import cn.cat.query.LimitQuery;
import cn.cat.util.RandomIdUtil;

@Service
public class CatService {
	@Autowired
	private CatMapper mapper;

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

	public Map<String, String> catRelease(CatPojo cat, CatNotePojo note, MultipartFile file) {
		String catid = RandomIdUtil.randomOtherId();
		cat.setCatid(catid);
		note.setCatid(catid);
		Map<String, String> map = new HashMap<>();
		if (mapper.insertCatNote(note) > 0 && mapper.insertCat(cat) > 0) {
			map.put("code", "200");
			map.put("message", "发布成功");
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "发布失败");
			return map;
		}
	}

	public Map<String, Object> catDetail(String catid) {
		CatPojo note = null;
		Map<String, Object> map = new HashMap<>();
		if((note = mapper.selectCatNote(catid))!= null) {
			map.put("code", "200");
			map.put("data", note);
			return map;
		}else {
			map.put("code", "404");
			map.put("message", "资源未找到");
			return map;
		}
	}
}
