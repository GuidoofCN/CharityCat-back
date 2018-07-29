package cn.cat.controller.diary;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cat.query.LimitQuery;
import cn.cat.service.DiaryService;

@CrossOrigin(origins="*",allowCredentials="true")
@RestController
@RequestMapping("/diary")
public class Diary {
    @Autowired
	private DiaryService service;
	
    @GetMapping("/diary-list")
    public Map<String, Object> diaryList(LimitQuery query){
    	return service.diaryList(query);
    }
    
	
}
