package com.utils;

/**
 * @author cll
 * @version 1.0
 * @ClassName PathUtil
 * @Description: TODO: 解析路径的工具类
 * @date 2019/5/8 14:34
 */
public class PathUtil {
	
	private static String commonPath;	//公共路径
	private static String serverPath;	//服务器路径
	
	public static String getCommonPath() {
		serverPath=System.getProperty("catalina.home");
		commonPath = serverPath +PropertyUtil.getPropertiesPath().getProperty("webapps");
		return commonPath;
	}
	

	public static String getArticlePath() {
	
		return PropertyUtil.getPropertiesPath().getProperty("articlePath");
	}


	public static String getUserPath() {
		
		return PropertyUtil.getPropertiesPath().getProperty("userPath");
		}
}
