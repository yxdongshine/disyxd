
package LightShineComeSession.LightShineComeSessionYxd;  

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * ClassName:MainTest <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月14日 下午5:11:44 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class MainTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		long sd=System.currentTimeMillis();  
        Date dat=new Date(sd);  
        GregorianCalendar gc = new GregorianCalendar();   
        gc.setTime(dat);  
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm");  
        String sb=format.format(gc.getTime());  
        String startDayStr = sb.split(" ")[0]+" 00:00:00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startDayTime =  sf.parse(startDayStr).getTime();
        System.out.println(sb);  
        System.out.println(sd+"***"+startDayTime);  
        
        /***
         * 
         */
        
        Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);
        System.out.println(weekday);
        
		StringBuffer sbstr = new StringBuffer("yyyhhgg");
        System.err.println(sbstr.toString().replace("hh", "zz"));
        
        
        /**
         * 
         */
        System.out.println("*******"+2/3.0);
        
        
        HashMap<Integer, Double> map_Data=new HashMap<Integer, Double>();  
        map_Data.put(1, 98.0);  
        map_Data.put(2, 50.0);  
        map_Data.put(3, 51.0);  
        map_Data.put(4, 25.0);  
        map_Data.put(5, 85.0);  
        System.out.println(map_Data);  
        List<Map.Entry<Integer, Double>> list_Data = new ArrayList<Map.Entry<Integer, Double>>(map_Data.entrySet());  
        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Double>>()  
          {   
              public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2)  
              {  
               if(o2.getValue()!=null&&o1.getValue()!=null&&o2.getValue().compareTo(o1.getValue())>0){  
                return 1;  
               }else{  
                return -1;  
               }  
                  
              }  
          });  
        System.out.println(list_Data); 
        
        
	}

}
  