
package com.yxd.hadoop.test.object;  

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 * ClassName:CopyFile <br/> 
 * Function: TODO (用Buffer封装输入输出流高效实现). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月26日 下午2:23:16 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class CopyFile {

	/**
	 * copyFileByBuffer:(). <br/> 
	 * TODO(用Buffer封装输入输出流高效实现).<br/> 
	 * 
	 * @author yxd 
	 * @throws IOException
	 */
	public  void copyFileByBuffer()throws IOException{  
		File srcFile = new File("D:\\test\\Client.java");
    	File destFile = new File("d:\\Client.java");
    	if(destFile.exists()){//如果存在就删除掉
    		destFile.delete();
    		//再创建
    		destFile.mkdir();
    	}
		if(!srcFile.exists()){  
            throw new IllegalArgumentException("源文件:"+srcFile+"不存在");  
        }  
        if(!srcFile.isFile()){  
            throw new IllegalArgumentException(srcFile+"不是文件");  
        }  
        BufferedInputStream bis = new BufferedInputStream(  
                new FileInputStream(srcFile));  
        BufferedOutputStream bos = new BufferedOutputStream(  
                new FileOutputStream(destFile));  
        int c ;  
        while((c = bis.read())!=-1){  
            bos.write(c);  
            bos.flush();//刷新缓冲区  
        }  
        //关闭流 节约资源
        bis.close();  
        bos.close();  
    }  
}
  