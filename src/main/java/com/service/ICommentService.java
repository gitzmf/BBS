package com.service;

import java.util.List;
import com.pojo.Comment;


/**
 * @author cll
 * @version 1.0
 * @ClassName ICommentService
 * @Description: TODO: 评论功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface ICommentService {

	/**
	 　* @Description: TODO: 按帖子id（fid）查询评论表信息
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Comment> getCommentFid(int fid) throws Exception;


	/**
	 　* @Description: TODO: 按帖子id（fid）查询评论表信息
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Comment> getCommentUserid(int userid) throws Exception;


	/**
	 　* @Description: TODO: 添加评论
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void setComment(Comment comment) throws Exception;

	/**
	 　* @Description: TODO: 按pid删除评论表
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteComment(int pid) throws Exception;

	/**
	 　* @Description: TODO: 删除该用户对应的所有评论信息(按userid)
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteCommentUserid(int userid) throws Exception;
}
