package com.java.zd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.java.zd.model.GoodEntity;
import com.java.zd.service.GoodService;
 
/**
 * 
 * @author djin
 *   Good控制器
 * @date 2020-04-11 16:53:13
 */
@Controller
@RequestMapping("/good")
public class GoodController extends BaseController<GoodEntity>{

    @Reference(version = "1.0.0")
    private GoodService goodService;
	
	/**
	 * 页面jsp
	 */
	@RequestMapping("/page")
	public String page(){
		return "good";
	}

    /**
     * 页面html
     */
    @RequestMapping("/html")
    public String html(){
        return "redirect:/static/html/good.html";
    }

    /**
	 * 加载（分页） 根据是否存在条件加载
	 */
    @RequestMapping("/listByPramas")
    @ResponseBody
    public Map<String, Object> listByPramas(Integer page, Integer limit, GoodEntity good){
        try {
            map = goodService.findListByPramas(page, limit, good);
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
    public PageInfo<GoodEntity> pageByPramas(Integer page, Integer limit, GoodEntity good){
        try {
            return goodService.findPageByPramas(page,limit,good);
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
    public GoodEntity loadObjectByPramas(GoodEntity good){
        try {
            return goodService.findObjectByPramas(good);
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
    public List<GoodEntity> loadAll(){
        try {
            return goodService.findAll();
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
    public String delete(GoodEntity good){
        try {
            return goodService.remove(good);
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
            return goodService.removeBatch(ids);
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
    public String saveT(GoodEntity good){
        try {
            return goodService.save(good);
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
    public String updT(GoodEntity good){
        try {
            return goodService.upd(good);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

}
