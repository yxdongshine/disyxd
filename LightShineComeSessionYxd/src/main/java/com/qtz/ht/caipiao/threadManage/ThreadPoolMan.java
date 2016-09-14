
package com.qtz.ht.caipiao.threadManage;  

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.mall.core.log.LogTool;
import com.qtz.ht.caipiao.function.CpiaoPullData;
import com.qtz.ht.caipiao.function.UtilTool;

/** 
 * ClassName:ThreadPoolMan <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月14日 下午4:42:31 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Component
public class ThreadPoolMan {
	private static LogTool log = LogTool.getInstance(ThreadPoolMan.class);

	 ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
             new ArrayBlockingQueue<Runnable>(5));
	
	 /**
	  * 向线程池中添加线程
	  * addThread:(). <br/> 
	  * TODO().<br/> 
	  * 
	  * @author yxd 
	  * @param r
	  */
	 public void addThread (Runnable r){
		 executor.execute(r);
		 String str= "线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount();
		 System.out.println(str);
		 log.info(str);
	 }

	 /**
	  * 关闭线程池
	  * shutThreadPool:(). <br/> 
	  * TODO().<br/> 
	  * 
	  * @author yxd
	  */
	 public void shutThreadPool(){
		 executor.shutdown();
	 }
	 
	 /**
	  * 轮询间隔4s中拉取数据
	  * pollingPullCaipData:(). <br/> 
	  * TODO().<br/> 
	  * 
	  * @author yxd
	  */
	 public void pollingPullCaipData(){
		 while(true){
			 CaiPiaoThread ct = new CaiPiaoThread(0);
			 this.addThread(ct);
			 try {
				Thread.currentThread().sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
	 
	 /**
	  * 每天拉取一次
	  * pollingPullCaipDataByDay:(). <br/> 
	  * TODO().<br/> 
	  * 
	  * @author yxd
	  */
	 public void pollingPullCaipDataByDay(){
		 while(true){
			 CaiPiaoThread ct = new CaiPiaoThread(0);
			 this.addThread(ct);
			 try {
				Thread.currentThread().sleep(UtilTool.DAY_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
}
  