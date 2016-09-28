
package com.qtz.ht.user.service;  

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:ReadFileService <br/> 
 * Function: TODO (读取文件类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月28日 上午10:36:41 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public interface ReadFileService {

	public  List<CpiaoYxd> loadScoreInfo(String xlsPath) throws IOException, BiffException;

}
  