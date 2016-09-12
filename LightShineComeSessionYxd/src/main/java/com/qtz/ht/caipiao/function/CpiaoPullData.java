
package com.qtz.ht.caipiao.function;  

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;









import org.springframework.stereotype.Component;
import org.w3c.dom.CDATASection;

import com.mall.core.exception.ServiceException;
import com.qtz.ht.user.service.CaipiaoService;
import com.qtz.ht.user.service.HtUserService;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:CpiaoPullData <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午7:33:28 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Component
public class CpiaoPullData {

	@Resource(name="caiPiaServiceImpl")
	private CaipiaoService caiPiaService;
	
	public static final String NAME = "dlt";//彩票接口
	public static final String UID = "552763";//用户编号
	public static final String TOKEN = "2f82c6358d966ebf1a7c1830d03727b488fbde50";//用户token
	
	
	public void makeCpiaoData(){

		String name = "dlt";
		String uid = "552763";
		String token = "2f82c6358d966ebf1a7c1830d03727b488fbde50";

		String url = "http://api.caipiaokong.com/lottery/";
		url += "?name=" + name;
		url += "&format=json";
		url += "&uid=" + uid;
		url += "&token=" + token;

		String urlAll = new StringBuffer(url).toString();
		String charset = "UTF-8";
		String jsonResult = get(urlAll, charset);//
		JSONObject object = JSONObject.fromObject(jsonResult);//
	//实例化彩票数据集合
		List<CpiaoYxd> cpList = new ArrayList<CpiaoYxd>();
		try {
			Iterator it = object.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = object.getString(key);
				JSONObject object1 = JSONObject.fromObject(value);
				String outputStr = "id:" + key;
				String number = object1.getString("number");
				String dateLine =object1.getString("dateline");
				outputStr += " number:" + number;
				outputStr += " dateline:" + dateLine;
				System.out.println(outputStr);
				//构建彩票实体
				CpiaoYxd cp = makeCpYxd(Long.parseLong(key), number, dateLine);
				cpList.add(cp);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//最后每一次调用的接口都进入数据库
		try {
			caiPiaService.batchInsertCpiaoService(cpList);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 构建彩票数据实体
	 * makeCpYxd:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param dmid
	 * @param number
	 * @param dateLine
	 * @return
	 */
	public CpiaoYxd makeCpYxd(Long dmid,String number,String dateLine){
		CpiaoYxd cp= new CpiaoYxd();
		cp.setDmId(dmid);
		cp.setNumber(number);
		cp.setDateline(dateLine);
		
		return cp;
	}
	
	/**
	 * 获取远程接口彩票数据
	 * get:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param urlAll
	 * @param charset
	 * @return
	 */
	public  String get(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// ģ�������
		try {
			URL url = new URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
  