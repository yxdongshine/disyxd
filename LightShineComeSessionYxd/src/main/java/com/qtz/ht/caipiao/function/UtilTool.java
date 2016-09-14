
package com.qtz.ht.caipiao.function;  

import java.util.Date;
import java.util.GregorianCalendar;

/** 
 * ClassName:UtilTool <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月14日 下午5:12:57 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class UtilTool {

	public static int SYS_TIME = 1000;
	public static int SEC_TIME = 60;
	public static int MIN_TIME =60*1000;
	public static int HOUR_TIME = 60*60*1000;
	public static int DAY_TIME = 24 *60*60*1000;
	public static String formatDate(Long times){
		String dateStr= null;
        Date dat=new Date(times);  
        GregorianCalendar gc = new GregorianCalendar();   
        gc.setTime(dat);  
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");  
        dateStr=format.format(gc.getTime());  
		return dateStr;
	}
}
  