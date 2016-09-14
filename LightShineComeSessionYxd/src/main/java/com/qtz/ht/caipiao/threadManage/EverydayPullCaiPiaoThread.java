
package com.qtz.ht.caipiao.threadManage;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qtz.ht.caipiao.function.CpiaoPullData;
import com.qtz.ht.caipiao.function.UtilTool;

/** 
 * ClassName:EverydayPullCaiPiaoThread <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月14日 下午5:01:54 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Component
public class EverydayPullCaiPiaoThread implements Runnable{

	private String dataStr;//传入的彩票日期
	@Autowired
	CpiaoPullData cpiaoPullData;//拉取数据
	public EverydayPullCaiPiaoThread(String dataStr) {
		// TODO Auto-generated constructor stub
		this.dataStr = dataStr;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String date = UtilTool.formatDate(System.currentTimeMillis());
		cpiaoPullData.makeCpiaoData(0,date);
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}

	
}
  