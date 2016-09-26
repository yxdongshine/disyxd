
package com.yxd.hadoop.test.object;  

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/** 
 * ClassName:YangXiaoDong <br/> 
 * Function: TODO (截取的字节数，则根据要求输出对应的字符串). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月26日 上午9:42:59 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class YangXiaoDong {
	
	public YangXiaoDong() {
		// TODO Auto-generated constructor stub
	}
	
	public void subStringByNumber(){
		System.out.println("请输入字符串:");
		Scanner scanner = new Scanner(System.in);
		String inputText = scanner.nextLine();
		
		
		System.out.println("请输入要截取的字节数:");
		int spileNum = scanner.nextInt();
		if(inputText==null||inputText.trim().length()<=0){
			System.out.println("输入异常！！！");
			return;
		}
		
		//转成gbk
		byte[] b = null;
		try {
			b=inputText.trim().getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 
		 //判断截取数字范围
		int lastNum = 0;
		int byteNum = b.length;
		if(spileNum==0){//如果截取数为0的话就什么都不截取
			lastNum = 0;
		}else if(spileNum>byteNum){//如果截取数字大于字节数组数 就是字节数组数字
			lastNum = byteNum;
		}else {
			lastNum = spileNum;
		}
		if(b[lastNum]<0){//这个位置的字节码小于0 表示半个汉字
			//由于是向后退位原则 则减一
			lastNum = lastNum-1;
		}
		
		//开始截取
		String lastString="";
		try {
			lastString = new String(b, 0, lastNum,"GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(lastString);
	}
	
}
  