package cn.cat.util;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


//随机生成ID工具类
public class RandomIdUtil {
	private static Calendar cal = Calendar.getInstance();

	public static String randomUserId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public static String randomOtherId() {
		cal.setTime(new Date());
		return String.valueOf(cal.get(Calendar.YEAR)) + String.valueOf(cal.get(Calendar.MONTH) + 1)
				+ String.valueOf(cal.get(Calendar.DATE)) + String.valueOf(cal.get(Calendar.HOUR_OF_DAY))
				+ String.valueOf(cal.get(Calendar.MINUTE)) + String.valueOf(cal.get(Calendar.SECOND));
	}
}
