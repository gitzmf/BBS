package com.service;

import java.util.List;

import com.pojo.Attention;

/**
 * @author cll
 * @version 1.0
 * @ClassName IArticleService
 * @Description: TODO: 关注功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface IAttentionService {

	/**
	 　* @Description: TODO: 添加关注
	 　* @param 封装的attention对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void setAttention(Attention attention) throws Exception;

	/**
	 　* @Description: TODO: 查询关注信息(无条件)
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Attention> getAttention() throws Exception;

	/**
	 　* @Description: TODO: 取消关注(首页)
	 　* @param 封装的attention对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteAttention(Attention attention)  throws Exception;

	/**
	 　* @Description: TODO: 按userid查询关注信息
	 　* @param 查询的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Attention> getAttention(int userid) throws Exception;

	/**
	 　* @Description: TODO: 按beuserid查询关注信息
	 　* @param 查询的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Attention> getAttentionBe(int beuserid)  throws Exception;

	/**
	 　* @Description: TODO: 取消关注（个人主页）
	 　* @param 封装的attention对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteAttentionMyself(Attention attention) throws Exception;

	/**
	 　* @Description: TODO: 删除该用户对应的关注和被关注信息
	 　* @param 删除的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteAttentionUseridOrBeuserid(int userid) throws Exception;

}
