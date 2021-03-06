package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONArray;


public class Token {
	private static HashMap<String, JSONArray>userToken = new HashMap<>();
	private static String liftCycle = Constant.liftCycle;
	
	
	static public void generateUUID() {
		String token = UUID.randomUUID()+"";
		System.out.println("token为"+token);
	}
	
	public static void setUserToken(JSONArray js) {
		String userid= js.getString(0);
		long exprieTime = System.currentTimeMillis()+Integer.parseInt(liftCycle)*1000;
		js.add(exprieTime);
		userToken.put(userid, js);
		if(System.currentTimeMillis()%1800000 == 0 ) {
			clearExpression();
		}
		
		
	}
	public static void delToken(String userid) {
		userToken.remove(userid);
	}
	
	public static JSONArray getToken(String userid) {
		JSONArray js =null;
		js =userToken.get(userid);
		if(System.currentTimeMillis()%1800000 == 0) {
			clearExpression();
		}
		return js;
	}
	
	
	public static void clearExpression() {
		for(Iterator<Map.Entry<String, JSONArray>> it = userToken.entrySet().iterator();it.hasNext();) {
			Map.Entry<String, JSONArray> item = it.next();
			long exprieTime = Long.parseLong(item.getKey());
			if(System.currentTimeMillis() > exprieTime)
			{
				String  userid = "";
				 delToken(userid);
			}
		}
		
	}
}
