package com.java.zd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.java.zd.model.GoodtypeEntity;
import com.java.zd.service.GoodtypeService;
 
/**
 * 
 * @author djin
 *   Goodtype控制器
 * @date 2020-04-11 16:53:13
 */
@Controller
@RequestMapping("/goodtype")
public class GoodtypeController extends BaseController<GoodtypeEntity>{

    @Reference(version = "1.0.0")
    private GoodtypeService goodtypeService;
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "goodtype";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/static/html/goodtype.html";
    }

    /**
	 * 加载（分页） 根据是否存在条件加载
	 */
    @RequestMapping("/listByPramas")
    @ResponseBody
    public Map<String, Object> listByPramas(Integer page, Integer limit, GoodtypeEntity goodtype){
        try {
            map = goodtypeService.findListByPramas(page, limit, goodtype);
            map.put("code", SUCCESSCODE);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return putMsgToJsonString(FAILCODE,FAILMSG,FAILCOUNT,null);
        }
    }

    /**
     * 加载（分页） 根据是否存在条件加载
     */
    @RequestMapping("/pageByPramas")
    @ResponseBody
    public PageInfo<GoodtypeEntity> pageByPramas(Integer page, Integer limit, GoodtypeEntity goodtype){
        try {
            return goodtypeService.findPageByPramas(page,limit,goodtype);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件查询单个结果
     *
     */
    @RequestMapping("/loadObjectByPramas")
    @ResponseBody
    public GoodtypeEntity loadObjectByPramas(GoodtypeEntity goodtype){
        try {
            return goodtypeService.findObjectByPramas(goodtype);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件查询单个结果
     *
     */
    @RequestMapping("/loadAll")
    @ResponseBody
    public List<GoodtypeEntity> loadAll(){
        try {
            return goodtypeService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件删除
     *
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(GoodtypeEntity goodtype){
        try {
            return goodtypeService.remove(goodtype);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
    * 批量删除
    */
    @RequestMapping("/deletes")
    @ResponseBody
    public String deletes(Integer[] ids){
        try {
            return goodtypeService.removeBatch(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    /**
     * 添加
     */
    @RequestMapping("/saveT")
    @ResponseBody
    public String saveT(GoodtypeEntity goodtype){
        try {
            return goodtypeService.save(goodtype);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/updT")
    @ResponseBody
    public String updT(GoodtypeEntity goodtype){
        try {
            return goodtypeService.upd(goodtype);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
