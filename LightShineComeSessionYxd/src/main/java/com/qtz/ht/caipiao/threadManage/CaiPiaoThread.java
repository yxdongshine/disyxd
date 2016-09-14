
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
	CpiaoPullData cpiaoPullData;//拉取数据
	private int count;//统计拉取的次数
	public CaiPiaoThread(int count) {
		// TODO Auto-generated constructor stub
		count =count;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("***第"+count+"次拉取数据开始");
		cpiaoPullData.makeCpiaoData(count,null);
		System.out.println("***第"+count+"次拉取数据结束");
	}

}
  