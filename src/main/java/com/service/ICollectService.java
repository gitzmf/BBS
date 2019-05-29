package com.service;

import java.util.List;

import com.pojo.Collect;


/**
 * @author cll
 * @version 1.0
 * @ClassName ICollectService
 * @Description: TODO: 收藏功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface ICollectService {

	/**
	 　* @Description: TODO: 查询收藏信息（无条件）
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Collect> getCollect() throws Exception;

	/**
	 　* @Description: TODO: 删除收藏(按sid)
	 　* @param 封装的collect对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteCollect(Collect collect) throws Exception;

	/**
	 　* @Description: TODO: 添加收藏
	 　* @param 封装的collect对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void setCollect(Collect collect) throws Exception;

	/**
	 　* @Description: TODO: 按userid查询收藏信息（收藏了哪些帖子）
	 　* @param 封装的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Collect> getCollect(int userid) throws Exception;

	/**
	 　* @Description: TODO: 删除收藏（按userid和fid）
	 　* @param 封装的collect对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteCollectUseridAndFid(Collect collect) throws Exception;

	/**
	 　* @Description: TODO: 按fid删除收藏信息
	 　* @param 封装的fid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteCollectFid(int fid) throws Exception;

	/**
	 　* @Description: TODO: 删除该用户对应的收藏信息(按userid)
	 　* @param 封装的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteCollectUserid(int userid) throws Exception;
}
