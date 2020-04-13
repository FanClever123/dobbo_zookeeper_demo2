package com.java.zd.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
	
	//添加
	String save(T t) throws Exception;
	
	//修改
	String upd(T t) throws Exception;
	
	//删除
	String remove(T t) throws Exception;
	
	//批量删除
	String removeBatch(Integer[] ids) throws Exception;
	
    //根据条件查询单个结果
    T findObjectByPramas(T t) throws Exception;
    
    //查询所有
  	List<T> findAll() throws Exception;
  	
    //根据单个其它条件查询多个结果集
  	List<T> findManyByOtherPramas(Object obj) throws Exception;
    
    //根据条件（无条件）查询多个结果
  	List<T> findManyByPramas(T t) throws Exception;
	
	//根据条件(无条件)分页查询layui的table
	Map<String,Object> findListByPramas(Integer page, Integer limit, T t) throws Exception;
	
	//获取表的数据记录条数
	Long getTotalByPramas(T t) throws Exception;
	
	//根据条件分页查询，一般分页
	PageInfo<T> findPageByPramas(Integer page, Integer limit, T t) throws Exception;
	
	//获取数据页数
	Integer getTotalPageByPramas(Integer pageSize, T t) throws Exception;
	
}
