package cn.cat.controller.personal;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.cat.pojo.UserPojo;
import cn.cat.service.PersonalService;

@CrossOrigin(origins="*",allowCredentials="true")
@RestController
@RequestMapping("/personal")
public class Personal {
	@Autowired
	private PersonalService personalService;

	@GetMapping("/info/{id}")
	public Map<String, Object> info(@PathVariable String id) {
		return personalService.info(id);
	}

	@PostMapping("/update")
	public Map<String,String> updateInfo(UserPojo man, MultipartFile picfile) throws IOException{
		return personalService.updateInfo(man,picfile);
	}
}
