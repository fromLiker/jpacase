/**
 * 
 */
package com.ibm.jpacase.utils;

/**
 * @author PingXue
 *
 */
public class ResponseCode {

	protected ResponseCode() {

	}

	//a成功
	public static final int SUCCESS = 200;
	//a系统错误
	public static final int ERROR_SYS = 500;
	//a数据库操作出错
	public static final int ERROR_ACCESS_DB = 501;
	//a服务不可用
	public static final int ERROR_SERVICE_UNAVAILABLE = 405;

}

