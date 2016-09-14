
package LightShineComeSession.LightShineComeSessionYxd;  

import java.util.Date;
import java.util.GregorianCalendar;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sd=System.currentTimeMillis();  
        Date dat=new Date(sd);  
        GregorianCalendar gc = new GregorianCalendar();   
        gc.setTime(dat);  
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");  
        String sb=format.format(gc.getTime());  
        System.out.println(sb);  
	}

}
  