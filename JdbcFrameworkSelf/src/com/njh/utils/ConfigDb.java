package com.njh.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigDb {
		private volatile static boolean flag;
		/* 私有构造方法，防止被实例化 */  
		private ConfigDb() {  
			if(!flag){
				flag = true;
			}else{
				throw new RuntimeException("不能多次创建单例对象");
			}
		}  

		/* 此处使用一个内部类来维护单例 */  
		private static class SingletonFactory {  
		    private static ConfigDb instance = new ConfigDb();
		}  

		/* 获取实例 */  
		public static ConfigDb getInstance() {  
		    return SingletonFactory.instance;  
		}  

		/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
		private Object readResolve() {  
		    return getInstance();  
		}  

	
	public final Properties getPro(){
		Properties pr=new Properties();
		try {
			pr.load(getInstance().getClass().getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		};
		return pr;
	}
}
