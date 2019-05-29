package com.service;

import com.pojo.Via;

/**
 * @author cll
 * @version 1.0
 * @ClassName IUserService
 * @Description: TODO: 头像信息功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface IViaService {

	/**
	 　* @Description: TODO: 按userid查询用户头像信息（via）
	 　* @param 封装的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	Via getVia(int userid) throws Exception;


	/**
	 　* @Description: TODO: 上传用户头像（插入）（via）
	 　* @param 封装的via
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void setUserPhoto(Via via)  throws Exception;


	/**
	 　* @Description: TODO: 按userid修改用户头像信息（via）
	 　* @param 封装的via
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void updateVia(Via via) throws Exception;

	/**
	 　* @Description: TODO: 删除用户对应的头像信息
	 　* @param 封装的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteVia(Integer userid) throws Exception;
}
