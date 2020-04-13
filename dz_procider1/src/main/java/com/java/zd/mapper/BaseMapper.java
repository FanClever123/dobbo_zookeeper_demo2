package com.java.zd.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  方法名与mybatis 映射文件SQL ID对应
 */
public interface BaseMapper<T> {
	
	//添加
	Integer insert(T t) throws Exception;
	
	//修改
	Integer update(@Param("t") T t) throws Exception;
	
	//根据条件删除
	Integer delete(@Param("t") T t) throws Exception;
	
    //批量删除
	Integer deleteBatch(Object[] id) throws Exception;
	
	//根据条件查询单个结果
	T queryObjectByPramas(@Param("t") T t) throws Exception;
	
	//根据id查询单个结果
	T queryObjectById(Integer id) throws Exception;
	
	//查询所有
	List<T> queryAll() throws Exception;
	
	//根据其它条件查询多个结果集
	List<T> queryManyByOtherPramas(Object obj) throws Exception;
	
	//根据条件（无条件）查询多个结果集
	List<T> queryManyByPramas(@Param("t") T t) throws Exception;
	
	//根据条件（无条件）分页查询
	List<T> queryListByPramas(@Param("t") T t) throws Exception;
	
	//根据条件（无条件）查询数据条数
	Long queryTotalByPramas(@Param("t") T t) throws Exception;
	
}
