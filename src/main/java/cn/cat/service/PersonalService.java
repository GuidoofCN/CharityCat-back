package cn.cat.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import cn.cat.mapper.UserMapper;
import cn.cat.pojo.UserPojo;

@Service
public class PersonalService {
	@Autowired
	private UserMapper mapper;

	public Map<String, Object> info(@PathVariable String id) {
		Map<String, Object> map = new HashMap<>();
		UserPojo man = mapper.findUserById(id);
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

	public Map<String, String> updateInfo(UserPojo man) {
		Map<String, String> map = new HashMap<>();
		if (mapper.updateUserInfo(man) > 0) {
			map.put("code", "200");
			map.put("message", "更新成功");
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "更新失败");
			return map;
		}
	}

	
}
