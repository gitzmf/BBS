package com.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.pojo.Comment;
import com.service.ICommentService;

@RequestMapping("/commentController")
@Controller
public class CommentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ICommentService commentService;
	
	/**
	 * 按帖子id（fid）查询评论表信息
	 * @param fid
	 * @param map
	 */
	@RequestMapping("/getCommentFid")
	public void getCommentFid(int fid,Map<Object, Object> map){
		logger.info("getCommentFid()方法被调用");
		try {
			List<Comment> listComment = commentService.getCommentFid(fid);
			map.put("listComment", listComment);
		}catch (Exception e){
			logger.error(e+"getCommentFid()方法调用失败");
		}
	}
	
	/**
	 * 添加评论
	 * @param comment
	 */
	@RequestMapping("/setComment")
	public String setComment(Comment comment){
		logger.info("setComment()方法被调用");
		try {
			commentService.setComment(comment);
		}catch (Exception e){
			logger.error(e+"setComment()方法调用失败");
		}
		return "redirect:/index.jsp";
	}
	
	/**
	 * 按pid删除评论表
	 * @return
	 */
	@RequestMapping("/deleteComment")
	public ModelAndView  deleteComment(Comment comment) {
		logger.info("deleteComment()方法被调用");
		try {
			commentService.deleteComment(comment.getPid());
		}catch (Exception e){
			logger.error(e+"deleteComment()方法调用失败");
		}
		//重定向到getMyself这个方法
		return new ModelAndView("redirect:/userController/getMyself");
	}
	
	
	
}
