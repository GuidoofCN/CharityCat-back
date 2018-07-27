package cn.cat.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlUtil {
	@Autowired
	private  HttpServletRequest request;

	public  String getCatBaseUrl() {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/images/cat/";
	}

	public  String getPersonalBaseUrl() {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/images/personal/";
	}

	public  String getDiaryBaseUrl() {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/images/diary/";
	}

}
