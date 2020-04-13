package com.java.zd.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author djin
 *    Goodtype实体类
 * @date 2020-04-11 16:53:13
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class GoodtypeEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
      //商品类型编号
	  private Integer tid;
      //类型名称
	  private String tname;
      //类型简介
	  private String tdesc;

	  /**
	   * 设置：商品类型编号
	   */
	  public void setTid(Integer tid) {
		  this.tid = tid;
	  }
	  /**
	   * 获取：商品类型编号
	   */
	  public Integer getTid() {
	   	  return tid;
	  }
	  /**
	   * 设置：类型名称
	   */
	  public void setTname(String tname) {
		  this.tname = tname;
	  }
	  /**
	   * 获取：类型名称
	   */
	  public String getTname() {
	   	  return tname;
	  }
	  /**
	   * 设置：类型简介
	   */
	  public void setTdesc(String tdesc) {
		  this.tdesc = tdesc;
	  }
	  /**
	   * 获取：类型简介
	   */
	  public String getTdesc() {
	   	  return tdesc;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
