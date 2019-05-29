package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.pojo.Attention;
import com.service.IAttentionService;

@RequestMapping("/attentionController")
@Controller
public class AttentionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IAttentionService attentionService;
	
	/**
	 * 添加关注
	 * @return
	 */
	@RequestMapping("/setAttention")
	public String setAttention(Attention attention){
		logger.info("setAttention()方法被调用");
		try {
			attentionService.setAttention(attention);
		}catch (Exception e){
			logger.error(e+"setAttention()方法调用失败");
		}
		return "redirect:/index.jsp";//重定向
	}
	
	
	/**
	 * 取消关注（首页）
	 * @param attention
	 * @return
	 */
	@RequestMapping("/deleteAttention")
	public String deleteAttention(Attention attention){
		logger.info("deleteAttention()方法被调用");
		try {
			attentionService.deleteAttention(attention);
		}catch (Exception e){
			logger.error(e+"deleteAttention()方法调用失败");
		}
		return "redirect:/index.jsp";
	}
	
	/**
	 * 取消关注（个人主页）
	 * @param attention
	 * @return
	 */
	@RequestMapping("/deleteAttentionMyself")
	public ModelAndView deleteAttentionMyself(Attention attention){
		logger.info("deleteAttentionMyself()方法被调用");
		try {
			attentionService.deleteAttentionMyself(attention);
		}catch (Exception e){
			logger.error(e+"deleteAttentionMyself()方法调用失败");
		}
		return new ModelAndView("redirect:/userController/getMyself");
	}
	
	
}
