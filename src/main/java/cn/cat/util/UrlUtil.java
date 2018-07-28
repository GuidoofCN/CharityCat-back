package cn.cat.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlUtil {
	@Autowired
	private  HttpServletRequest request;
	private String baseUrl = "http://21567yq397.imwork.net:25107";

	public  String getCatBaseUrl() {
		return baseUrl
				+ request.getContextPath() + "/images/cat/";
	}

	public  String getPersonalBaseUrl() {
		return baseUrl
				+ request.getContextPath() + "/images/personal/";
	}

	public  String getDiaryBaseUrl() {
		return baseUrl
				+ request.getContextPath() + "/images/diary/";
	}

}
