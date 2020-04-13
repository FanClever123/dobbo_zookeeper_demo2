package com.java.zd.model;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author djin
 *    Good实体类
 * @date 2020-04-11 16:53:13
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class GoodEntity implements Serializable{

	  private static final long serialVersionUID = 1L;
	
      //商品编号
	  private Integer id;
      //商品名称
	  private String gname;
      //价格
	  private Double price;
      //商品创建时间
      @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss" ,timezone = "GMT+8")
	  private Date makedate;
      //商品类型id
	  private Integer tid;
      //库存量
	  private Integer nums;
      //销量
	  private Integer sales;

	  /**
	   * 设置：商品编号
	   */
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  /**
	   * 获取：商品编号
	   */
	  public Integer getId() {
	   	  return id;
	  }
	  /**
	   * 设置：商品名称
	   */
	  public void setGname(String gname) {
		  this.gname = gname;
	  }
	  /**
	   * 获取：商品名称
	   */
	  public String getGname() {
	   	  return gname;
	  }
	  /**
	   * 设置：价格
	   */
	  public void setPrice(Double price) {
		  this.price = price;
	  }
	  /**
	   * 获取：价格
	   */
	  public Double getPrice() {
	   	  return price;
	  }
	  /**
	   * 设置：商品创建时间
	   */
	  public void setMakedate(Date makedate) {
		  this.makedate = makedate;
	  }
	  /**
	   * 获取：商品创建时间
	   */
	  public Date getMakedate() {
	   	  return makedate;
	  }
	  /**
	   * 设置：商品类型id
	   */
	  public void setTid(Integer tid) {
		  this.tid = tid;
	  }
	  /**
	   * 获取：商品类型id
	   */
	  public Integer getTid() {
	   	  return tid;
	  }
	  /**
	   * 设置：库存量
	   */
	  public void setNums(Integer nums) {
		  this.nums = nums;
	  }
	  /**
	   * 获取：库存量
	   */
	  public Integer getNums() {
	   	  return nums;
	  }
	  /**
	   * 设置：销量
	   */
	  public void setSales(Integer sales) {
		  this.sales = sales;
	  }
	  /**
	   * 获取：销量
	   */
	  public Integer getSales() {
	   	  return sales;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
