package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.pojo.Article;
import com.pojo.ArticleAssist;
import com.service.IArticleService;
import com.service.ICollectService;
import com.service.ICommentService;
import com.utils.PathUtil;

@RequestMapping("/articleController")
@SessionAttributes(value = { "article_Edit", "article_Show" })
@Controller
public class ArticleController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IArticleService articleService;
	@Autowired
	ICommentService commentService;
	@Autowired
	ICollectService collectService;

	/**
	 * 向数据库插入发帖信息（包括图片）
	 * 
	 * @param file
	 * @param article2
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/setArticle")
	public String setArticle(@RequestParam("photo") MultipartFile file, ArticleAssist article2, HttpSession session,
			HttpServletRequest request){
		logger.info("setArticle()方法被调用");
		String projectname; // 项目名称
		try {
			projectname = request.getSession().getServletContext().getRealPath("/");
			projectname = projectname.substring(0, projectname.length() - 1);
			if (projectname.indexOf("/") == -1) {// 在非linux系统下
				projectname = projectname.substring(projectname.lastIndexOf("\\"), projectname.length());
			} else {// 在linux系统下
				projectname = projectname.substring(projectname.lastIndexOf("/"), projectname.length());
			}
			String filePath = PathUtil.getArticlePath();
			// 用于存放新生成的文件名字(不重复)
			String newFileName = "photo";
			String username = (String) session.getAttribute("username");
			// 用户登录情况下才可发帖
			if (username != null) {
				// 当其中没有值时"int userid=null"报错(肯定报错啊，int=null???)
				int userid = (int) session.getAttribute("userid");
				// 获取上传图片的文件名及其后缀(获取原始图片的拓展名)
				String fileName = file.getOriginalFilename();
				if (!fileName.equals("")) {
					// 生成新的文件名字(不重复)
					newFileName = UUID.randomUUID() + fileName;
					// 封装上传文件位置的全路径
					File targetFile = new File(filePath, newFileName);
					// 把本地文件上传到封装上传文件位置
					file.transferTo(targetFile);
				}
				// 将article2和photo整合到article中
				Article article = new Article(article2, newFileName);
				article.setUserid(userid);
				article.setUsername(username);
				article.setStatus(0);
				// 将article保存到数据库
				articleService.setArticle(article);
			}
			return "redirect:/index.jsp";// 重定向
		} catch (Exception e) {
			logger.error(e+"setArticle()方法调用失败");
		}
		return "redirect:/index.jsp";// 重定向
	}

	/**
	 * 查询发帖表信息（无条件）
	 * 
	 * @param map
	 */
	public void getArticle(Map<Object, Object> map){
		logger.info("getArticle()方法被调用");
		try {
			List<Article> listArticle = articleService.getArticle();
			map.put("listArticle", listArticle);
		} catch (Exception e) {
			logger.error(e+"getArticle()方法调用失败");
		}
	}

	/**
	 * 按帖子标题模糊查询（搜索框搜索）
	 * 
	 * @param articleTitle
	 * @param map
	 */
	public void getArticleTitle(String articleTitle, Map<Object, Object> map) {
		logger.info("getArticleTitle()方法被调用");
		try {
			List<Article> listArticle = articleService.getArticleTitle(articleTitle);
			map.put("listArticle", listArticle);
		} catch (Exception e) {
			logger.error(e+"getArticleTitle()方法调用失败");
		}
	}

	/**
	 * 按帖子板块查询出帖子
	 * 
	 * @param bname
	 * @param map
	 */
	public void getArticleBname(String bname, Map<Object, Object> map){
		logger.info("getArticleBname()方法被调用");
		try {
			List<Article> listArticle = articleService.getArticleBname(bname);
			map.put("listArticle", listArticle);
		}catch (Exception e){
			logger.error(e+"getArticleBname()方法调用失败");
		}
	}

	/**
	 * 按fid删除帖子
	 * 
	 * @param article
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/deleteArticle")
	public ModelAndView deleteArticle(Article article, HttpServletRequest request){
		logger.info("deleteArticle()方法被调用");
		try {
			int fid = article.getFid();
			int count = commentService.getCommentFid(fid).size();
			for (int i = 0; i < count; i++) {
				int pid = commentService.getCommentFid(fid).get(0).getPid();
				// 删除帖子下对应的评论（注意：先删评论再删帖子！！）
				commentService.deleteComment(pid);
			}
			// 调用删除帖子对应图片的方法
			articlePhotoDelete(fid, request);
			// 删除帖子(数据库)
			articleService.deleteArticle(fid);
			// 删除有该帖子id的收藏信息
			collectService.deleteCollectFid(fid);
			// 删除该用户对应的收藏信息(按userid)
			collectService.deleteCollectFid(fid);
		}catch (Exception e){
			logger.error(e+"deleteArticle()方法调用失败");
		}
		// 重定向到getMyself这个方法
		return new ModelAndView("redirect:/userController/getMyself");
	}

	/**
	 * 获取mycontent.jsp页面传来的数据，并将其保存在map("article")中，以便articleEdit.jsp页面使用
	 * 
	 * @param article
	 * @param map
	 * @return
	 */
	@RequestMapping("/getUpdateArticle")
	public String getUpdateArticle(Article article, Map<Object, Object> map){
		logger.info("getUpdateArticle()方法被调用");
		try {
			map.put("article_Edit", article);
		}catch (Exception e){
			logger.error(e+"getUpdateArticle()方法调用失败");
		}
		return "redirect:/content/articleEdits.jsp";
	}

	/**
	 * 修改帖子表
	 * 
	 * @param article
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateArticle")
	public ModelAndView updateArticle(@RequestParam("photo") MultipartFile file, ArticleAssist article2,
			String photoName, HttpServletRequest request){
		logger.info("updateArticle()方法被调用");
		try {
			Article article = null;
			if ((file.getOriginalFilename().isEmpty()) || file == null) {
				// 将article2和photo整合到article中
				article = new Article(article2, photoName);
			} else {
				String projectname; // 项目名称
				projectname = request.getSession().getServletContext().getRealPath("/");
				projectname = projectname.substring(0, projectname.length() - 1);
				if (projectname.indexOf("/") == -1) {// 在非linux系统下
					projectname = projectname.substring(projectname.lastIndexOf("\\"), projectname.length());
				} else {// 在linux系统下
					projectname = projectname.substring(projectname.lastIndexOf("/"), projectname.length());
				}
				String filePath = PathUtil.getArticlePath();
				int fid = article2.getFid();
				// 获取上传图片的文件名及其后缀(获取原始图片的拓展名)
				String fileName = file.getOriginalFilename();
				// 生成新的文件名字(不重复)
				String newFileName = UUID.randomUUID() + fileName;
				// 封装上传文件位置的全路径
				File targetFile = new File(filePath, newFileName);
				// 把本地文件上传到封装上传文件位置的全路径
				file.transferTo(targetFile);
				article = new Article(article2, newFileName);
				// 调用删除帖子对应图片的方法
				articlePhotoDelete(fid, request);
			}
			// 修改帖子表（数据库）
			articleService.updateArticle(article);
		}catch (Exception e){
			logger.error(e+"updateArticle()方法调用失败");
		}
		// 重定向到getMyself这个方法
		return new ModelAndView("redirect:/userController/getMyself");
	}

	/**
	 * 删除帖子对应的图片
	 * 
	 * @throws IOException
	 */
	public void articlePhotoDelete(int fid, HttpServletRequest request){
		logger.info("articlePhotoDelete()方法被调用");
		try {
			String projectname; // 项目名称
			projectname = request.getSession().getServletContext().getRealPath("/");
			projectname = projectname.substring(0, projectname.length() - 1);
			if (projectname.indexOf("/") == -1) {// 在非linux系统下
				projectname = projectname.substring(projectname.lastIndexOf("\\"), projectname.length());
			} else {// 在linux系统下
				projectname = projectname.substring(projectname.lastIndexOf("/"), projectname.length());
			}
			// 文件（图片）路径
			String filePath = PathUtil.getCommonPath() + projectname + PathUtil.getArticlePath();
			// 获取取要删除帖子对应的图片的文件名（通过fid获取帖子信息）
			String fileName = articleService.getArticleKey(fid).getPhoto();
			// 封装上传文件位置的全路径
			File targetFile = new File(filePath, fileName);
			// 删除帖子对应的图片（实际删除）
			targetFile.delete();
		}catch (Exception e){
			logger.error(e+"articlePhotoDelete()方法调用失败");
		}
	}

	/**
	 * 修改article表的status属性（修改审核状态）
	 * 
	 * @return
	 */
	@RequestMapping("/articleStatus")
	public String articleStatus(Article article){
		logger.info("articleStatus()方法被调用");
		try {
			articleService.updateArticleStatus(article);
		}catch (Exception e){
			logger.error(e+"articleStatus()方法调用失败");
		}
		return "redirect:/admin/index.jsp";
	}

	/**
	 * 按fid查询帖子信息（帖子展示）
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getArticleFid")
	public String getArticleFid(Map<Object, Object> map, HttpServletRequest request){
		logger.info("getArticleFid()方法被调用");
		try {
			int fid = Integer.parseInt(request.getParameter("fid"));
			map.put("article_Show", articleService.getArticleKey(fid));
		}catch (Exception e){
			logger.error(e+"getArticleFid()方法调用失败");
		}
		return "redirect:/content/articleShow.jsp";
	}

}
