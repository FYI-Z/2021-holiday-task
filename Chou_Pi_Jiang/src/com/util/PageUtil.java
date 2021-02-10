package com.util;

/*
 * description: 将json转化成layui能够识别的json数据格式
 * author: 李章
 * time: 2021.02.08
 * the name of the class: PageUtil
 * */
public class PageUtil {
	public static String getJsonTree(int sum, String msg, String data, int status) {
		return "{\"code\":\"" + status + "\",\"msg\":\"" + msg + "\",\"sum\":\"" + sum + "\",\"data\":" + data + "}";
	}
}
