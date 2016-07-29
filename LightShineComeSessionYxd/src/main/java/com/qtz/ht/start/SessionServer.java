package com.qtz.ht.start;

import java.net.URL;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mall.core.cache.BaseProperties;

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
			while (true){
				TimeUnit.HOURS.sleep(1);
			}
		} catch (Exception e) {
			log.error("服务启动失败！",e);
		}
	}

}
