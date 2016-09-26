
package com.yxd.hadoop.test.computerinter;  

import com.yxd.hadoop.test.object.HardDiskInfo;


/** 
 * ClassName:HardDiskCapacityInterface <br/> 
 * Function: TODO (盘的接口HardDisk). <br/> 
 * Reason:   TODO (返回容量). <br/> 
 * Date:     2016年9月23日 上午10:49:37 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public interface HardDiskCapacityInterface {

	/**
	 * 
	 * getHardDiskCapacity:(). <br/> 
	 * TODO(返回容量HardDiskInfo).<br/> 
	 * 
	 * @author yxd 
	 * @param HardDiskInfo 
	 * @return
	 */
	HardDiskInfo getHardDiskCapacity(HardDiskInfo hardDiskInfo);
}
  