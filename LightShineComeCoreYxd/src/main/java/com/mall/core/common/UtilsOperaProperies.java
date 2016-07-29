package com.mall.core.common;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UtilsOperaProperies {

	private static Log log = LogFactory.getLog(UtilsOperaProperies.class);
	
	
	/** 
	* 【写入properts 文件】
	* @param filePath
	* @param prop  
	*/
	
	public static void writeProperties(String filePath,Properties prop)
	{
//		filePath = getFileUrl(filePath);
		OutputStreamWriter osw = null;
		try 
		{
			osw = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
			prop.store(osw, "Update");
			osw.flush();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 
	* 【删除key 值】
	* @param filePath
	* @param key  
	*/
	
	public  static void deleteKey(String filePath,String key)
	{
		if(filePath == null || filePath.equals("")) return;
		if(key == null || key.equals("")) return;
		Properties prop = readPropertiesP(filePath);
		prop.remove(key); 
		writeProperties(filePath, prop);
	}
    
    /** 
    * 【写入properties信息】
    * @param filePath
    * @param key
    * @param value  
    */
    
//    public static void writeProperties(String filePath,String key,String value) {
//    	if(filePath == null || filePath.equals("")) return;
//    	if(key == null || key.equals("")) return;
//    	if(value == null || value.equals("")) return;
//    	Properties prop = readPropertiesP(filePath);
//    	prop.setProperty(key, value);
//    	writeProperties(filePath, prop);
//    }
	
	/** 
	* 【读取properties的全部信息】
	* @param filePath
	* @return  
	*/
	
	public static Properties readPropertiesP(String filePath)
	{
		if(filePath == null || filePath.equals("filePath")) return null;
		 Properties props = new Properties();
//		 filePath = getFileUrl(filePath);
		 InputStream in = null;
		 try {
//			in = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
			 in = UtilsOperaProperies.class.getClassLoader().getResourceAsStream(filePath);
			try {
				props.load(new InputStreamReader(in, "UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally
		{
			try {
				if(null != in) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		 return props;
	}
	
	
	/** 
	* 【读取properties的全部信息】(这里用一句话描述这个方法的作用)
	* @param filePath
	* @return  
	*/
	
//	public static List<Propertes> readPropertiesList(String filePath)
//	{
//		if(filePath == null || filePath.equals("filePath")) return null;
//		List<Propertes> list = new ArrayList<Propertes>();
//		String key = "",Property="";
//        Properties props = readPropertiesP(filePath);
//        Propertes pop = null;
//		Enumeration en = props.propertyNames();
//        while (en.hasMoreElements())
//        {
//       	    key = (String) en.nextElement();
//            Property = props.getProperty (key);
//            pop = new Propertes(key, Property);
//            list.add(pop);
//        }
//		return list;
//	}
	
	
	/** 
	* 【读取properties的全部信息】
	* @param filePath
	* @return  
	*/
	
	public static Map<String,String> readProperties(String filePath) {
    	if(filePath == null || filePath.equals("filePath")) return null;
         Map<String,String> map = new HashMap<String, String>();
         String key = "",Property="";
         Properties props =readPropertiesP(filePath);
         Enumeration en = props.propertyNames();
         while (en.hasMoreElements()) 
         {
        	 key = (String) en.nextElement();
             Property = props.getProperty (key);
             map.put(key, Property);
//             log.info(">>>>>>>>>>>>"+key+" = "+Property);
         }
         return map;
    }
	
	 
	/** 
	* 【根据key读取value】
	* @param filePath
	* @param key
	* @return  
	*/
	
	
	/** 
	* 【得到文件的真实路径】
//	* @param filePath
//	* @param key
	* @return  
	*/
	
//	public static String readValue(String filePath,String key) {
//
//		 if(filePath == null || filePath.equals("")) return null;
//		 if(key == null || key.equals("")) return null;
//		 Properties props = readPropertiesP(filePath);
//
//		 return props.getProperty (key);
//	 }
//	 public static String getFileUrl(String fileUrl)
//	 {
//		 String url=null;
//		 try {
//			url = UtilsOperaProperies.class.getClassLoader().getResourceAsStream(fileUrl).getPath();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		 return url;
//	 }
	 
	 public static void main(String[] args) 
	 {
		 
	 }
	 

}
