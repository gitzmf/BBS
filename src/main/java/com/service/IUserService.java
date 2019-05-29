package com.service;

import java.util.List;

import com.pojo.User;

/**
 * @author cll
 * @version 1.0
 * @ClassName IUserService
 * @Description: TODO: 登录功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface IUserService {

	/**
	 　* @Description: TODO: 登录查询（按姓名和密码）
	 　* @param 封装的user对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<User> getUser(User user) throws Exception;
	
	/**
	 * 注册按用户名查询
	 * 
	 * @param user
	 * @return
	 */
	/**
	 　* @Description: TODO: 注册按用户名查询
	 　* @param 封装的user对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<User> getUserName(User user) throws Exception;

	/**
	 　* @Description: TODO: 注册插入
	 　* @param 封装的user对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void setUser(User user) throws Exception;

	/**
	 　* @Description: TODO: 按userid查询用户信息
	 　* @param 封装的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<User> getUserId(int userid) throws Exception;


	/**
	 　* @Description: TODO: 编辑个人资料（修改user表）
	 　* @param 封装的user
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void updateUser(User user) throws Exception;

	/**
	 　* @Description: TODO: 删除用户
	 　* @param 封装的user
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deleteUser(User user) throws Exception;

	/**
	 　* @Description: TODO: 基本设置信息的修改
	 　* @param 封装的user
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void updateUserSetup(User user) throws Exception;


	/**
	 　* @Description: TODO: 按userid查询用户信息
	 　* @param 封装的userid
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	User getUserKey(int userid) throws Exception;
	
	/**
	 　* @Description: TODO: 查询用户信息
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<User> getUser() throws Exception;
}
