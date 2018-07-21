package cn.cat.controller.cat;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.cat.pojo.CatNotePojo;
import cn.cat.pojo.CatPojo;
import cn.cat.query.LimitQuery;
import cn.cat.service.CatService;

@RestController
@RequestMapping("/cat")
public class Cat {
	@Autowired
	private CatService catService;

	@GetMapping("/cat-list")
	public Map<String,Object> catList(LimitQuery query) {
		return catService.catList(query);
	}

	@PostMapping("/cat-release")
	public Map<String, String> catRelease(CatPojo cat,CatNotePojo note) {
		return catService.catRelease(cat,note);
	}
}
