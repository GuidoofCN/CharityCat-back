package cn.cat.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class FileHandle {
	private final static String CATBASEURL = "src\\main\\webapp\\images\\cat";
	private final static String DIARYBASEURL = "src\\main\\webapp\\images\\diary";
	private final static String PERSONALBASEURL = "src\\main\\webapp\\images\\personal";
	private static Calendar cal = Calendar.getInstance();
	private final static Integer YEAR = cal.get(Calendar.YEAR);
	private final static Integer MONTH = (cal.get(Calendar.MONTH) + 1);
	private final static Integer DAY = cal.get(Calendar.DAY_OF_MONTH);
	private final static Integer HOUR = cal.get(Calendar.HOUR_OF_DAY);
	private final static Integer MINUTE = cal.get(Calendar.MINUTE);
	private final static Integer SECOND = cal.get(Calendar.SECOND);
	private final static String BASEFILEPATH = YEAR + "\\" + MONTH + "\\"
			+ DAY;
	
	// 获取扩展名
	public static String getExtension(String FileName) {
		String[] strs = FileName.split("\\.");
		return strs[strs.length - 1];
	}

	// 获取猫咪图片文件路径
	public static File getCatFilePath() {
		return new File(CATBASEURL + "\\"+ BASEFILEPATH + "\\");
	}

	// 获取日记图片文件路径
	public static File getDiaryFilePath() {
		return new File(DIARYBASEURL + "\\"+ BASEFILEPATH + "\\");
	}

	// 获取个人图片文件路径
	public static File getPersonalFilePath() {
		return new File(PERSONALBASEURL + "\\"+ BASEFILEPATH + "\\");
	}

	// 获取当前毫秒值作为文件名
	public static String getFileName() {
		return YEAR.toString()+MONTH.toString()+DAY.toString()+HOUR.toString()+MINUTE.toString()+SECOND.toString();
	}

	// 输出文件到指定目录,并返回图片映射地址
	public static String transferTo(MultipartFile file, File path, String picFileName) {
		if (!path.exists()) {
			path.mkdirs();
		}
		File outPath = new File(path, picFileName);
		InputStream input = null;
		OutputStream output = null;
		try {
			input = file.getInputStream();
			output = new FileOutputStream(outPath);
			byte[] bytes = new byte[4096];
			int len = 0;
			while ((len = input.read(bytes)) != -1) {
				output.write(bytes, 0, len);
			}
			return (BASEFILEPATH+"/"+picFileName).replace("\\", "/");
		} catch (IOException e1) {
			e1.printStackTrace();
			return "";
		} finally {
			try {
				input.close();
				output.close();
			} catch (Exception e2) {
			}
		}
	}
}
