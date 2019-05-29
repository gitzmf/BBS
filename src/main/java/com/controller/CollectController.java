package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pojo.Collect;
import com.service.ICollectService;

@RequestMapping("/collectController")
@Controller
public class CollectController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ICollectService collectService;
	
	
	/**
	 * 删除收藏（按sid）
	 * @param collect
	 * @return
	 */
	@RequestMapping("/deleteCollect")
	public String deleteCollect(Collect collect){
		logger.info("deleteCollect()方法被调用");
		try {
			collectService.deleteCollect(collect);
		}catch (Exception e){
			logger.error(e+"deleteCollect()方法调用失败");
		}
		return "redirect:/index.jsp";//重定向
	}
	
	/**
	 * 删除收藏（按userid和fid）
	 * @param collect
	 * @return
	 */
	@RequestMapping("/deleteCollectUseridAndFid")
	public String deleteCollectUseridAndFid(Collect collect){
		logger.info("deleteCollectUseridAndFid()方法被调用");
		try {
			collectService.deleteCollectUseridAndFid(collect);
		}catch (Exception e){
			logger.error(e+"deleteCollectUseridAndFid()方法调用失败");
		}
		return "redirect:../userController/getMyself";//重定向
	}
	
	/**
	 * 添加收藏
	 * @param collect
	 * @return
	 */
	@RequestMapping("/setCollect")
	public String setCollect(Collect collect){
		logger.info("setCollect()方法被调用");
		try {
			collectService.setCollect(collect);
		}catch (Exception e){
			logger.error(e+"setCollect()方法调用失败");
		}
		return "redirect:/index.jsp";//重定向
	}
	
}
