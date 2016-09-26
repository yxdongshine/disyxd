
package com.yxd.hadoop.test.buyticket;  

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.mall.core.log.LogTool;

/** 
 * ClassName:ThreadPoolExecutorManage <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月26日 下午3:11:48 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class ThreadPoolExecutorManage {

	private static LogTool log = LogTool.getInstance(ThreadPoolExecutorManage.class);

	 ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5));
	 
	 public void simulationBuyTicket(){
		 int totalTicket = 100;// 总共买一百次
		 for (int i = 1; i <=totalTicket; i++) {
			int windowNo = i%3+1;//窗口号码
			int ticketNo = i;//购买的票号
            //初始化线程
			TicketThread ticketThread = new TicketThread(windowNo, ticketNo);
			//加入线程池中
			//executor.execute(ticketThread);
			ticketThread.run();
		}

	 }
}
  