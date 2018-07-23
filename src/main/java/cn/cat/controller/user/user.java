package cn.cat.controller.user;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.cat.pojo.UserPojo;
import cn.cat.query.UserLoginQuery;
import cn.cat.service.UserService;

@RestController
@RequestMapping("/user")
public class user {

	@Autowired
	private UserService userService;

	// 登录接口
	@PostMapping("/login")
	public Map<String, String> login(HttpServletRequest req, UserLoginQuery query) throws Exception {
		return userService.login(req, query);
	}

	// 注册接口
	@PostMapping("/register")
	public Map<String, String> register(UserPojo man, String verificatCode) {
		return userService.register(man, verificatCode);
	}

	// 邮箱验证码接口
	@GetMapping("/verificatCode/{mail:.+}")
	public void VerificatCode(@PathVariable String mail) {
		userService.VerificatCode(mail);
	}

	// 密码找回接口
	@PostMapping("/forget-pass")
	public Map<String, String> forgetPass(String mail, String newpass, String verificatCode) {
		return userService.forgetPass(mail, newpass, verificatCode);
	}

	// 退出登录，移除该账号的token
	@PostMapping("/loginout/{userid}")
	public void loginout(@PathVariable String userid) {
		userService.loginout(userid);
	}
}
