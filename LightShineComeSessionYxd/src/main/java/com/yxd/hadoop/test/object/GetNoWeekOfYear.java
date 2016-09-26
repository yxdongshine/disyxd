
package com.yxd.hadoop.test.object;  

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** 
 * ClassName:GetNoWeekOfYear <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月26日 上午11:18:10 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class GetNoWeekOfYear {
   
	
	public GetNoWeekOfYear() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * noWeekByNow:(). <br/> 
	 * TODO(一年中的第几星期).<br/> 
	 * 
	 * @author yxd 
	 * @return
	 */
	public int noWeekByNow(){
		int week=  0;
		String dateStr= null;
		Date dat=new Date(System.currentTimeMillis());  
	    GregorianCalendar gc = new GregorianCalendar();   
	    gc.setTime(dat);  
	    java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");  
	    dateStr=format.format(gc.getTime());  
	    System.out.println(dateStr);
	    
	    /**
	     * 计算某年
	     */
	    String dateStr1 = "2015-4-6";
	    Date d = null;
	    try {
			 d= format.parse(dateStr1);
		} catch (ParseException e) {
			e.printStackTrace();
		}//将字符串转换成date类型
	    Calendar c=Calendar.getInstance();
        c.setTime(d);
        week=c.get(Calendar.WEEK_OF_YEAR);
        System.err.println(week);
		return week;
	}
}
  