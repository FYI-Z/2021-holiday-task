package util;

import java.util.UUID;

/** 
* @author miku
* name：字符串工具类
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/

public class StringUtil {
	public static String generateSn(String prefix,String suffix) {
		return prefix + UUID.randomUUID().toString().replace("-", "").toUpperCase() + suffix;
	}
	
	public static boolean isEmpty(String teString) {
		if(teString==null) {
			return true;
		}
		return false;
	}
}
