package cn.cat.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import cn.cat.mapper.UserMapper;
import cn.cat.pojo.UserPojo;
import cn.cat.util.FileHandle;
import cn.cat.util.UrlUtil;

@Service
public class PersonalService {
	@Autowired
	private UserMapper mapper;
	@Autowired
	private UrlUtil urlUtil;
	

	public Map<String, Object> info(String userid) {
		Map<String, Object> map = new HashMap<>();
		UserPojo man = mapper.findUserById(userid);
		if (man != null) {
			map.put("data", man);
			map.put("code", "200");
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "资源未找到");
			return map;
		}
	}

	public Map<String, String> updateInfo(UserPojo man, MultipartFile picfile) throws IOException {
		String imageUrl = null;
		if(!picfile.isEmpty()) {
			String extension = "."+FileHandle.getExtension(picfile.getOriginalFilename());
			String picFileName = FileHandle.getFileName()+extension;
			File outPutPath = FileHandle.getPersonalFilePath();
			imageUrl = urlUtil.getPersonalBaseUrl()+FileHandle.transferTo(picfile, outPutPath,picFileName);
			man.setPic(imageUrl);
		}
		Map<String, String> map = new HashMap<>();
		if (mapper.updateUserInfo(man) > 0) {
			map.put("code", "200");
			map.put("imageUrl", imageUrl);
			map.put("message", "更新成功");
			return map;
		} else {
			map.put("code", "404");
			map.put("imageUrl", imageUrl);
			map.put("message", "更新失败");
			return map;
		}
	}

	
}
