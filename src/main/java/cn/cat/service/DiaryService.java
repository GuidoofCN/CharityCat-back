package cn.cat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cat.mapper.DiaryMapper;
import cn.cat.pojo.Diary;
import cn.cat.query.LimitQuery;

@Service
public class DiaryService {
    @Autowired
	private DiaryMapper mapper;
	
    
    public Map<String, Object> diaryList(LimitQuery query){
    	Map<String, Object> map = new HashMap<>();
    	List<Diary> list = mapper.selectDiaryAll(query);
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
    
}
