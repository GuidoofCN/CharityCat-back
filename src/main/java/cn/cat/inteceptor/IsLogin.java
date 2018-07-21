package cn.cat.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.cat.cache.TokenCache;

public class IsLogin implements HandlerInterceptor {

	@Autowired
	private TokenCache tokenInfo;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		/*if (!tokenInfo.isTokenExist("")) {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf8");
			PrintWriter out = response.getWriter();
			Map<String, String> map = new HashMap<>();
			map.put("code", "401");
			map.put("message", "身份信息失效,请重新登录");
			ObjectMapper obj = new ObjectMapper();
			out.print(obj.writeValueAsString(map));
			out.flush();
			out.close();
			return false;
		}*/
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
