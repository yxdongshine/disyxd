
package com.yxd.hadoop.test.buyticket;  
/** 
 * ClassName:TicketThread <br/> 
 * Function: TODO (购买票线程类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月26日 下午2:42:30 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class TicketThread implements Runnable {

	/**
	 * 第几个窗口 窗口数
	 */
	private int windowNo=0;
	private int ticketNo=0;
	public TicketThread(int windowNo,int ticketNo) {
		// TODO Auto-generated constructor stub
		this.windowNo = windowNo;
		this.ticketNo = ticketNo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int remain = TicketManage.buyTicket();
		System.out.println("窗口1："+remain+"........"+"窗口"+windowNo+":"+ticketNo);
	}
	public int getWindowNo() {
		return windowNo;
	}
	public void setWindowNo(int windowNo) {
		this.windowNo = windowNo;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	
}
  