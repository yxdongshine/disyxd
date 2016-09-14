
package com.qtz.ht.caipiao.threadManage;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qtz.ht.caipiao.function.CpiaoPullData;

/** 
 * ClassName:CaiPiaoThread <br/> 
 * Function: TODO (拉取彩票的接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月13日 上午10:23:21 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Component
public class CaiPiaoThread implements Runnable{

	@Autowired
	CpiaoPullData cpiaoPullData ;
	private int count;//统计拉取的次数
	private String date;//日期格式
	
	public void caiPiaoThread(int count,String date) {
		// TODO Auto-generated constructor stub
		this.count =count;
		this.date =date;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("***第"+count+"次拉取数据开始");
		cpiaoPullData.makeCpiaoData(count,date);
		System.out.println("***第"+count+"次拉取数据结束");
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
  