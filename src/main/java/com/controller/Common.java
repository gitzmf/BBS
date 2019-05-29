package com.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.pojo.Article;
import com.pojo.Attention;
import com.pojo.Collect;
import com.pojo.Comment;
import com.pojo.Plate;
import com.service.IAttentionService;
import com.service.ICollectService;
import com.service.IPlateService;

@RequestMapping("/common")
@SessionAttributes(value={"plate"})
@Controller
public class Common {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PlateController plateController;
	@Autowired
	UserController userController;
	@Autowired
	ArticleController articleController;
	@Autowired
	CommentController commentController;
	@Autowired 
	IPlateService plateService;
	@Autowired
	IAttentionService  attentionService;
	@Autowired
	ICollectService collectService;
	
	/**
	 * 查询输出首页全部信息（不包含head）
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll(Map<Object, Object> map,Map<Object, Object> map2){
		logger.info("getAll()方法被调用");
		try {
			articleController.getArticle(map);
			List<Article> listArticle = (List<Article>) map.get("listArticle");
			int count = listArticle.size();
			for (int i = 0; i < count; i++) {
				//将每一条帖子对应的id单独抽出来
				int fid = listArticle.get(i).getFid();
				//再通过每一个帖子的id查找出对应的评论信息
				commentController.getCommentFid(fid, map);
				//将上一步查出的对应的评论信息存放到listComment里
				List<Comment> listComment = (List<Comment>) map.get("listComment");
				//为map预设一个随帖子id变化而变化的key
				String listCommentFid = "listComment_" + fid;
				//将每一个帖子下对应的所有评论存入map中（其key是随帖子id变化而变化的）
				map.put(listCommentFid, listComment);
				//再将map存入map2
				map2.put("map", map);
			}

			//查询板块信息（无条件）
			List<Plate> plate = plateService.getPlate();
			map.put("plate", plate);

			//查询关注信息(无条件)
			List<Attention> attention = attentionService.getAttention();
			map.put("attention", attention);

			//查询收藏信息（无条件）
			List<Collect> collect = collectService.getCollect();
			map.put("collect", collect);
		}catch (Exception e){
			logger.error(e+"getAll()方法调用失败");
		}
		return "list";
	}
	
	
	/**
	 * 查询输出-管理员-首页全部信息（不包含head）
	 * @return
	 */
	@RequestMapping("/getAll_Admin")
	public String getAll_Admin(Map<Object, Object> map){
		logger.info("getAll_Admin()方法被调用");
		try {
			//查询板块信息（无条件）
			plateController.getPlate(map);
			//查询用户信息（无条件）
			userController.getUser(map);
			//查询帖子信息（无条件）
			articleController.getArticle(map);
		}catch (Exception e){
			logger.error(e+"getAll_Admin()方法调用失败");
		}
		return "admin";
	}
	
	
	/**
	 * 按帖子标题模糊查询（搜索框搜索）
	 * @param request
	 * @param map
	 * @param map2
	 * @return
	 */
	@RequestMapping("/getArticleTitle")
	public String getArticleTitle(HttpServletRequest request,Map<Object, Object> map,Map<Object, Object> map2){
		logger.info("getArticleTitle()方法被调用");
		try {
			articleController.getArticleTitle(request.getParameter("articleTitle"), map);
			List<Article> listArticle = (List<Article>) map.get("listArticle");
			int count = listArticle.size();
			for (int i = 0; i < count; i++) {
				//将每一条帖子对应的id单独抽出来
				int fid = listArticle.get(i).getFid();
				//再通过每一个帖子的id查找出对应的评论信息
				commentController.getCommentFid(fid, map);
				//将上一步查出的对应的评论信息存放到listComment里
				List<Comment> listComment = (List<Comment>) map.get("listComment");
				//为map预设一个随帖子id变化而变化的key
				String listCommentFid = "listComment_" + fid;
				//将每一个帖子下对应的所有评论存入map中（其key是随帖子id变化而变化的）
				map.put(listCommentFid, listComment);
				//再将map存入map2
				map2.put("map", map);
			}

			//查询板块信息（无条件）
			List<Plate> plate = plateService.getPlate();
			map.put("plate", plate);
		}catch (Exception e){
			logger.error(e+"getArticleTitle()方法调用失败");
		}
		return "list";
	}
	
	
	/**
	 * 按帖子板块查询出帖子
	 * @param request
	 * @param map
	 * @param map2
	 * @return
	 */
	@RequestMapping("/getArticleBname")
	public String getArticleBname(HttpServletRequest request,Map<Object, Object> map,Map<Object, Object> map2){
		logger.info("getArticleBname()方法被调用");
		try {
			articleController.getArticleBname(request.getParameter("bname"), map);
			List<Article> listArticle = (List<Article>) map.get("listArticle");
			int count = listArticle.size();
			for (int i = 0; i < count; i++) {
				//将每一条帖子对应的id单独抽出来
				int fid = listArticle.get(i).getFid();
				//再通过每一个帖子的id查找出对应的评论信息
				commentController.getCommentFid(fid, map);
				//将上一步查出的对应的评论信息存放到listComment里
				List<Comment> listComment = (List<Comment>) map.get("listComment");
				//为map预设一个随帖子id变化而变化的key
				String listCommentFid = "listComment_" + fid;
				//将每一个帖子下对应的所有评论存入map中（其key是随帖子id变化而变化的）
				map.put(listCommentFid, listComment);
				//再将map存入map2
				map2.put("map", map);
			}

			//查询板块信息（无条件）
			List<Plate> plate = plateService.getPlate();
			map.put("plate", plate);
		}catch (Exception e){
			logger.error(e+"getArticleBname()方法调用失败");
		}
		return "list";
	}
	
}
