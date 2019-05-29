package com.service;

import java.util.List;

import com.pojo.Admin;

/**
 * @author cll
 * @version 1.0
 * @ClassName IAdminService
 * @Description: TODO: 管理员功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface IAdminService {

	/**
	　* @Description: TODO: 管理员登录查询
	　* @param 封装的管理员admin对象
	　* @return 返回的封装admin对象的集合
	　* @throws
	　* @author cll
	　* @date 2019/5/26 23:15
	　*/
	List<Admin> getAdmin(Admin admin) throws Exception;
	

	/**
	 　* @Description: TODO: 管理员注册按姓名查询
	 　* @param 封装的管理员admin对象
	 　* @return 返回的封装admin对象的集合
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:15
	 　*/
	List<Admin> getAdminName(Admin admin) throws Exception;


	/**
	 　* @Description: TODO: 管理员注册插入
	 　* @param 封装的管理员admin对象
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:15
	 　*/
	void setAdmin(Admin admin) throws Exception;
}
