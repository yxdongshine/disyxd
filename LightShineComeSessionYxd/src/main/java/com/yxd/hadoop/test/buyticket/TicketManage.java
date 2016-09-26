
package com.yxd.hadoop.test.buyticket;  
/** 
 * ClassName:TicketManage <br/> 
 * Function: TODO (票管理类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月26日 下午2:44:50 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class TicketManage {

	//总票数
	private static int ticketToltalNumber = 100;


	public static synchronized int buyTicket(){
		
		ticketToltalNumber=ticketToltalNumber -1;
		
		return ticketToltalNumber;
	}
	
	

	/**
	 * 
	 * simulationBuyTicket:(). <br/> 
	 * TODO(模拟三个窗口买票).<br/> 
	 * 
	 * @author yxd
	 */
	 public static void simulationBuyTicket(){
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
  