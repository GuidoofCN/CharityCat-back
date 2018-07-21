package cn.cat.cache;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenCache {
	// 存储token信息集合，12233333333
	private static ConcurrentHashMap<String, Map<String, String>> tokenInfo = new ConcurrentHashMap<>();
	// 添加新的token信息,hour是有效几个小时，2333333
	public void addToken(String userid, String token, Integer hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, hour);
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		map.put("expiry", ((Long) cal.getTimeInMillis()).toString());
		tokenInfo.put(userid, map);
	}
	// token有效时长计算
	public void countTokenExpiry() {
		System.out.println(tokenInfo);
		tokenInfo.forEach((k, v) -> {
			Long storeTime = Long.parseLong(v.get("expiry"));
			if (storeTime <= new Date().getTime()) {
				tokenInfo.remove(k);
			}
		});
	}
	// 判断token是否存在
	public Boolean isTokenExist(String token) {
		Collection<Map<String, String>> values = tokenInfo.values();
		for (Map<String, String> map : values) {
			if (map.containsValue(token))
				return true;
		}
		return false;
	}

	// 退出登录时移除token信息
	public void removeToken(String userid) {
		tokenInfo.remove(userid);
	}
}
