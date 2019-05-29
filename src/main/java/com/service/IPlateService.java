package com.service;

import java.util.List;

import com.pojo.Plate;

/**
 * @author cll
 * @version 1.0
 * @ClassName IPlateService
 * @Description: TODO: 版本功能模块的抽象业务层
 * @date 2019/5/8 14:34
 */
public interface IPlateService {

	/**
	 　* @Description: TODO: 查询板块信息（无条件）
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Plate> getPlate() throws Exception;


	/**
	 　* @Description: TODO: 新增板块信息
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void setPlate(Plate plate) throws Exception;

	/**
	 　* @Description: TODO: 按bid删除板块信息
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	List<Plate> getPlateName(Plate plate) throws Exception;


	/**
	 　* @Description: TODO: 按bid删除板块信息
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void deletePlate(Plate plate_delete)  throws Exception;


	/**
	 　* @Description: TODO: 修改板块
	 　* @param
	 　* @return
	 　* @throws
	 　* @author cll
	 　* @date 2019/5/26 23:20
	 　*/
	void updatePlate(Plate plate)  throws Exception;
}
