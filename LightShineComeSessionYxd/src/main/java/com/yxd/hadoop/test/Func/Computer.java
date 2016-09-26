
package com.yxd.hadoop.test.Func;  

import com.yxd.hadoop.test.computerinter.CPUInterface;
import com.yxd.hadoop.test.computerinter.EMSInterface;
import com.yxd.hadoop.test.computerinter.HardDiskCapacityInterface;
import com.yxd.hadoop.test.computerservice.CPUImpl;
import com.yxd.hadoop.test.computerservice.EMSImpl;
import com.yxd.hadoop.test.computerservice.HardDiskCapacityImpl;
import com.yxd.hadoop.test.object.CPUInfo;
import com.yxd.hadoop.test.object.EMSInfo;
import com.yxd.hadoop.test.object.HardDiskInfo;

/** 
 * ClassName:Computer <br/> 
 * Function: TODO (计算机类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月23日 上午10:58:51 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class Computer {

	private CPUInfo cPUInfo;//计算机含有的cpu信息对象
	private EMSInfo eMSInfo;//计算机的EMS信息对象
	private HardDiskInfo hardDiskInfo;//计算机的硬盘信息对象
	
	public Computer(CPUInfo cPUInfo,EMSInfo eMSInfo,HardDiskInfo hardDiskInfo) {
		// TODO Auto-generated constructor stub
		this.cPUInfo =cPUInfo;
		this.eMSInfo = eMSInfo;
		this.hardDiskInfo =hardDiskInfo;
	}
	
	/**
	 * 
	 * display:(). <br/> 
	 * TODO(显示计算机信息).<br/> 
	 * 
	 * @author yxd 
	 */
	public void display(){
		CPUInterface cPUInterface =  new CPUImpl();
		CPUInfo getCPUInfo=cPUInterface.getComputerCpu(this.cPUInfo);
		System.out.println("***cpu信息组***\n cpu 品牌:"+getCPUInfo.getBrand()+" \n  cpu主频:"+getCPUInfo.getFrequency());
		
		EMSInterface eMSInterface = new EMSImpl();
		EMSInfo getEMSInfo = eMSInterface.getComputerEMS(this.eMSInfo);
		System.out.println("***EMS信息组***\n EMS 类型:"+getEMSInfo.getType()+" \n  cpu容量:"+getEMSInfo.getCapacity());
		
		HardDiskCapacityInterface hardDiskCapacityInterface =new  HardDiskCapacityImpl();
		HardDiskInfo getHardDiskInfo = hardDiskCapacityInterface.getHardDiskCapacity(this.hardDiskInfo);
		System.out.println("***HardDisk信息组***\n EMS 容量:"+getHardDiskInfo.getCapacity());

	}

	public CPUInfo getcPUInfo() {
		return cPUInfo;
	}

	public void setcPUInfo(CPUInfo cPUInfo) {
		this.cPUInfo = cPUInfo;
	}

	public EMSInfo geteMSInfo() {
		return eMSInfo;
	}

	public void seteMSInfo(EMSInfo eMSInfo) {
		this.eMSInfo = eMSInfo;
	}

	public HardDiskInfo getHardDiskInfo() {
		return hardDiskInfo;
	}

	public void setHardDiskInfo(HardDiskInfo hardDiskInfo) {
		this.hardDiskInfo = hardDiskInfo;
	}
	
	
}
  