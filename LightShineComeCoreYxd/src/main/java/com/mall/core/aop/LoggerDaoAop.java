package com.mall.core.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import com.mall.core.common.Global;
import com.mall.core.exception.DaoException;
import com.mall.core.log.LogTool;
public class LoggerDaoAop {

	/**初始化日志对象*/
	private static LogTool log = LogTool.getInstance(LoggerDaoAop.class);
	
	
	/** 
	* 【拦截】方法
	* @param 	pjp					ProceedingJoinPoint对象	
	* @return	Object				Object对象
	* @throws 	DaoException  		DAO异常服务对象
	*/
	
	public Object record(ProceedingJoinPoint pjp) throws DaoException {
		Object[] params = pjp.getArgs();		//操作参数 				
		String mname = Global.LOG_DAO + pjp.getTarget().getClass().getName() + ":" + pjp.getSignature().getName() + "(" + objectToStr(params) + ")";		//操作名称
		if (log.isDebugEnabled()) log.debug(mname + "调用【开始】了！");
		try {
			Object ret = pjp.proceed();	//调用目标对象的方法
			return ret;
		} catch (Throwable e) {
			log.error(mname + "调用【报错】了！", e);
			throw new DaoException(mname + "调用【报错】了！", e);
		} finally {
			if (log.isDebugEnabled()) log.debug(mname + "调用【结束】了！");
		}
	}
	
	
	/** 
	* 【转换】方法
	* @param 	params		参数数组
	* @return  	String		字符串
	*/
	
	public String objectToStr(Object[] params) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (Object object : params) {
			if (null == object) continue;
			if (i > 0) sb.append(",");
			sb.append(object.toString());
			i++;
		}
		return sb.toString();
	}

}
