package cn.cat.cache;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VerificatCodeCache {
	private static ConcurrentHashMap<String, Map<String, String>> verificatCodeCache = new ConcurrentHashMap<>();

	public void addVerificatCode(String mail, String verificatCode) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 1);
		Map<String, String> map = new HashMap<>();
		map.put("verificatCode", verificatCode);
		map.put("expiry", ((Long) cal.getTimeInMillis()).toString());
		verificatCodeCache.put(mail, map);
	}

	public void countVerificatCodeExpiry() {
		verificatCodeCache.forEach((k, v) -> {
			Long storeTime = Long.parseLong(v.get("expiry"));
			if (storeTime <= new Date().getTime())
				verificatCodeCache.remove(k);
		});
	}

	public void removeVerificatCode(String mail) {
		verificatCodeCache.remove(mail);
	}

	public String getVerificatCode(String mail) {
		Map<String, String> map = null ;
		if((map = verificatCodeCache.get(mail))!=null)
			return map.get("verificatCode");
		else
			return null;
	}
}
