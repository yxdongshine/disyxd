
package com.qtz.ht.user.service.impl;  

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.core.common.FifteenLongId;
import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.mall.core.exception.ServiceException;
import com.mall.core.log.LogTool;
import com.mall.core.service.impl.BaseServiceImpl;
import com.qtz.ht.user.dao.CaiPiaoDao;
import com.qtz.ht.user.service.CaipiaoService;
import com.qtz.ht.user.service.ReadFileService;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:CaiPiaServiceImpl <br/> 
 * Function: TODO (实现彩票service服务接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午9:03:51 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Service("caiPiaServiceImpl")
public class CaiPiaServiceImpl extends BaseServiceImpl<CpiaoYxd,Long> implements CaipiaoService  {

	/**初始化日志对象*/
	private static LogTool log = LogTool.getInstance(CaiPiaServiceImpl.class);
	
    /**
     * 原始数据结构列 
     */
		Map<Integer,Integer> allNumber = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no1 = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no2 = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no3 = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no4 = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no5 = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no6 = new HashMap<Integer, Integer>(); 
		Map<Integer,Integer> no7 = new HashMap<Integer, Integer>(); 

	/**
	 * 概率数据结构类	
	 */
		Map<Integer,Double> allNumberRate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no1Rate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no2Rate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no3Rate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no4Rate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no5Rate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no6Rate = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no7Rate = new HashMap<Integer, Double>(); 
	
		/**
		 * 最后概率数据结构类	
		 */
		Map<Integer,Double> no1RateLast = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no2RateLast = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no3RateLast = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no4RateLast = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no5RateLast = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no6RateLast = new HashMap<Integer, Double>(); 
		Map<Integer,Double> no7RateLast = new HashMap<Integer, Double>(); 	
	/**
	 * 注入dao层
	 */
	@Resource(name="caiPiaoDaoImpl")
    private CaiPiaoDao dao;
	@Autowired
	private ReadFileService readFileService;
	/**
	 * 自增长主键编号
	 */
    @Autowired
    private FifteenLongId FifteenLongIdImpl;
    
	
	@Override
	protected LogTool getLog() {
		// TODO Auto-generated method stub
		return log;
	}

	@Override
	protected BizDao<CpiaoYxd, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	/**
	 * service层添加
	 */
	@Override
	public void batchInsertCpiaoService(List<CpiaoYxd> cpList)
			throws ServiceException {
		// TODO Auto-generated method stub
		try {
			dao.batchInsertList(cpList);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int dataCount() throws ServiceException {
		// TODO Auto-generated method stub
		int count = 0;
		CpiaoYxd cp= new CpiaoYxd();
		List<CpiaoYxd> cpList = null;
		try {
			cpList = dao.findList(cp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if(cpList!=null){
			count= cpList.size();
		}
		return count;
	}

	@Override
	public String getCaiPiaoStatistics() throws ServiceException {
		// TODO Auto-generated method stub
		CpiaoYxd cp= new CpiaoYxd();
		List<CpiaoYxd> cpList = null;
		try {
			cpList = dao.findList(cp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if(cpList!=null){// 统计出现的次数
			initMap();
			for (Iterator iterator = cpList.iterator(); iterator.hasNext();) {
				CpiaoYxd cpiaoYxd = (CpiaoYxd) iterator.next();
				int number1 =cpiaoYxd.getNumber1();
				swichCount(no1, number1);
				int number2 = cpiaoYxd.getNumber2();
				swichCount(no2, number2);
				int number3 = cpiaoYxd.getNumber3();
				swichCount(no3, number3);
				int number4 = cpiaoYxd.getNumber4();
				swichCount(no4, number4);
				int number5 = cpiaoYxd.getNumber5();
				swichCount(no5, number5);
				int number6 = cpiaoYxd.getNumber6();
				swichCount(no6, number6);
				int number7 = cpiaoYxd.getNumber7();
				swichCount(no7, number7);
			}
		}
		
		recommendNumber();
	
		return null;
	}
	
	/**
	 * 推荐并且计算
	 * recommendNumber:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd
	 */
	public void recommendNumber(){
		//统计 计算概率
		countRate();
		//计算概率
		countLastRate();
		//最后排序七列的大小概率 最小的在最前面
		count7();
	}
	
	/**
	 * 初始化所用的集合1-35数字出现次数为0
	 * initMap:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd
	 */
	public void initMap(){

		for (int i = 1; i <= 35; i++) {//初始化所用的集合1-35数字出现次数为0
			allNumber.put(i, 0);
			no1.put(i, 0);
			no2.put(i, 0);
			no3.put(i, 0);
			no4.put(i, 0);
			no5.put(i, 0);
			no6.put(i, 0);
			no7.put(i, 0);

	    }
	}
	
	/**
	 * 根据不同的numX1234567列数据 统计每个列 和总的出现次数
	 * swichCount:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param noMap
	 * @param numX
	 */
	public void swichCount(Map<Integer, Integer> noMap , int numX){
		switch (numX) {
		case 1:
			noMap.put(1, noMap.get(1)+1);
			allNumber.put(1, allNumber.get(1)+1);
			break;
		case 2:
			noMap.put(2, noMap.get(2)+1);
			allNumber.put(1, allNumber.get(2)+1);
			break;
		case 3:
			noMap.put(3, noMap.get(3)+1);
			allNumber.put(3, allNumber.get(3)+1);
			break;
		case 4:
			noMap.put(4, noMap.get(4)+1);
			allNumber.put(4, allNumber.get(4)+1);
			break;
		case 5:
			noMap.put(5, noMap.get(5)+1);
			allNumber.put(5, allNumber.get(5)+1);
			break;
		case 6:
			noMap.put(6, noMap.get(6)+1);
			allNumber.put(6, allNumber.get(6)+1);
			break;
		case 7:
			noMap.put(7, noMap.get(7)+1);
			allNumber.put(7, allNumber.get(7)+1);
			break;
		case 8:
			noMap.put(8, noMap.get(8)+1);
			allNumber.put(8, allNumber.get(8)+1);
			break;
		case 9:
			noMap.put(9, noMap.get(9)+1);
			allNumber.put(9, allNumber.get(9)+1);
			break;
		case 10:
			noMap.put(10, noMap.get(10)+1);
			allNumber.put(10, allNumber.get(10)+1);
			break;
		case 11:
			noMap.put(11, noMap.get(11)+1);
			allNumber.put(11, allNumber.get(11)+1);
			break;
		case 12:
			noMap.put(12, noMap.get(12)+1);
			allNumber.put(12, allNumber.get(12)+1);
			break;
		case 13:
			noMap.put(13, noMap.get(13)+1);
			allNumber.put(13, allNumber.get(13)+1);
			break;
		case 14:
			noMap.put(14, noMap.get(14)+1);
			allNumber.put(14, allNumber.get(14)+1);
			break;
		case 15:
			noMap.put(15, noMap.get(15)+1);
			allNumber.put(15, allNumber.get(15)+1);
			break;
		case 16:
			noMap.put(16, noMap.get(16)+1);
			allNumber.put(16, allNumber.get(16)+1);
			break;
		case 17:
			noMap.put(17, noMap.get(17)+1);
			allNumber.put(17, allNumber.get(17)+1);
			break;
		case 18:
			noMap.put(18, noMap.get(18)+1);
			allNumber.put(18, allNumber.get(18)+1);
			break;
		case 19:
			noMap.put(19, noMap.get(19)+1);
			allNumber.put(19, allNumber.get(19)+1);
			break;
		case 20:
			noMap.put(20, noMap.get(20)+1);
			allNumber.put(20, allNumber.get(20)+1);
			break;
		case 21:
			noMap.put(21, noMap.get(21)+1);
			allNumber.put(21, allNumber.get(21)+1);
			break;
		case 22:
			noMap.put(22, noMap.get(22)+1);
			allNumber.put(22, allNumber.get(22)+1);
			break;
		case 23:
			noMap.put(23, noMap.get(23)+1);
			allNumber.put(23, allNumber.get(23)+1);
			break;
		case 24:
			noMap.put(24, noMap.get(24)+1);
			allNumber.put(24, allNumber.get(24)+1);
			break;
		case 25:
			noMap.put(25, noMap.get(25)+1);
			allNumber.put(25, allNumber.get(25)+1);
			break;
		case 26:
			noMap.put(26, noMap.get(26)+1);
			allNumber.put(26, allNumber.get(26)+1);
			break;
		case 27:
			noMap.put(27, noMap.get(27)+1);
			allNumber.put(27, allNumber.get(27)+1);
			break;
		case 28:
			noMap.put(28, noMap.get(28)+1);
			allNumber.put(28, allNumber.get(28)+1);
			break;
		case 29:
			noMap.put(29, noMap.get(29)+1);
			allNumber.put(29, allNumber.get(29)+1);
			break;
		case 30:
			noMap.put(30, noMap.get(30)+1);
			allNumber.put(30, allNumber.get(30)+1);
			break;
		case 31:
			noMap.put(31, noMap.get(31)+1);
			allNumber.put(31, allNumber.get(31)+1);
			break;
		case 32:
			noMap.put(32, noMap.get(32)+1);
			allNumber.put(32, allNumber.get(32)+1);
			break;
		case 33:
			noMap.put(33, noMap.get(33)+1);
			allNumber.put(33, allNumber.get(33)+1);
			break;
		case 34:
			noMap.put(34, noMap.get(34)+1);
			allNumber.put(34, allNumber.get(34)+1);
			break;
		case 35:
			noMap.put(35, noMap.get(35)+1);
			allNumber.put(35, allNumber.get(35)+1);
			break;
		default:
			break;
		}
	}

	/**
	 * 根据每个列表内数据算出出现的概率
	 * swichRate:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param noMap
	 * @param numX
	 */
	public void swichRate(Map<Integer, Integer> noMap , Map<Integer, Double> rateMap){
		//迭代算出总数
		Double totalTimes  = 0.0;//
		for (Iterator iterator = noMap.values().iterator(); iterator.hasNext();) {
			Integer value = (Integer) iterator.next();
			totalTimes+=value;//计算出总出现次数
		}
		//计算概率
		for (Iterator iterator = noMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
			Integer key = entry.getKey();
			Integer value = entry.getValue();
            //装入ratemap中
			rateMap.put(key, value/totalTimes);
		}
        
	}
	
	/**
	 * 统计所有出现的概率集合
	 * countRate:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd
	 */
	public void countRate(){
		swichRate(allNumber, allNumberRate);//总概率
		swichRate(no1, no1Rate);
		swichRate(no2, no2Rate);
		swichRate(no3, no3Rate);
		swichRate(no4, no4Rate);
		swichRate(no5, no5Rate);
		swichRate(no6, no6Rate);
		swichRate(no7, no7Rate);
	}
	
	/**
	 * 
	 * conutRateLastEveryone:(). <br/> 
	 * TODO(计算所有的最后每列概率).<br/> 
	 * 
	 * @author yxd 
	 * @param rateMap 某一列概率
	 * @param rateMapAll 全部概率
	 * @param rateMapLast 最后计算得出的某一列概率
	 */
	public void conutRateLastEveryone(Map<Integer, Double> rateMap,Map<Integer, Double> rateMapAll,Map<Integer, Double> rateMapLast){
		
		for (Iterator iterator = rateMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, Double> entry = (Map.Entry<Integer, Double>) iterator.next();
			Integer key = entry.getKey();
			Double value = entry.getValue();
            
			Double lastRateOneCell = value*rateMapAll.get(key);
			//设置进去
			rateMapLast.put(key, lastRateOneCell);
		}
	}
	
	/**
	 * 统计最后七列数据概率
	 * countLastRate:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd
	 */
	public void countLastRate(){
		conutRateLastEveryone(no1Rate, allNumberRate, no1RateLast);
		conutRateLastEveryone(no2Rate, allNumberRate, no2RateLast);
		conutRateLastEveryone(no3Rate, allNumberRate, no3RateLast);
		conutRateLastEveryone(no4Rate, allNumberRate, no4RateLast);
		conutRateLastEveryone(no5Rate, allNumberRate, no5RateLast);
		conutRateLastEveryone(no6Rate, allNumberRate, no6RateLast);
		conutRateLastEveryone(no7Rate, allNumberRate, no7RateLast);
	}
	
	
	/**
	 * 
	 * sortRateLastList:(). <br/> 
	 * TODO(计算某一列).<br/> 
	 * 
	 * @author yxd 
	 * @param rateMapLast
	 * @return
	 */
	public int sortRateLastList(Map<Integer, Double> rateMapLast){
		int number =0;
/*        HashMap<Integer, Double> map_Data=new HashMap<Integer, Double>();  
        map_Data.put(1, 98.0);  
        map_Data.put(2, 50.0);  
        map_Data.put(3, 51.0);  
        map_Data.put(4, 25.0);  
        map_Data.put(5, 85.0);  
        System.out.println(map_Data);  */
        List<Map.Entry<Integer, Double>> list_Data = new ArrayList<Map.Entry<Integer, Double>>(rateMapLast.entrySet());  
        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Double>>()  
          {   
              public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2)  
              {  
               if(o2.getValue()!=null&&o1.getValue()!=null&&o2.getValue().compareTo(o1.getValue())>0){  
                return -1;  
               }else{  
                return 1;  
               }  
                  
              }  
          });  
        System.out.println(list_Data); 
        number = list_Data.get(0).getKey();
        return number;
	}
	
	/**
	 * 计算最后七个数字
	 * count7:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd
	 */
	public void count7(){
		int number1 =sortRateLastList(no1RateLast);
		int number2 =sortRateLastList(no2RateLast);
		int number3 =sortRateLastList(no3RateLast);
		int number4 =sortRateLastList(no4RateLast);
		int number5 =sortRateLastList(no5RateLast);
		int number6 =sortRateLastList(no6RateLast);
		int number7 =sortRateLastList(no7RateLast);

	  System.out.println("**number1**"+number1+"**number2**"+number2+"**number3**"+number3+"**number4**"+number4+"**number5**"+number5+"**number6**"+number6+"**number7**"+number7);
	}

	public ReadFileService getReadFileService() {
		return readFileService;
	}

	public void setReadFileService(ReadFileService readFileService) {
		this.readFileService = readFileService;
	}
	
	
}
  