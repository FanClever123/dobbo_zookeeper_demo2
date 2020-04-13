package com.java.zd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author djin
 *    基础控制器层
 * @param <T>
 */
public class BaseController<T> {
	
	protected Map<String,Object> map = new HashMap<String,Object>();
	
	protected List<T> list = new ArrayList<T>();
	
	//访问数据成功的常量
	protected static final Integer SUCCESSCODE = 0;
	//访问数据失败的常量
	protected static final Integer FAILCODE = 200;
	//访问数据失败的数据条数
	protected static final Integer FAILCOUNT = 0;
	//访问数据失败时的提示
	protected static final String FAILMSG = "数据访问失败！！！";
	//员工离职提醒的常量
	protected static final String JURISDICTION = "jurisdiction";
	//操作成功的常量
	protected static final String SUCCESS = "success";
	//操作失败的常量
	protected static final String FAIL = "fail";
	//操作异常的常量
	protected static final String ERROR = "error";

	/**
	 * 
	 * @param code  1 成功  0 失败  
	 * @param msg   消息内容
	 * @param count 最大条数
	 * @param data  具体内容
	 * @return
	 */
	public Map<String,Object> putMsgToJsonString(int code,String msg,int count ,Object data){
		map.put("code", code);
		map.put("msg", msg);
		map.put("count", count);
		map.put("data", data);
		return map;
	}
	

}
