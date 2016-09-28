
package com.qtz.ht.user.service.impl;  

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.qtz.ht.user.service.ReadFileService;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:ReadFileServiceImpl <br/> 
 * Function: TODO (读取数据到数据库中). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月28日 上午10:42:41 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Service("readFileServiceImpl")
public class ReadFileServiceImpl implements ReadFileService {

	@Override
	public List<CpiaoYxd> loadScoreInfo(String xlsPath) throws IOException,
			BiffException {

		//导入已存在的Excel文件，获得只读的工作薄对象
        FileInputStream fis=new FileInputStream(xlsPath);
        Workbook wk=Workbook.getWorkbook(fis);
        Sheet[] sheets = wk.getSheets();
        if (sheets.length <=0) {
			return null;
		}
        List<CpiaoYxd> list = new ArrayList<CpiaoYxd>();
        for (int i = 0; i < sheets.length; i++) {
        	Sheet sheet=wk.getSheet(i);
        	//获取总行数
        	int rowNum=sheet.getRows();
        	//从数据行开始迭代每一行
        	for(int j=1;j<rowNum;j++){
        		String cId = sheet.getCell(0, j).getContents();
    			CpiaoYxd cpiaoYxd=new CpiaoYxd();
        		if (null != cId && cId.trim().length()>0) {
        			cpiaoYxd.setDmId(Long.valueOf(cId.trim()));
				}
        		String cNumber = sheet.getCell(1, j).getContents();//第二列
        		if(cNumber!=null&&cNumber.trim().length()>0){
        			//去掉+
        			String[] numberArr=cNumber.replace(" + ", " ").split(" ");
        			if(numberArr!=null&&numberArr.length>0&&numberArr.length==7){
        				for (int k = 0; k < numberArr.length; k++) {
							if(k==0){
								cpiaoYxd.setNumber1(Integer.parseInt(numberArr[0]));
							}
							if(k==1){
								cpiaoYxd.setNumber2(Integer.parseInt(numberArr[1]));
							}
							if(k==2){
								cpiaoYxd.setNumber3(Integer.parseInt(numberArr[2]));
							}
							if(k==3){
								cpiaoYxd.setNumber4(Integer.parseInt(numberArr[3]));
							}
							if(k==4){
								cpiaoYxd.setNumber5(Integer.parseInt(numberArr[4]));
							}
							if(k==5){
								cpiaoYxd.setNumber6(Integer.parseInt(numberArr[5]));
							}
							if(k==6){
								cpiaoYxd.setNumber7(Integer.parseInt(numberArr[6]));
							}
						}
        			}
        		}
        		//获取出彩时间
        		String cDate = sheet.getCell(10, j).getContents();//第二列
        		cpiaoYxd.setDateline(cDate);
        		//
    			list.add(cpiaoYxd);

        	}
		}
        fis.close();
        wk.close();
        return list;
	
		}

}
  