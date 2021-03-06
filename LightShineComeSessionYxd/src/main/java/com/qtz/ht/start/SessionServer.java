package com.qtz.ht.start;

import java.net.URL;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mall.core.cache.BaseProperties;
import com.mall.core.common.SpringContextHolder;
import com.mall.core.exception.ServiceException;
import com.qtz.ht.caipiao.threadManage.ThreadPoolMan;
import com.qtz.ht.user.service.impl.CaiPiaServiceImpl;

public class SessionServer {

	
	private static Logger log = LoggerFactory.getLogger(SessionServer.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		try {
			BaseProperties.writePidToFile();
			final URL url = SessionServer.class.getResource("/config/log4j.xml");
			String str= URLDecoder.decode(url.toString(),"UTF-8");
			DOMConfigurator.configure(url);
			BaseProperties.initMap("config/base.properties");
			log.warn("========SessionServer准备启动服务========");
			
			log.info("基础配置文件初始化");
			String[] strings= BaseProperties.getBaseProperties("START_FILES").split(",");
			new ClassPathXmlApplicationContext(strings);
			log.warn("========SessionServer启动服务成功========");
            //这里通过spring工厂去拿出来
			ThreadPoolMan thm= SpringContextHolder.getBean("threadPoolMan");
			//CaiPiaServiceImpl
			CaiPiaServiceImpl cpsi= SpringContextHolder.getBean("caiPiaServiceImpl");
			/*if(cpsi.dataCount()<=0){
				thm.pollingPullCaipData();
			}*/
			if(cpsi.dataCount()<=0){
				//最后每一次调用的接口都进入数据库
				try {
					cpsi.batchInsertCpiaoService(cpsi.getReadFileService().loadScoreInfo("D:\\yxd.xls"));
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
			thm.pollingPullCaipDataByDay();
			log.warn("========拉取数据完成成功========");
			while (true){
				TimeUnit.HOURS.sleep(1);
			}
		} catch (Exception e) {
			log.error("服务启动失败！",e);
		}
	}

}
