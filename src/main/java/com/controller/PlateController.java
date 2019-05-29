package com.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.pojo.Plate;
import com.service.IPlateService;

@Controller
@RequestMapping("/plateController")
@SessionAttributes(value={"plate","plateEdit"}, types={String.class})
public class PlateController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IPlateService  plateService;
	
	/**
	 * 查询板块信息（无条件）
	 * @param map
	 */
	@RequestMapping("/getPlate")
	public void getPlate(Map<Object, Object> map){
		logger.info("getPlate()方法被调用");
		try {
			List<Plate> plate = plateService.getPlate();
			map.put("plate", plate);
		}catch (Exception e){
			logger.error(e+"getPlate()方法调用失败");
		}
	}
	
	/**
	 * 添加板块信息
	 * @param plate
	 * @return
	 */
	@RequestMapping("/setPlate")
	@ResponseBody
	public String setPlate(Map<Object, Object> map,HttpServletRequest request){
		logger.info("setPlate()方法被调用");
		try {
			Plate plate_add = new Plate();
			//不知为何，Plate plate_add获取的值永远不是提交过来的结果，所以使用request.getParameter("bname")来获取
			plate_add.setBname(request.getParameter("bname"));
			if (plateService.getPlateName(plate_add).toString().equals("[]")) {
				plateService.setPlate(plate_add);
				logger.info("添加板块成功");
				return "OK";
			} else {
				logger.info("添加板块失败");
				return "NO";
			}
		}catch (Exception e){
			logger.error(e+"setPlate()方法调用失败");
		}
		return "NO";
	}
	
	/**
	 * 获取content.jsp页面传来的数据，并将其保存在map("plateEdit")中，以便plateEdit.jsp页面使用
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/getUpdatePlate")
	public String getUpdatePlate(HttpServletRequest request,Map<Object, Object> map) {
		logger.info("getUpdatePlate()方法被调用");
		try {
			Plate plate = new Plate();
			plate.setBid(Integer.parseInt(request.getParameter("bid")));
			plate.setBname(request.getParameter("bname"));
			map.put("plateEdit", plate);
		}catch (Exception e){
			logger.error(e+"getUpdatePlate()方法调用失败");
		}
		return "redirect:/admin/plateEdit.jsp";
	}
	
	/**
	 * 修改板块
	 * @param plate
	 */
	@RequestMapping("/updatePlate")
	@ResponseBody
	public String updatePlate(HttpServletRequest request) {
		logger.info("updatePlate()方法被调用");
		try {
			Plate plate = new Plate();
			plate.setBid(Integer.parseInt(request.getParameter("bid")));
			plate.setBname(request.getParameter("bname"));
			if (plateService.getPlateName(plate).toString().equals("[]")) {
				plateService.updatePlate(plate);
				return "OK";
			} else {
				return "NO";
			}
		}catch (Exception e){
			logger.error(e+"updatePlate()方法调用失败");
		}
		return "NO";
	}
	
	
	
	/**
	 * 按bid删除板块信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/deletePlate")
	public String deletePlate(HttpServletRequest request) {
		logger.info("deletePlate()方法被调用");
		try {
			Plate plate_delete = new Plate();
			plate_delete.setBid(Integer.parseInt(request.getParameter("bid")));
			plateService.deletePlate(plate_delete);
		}catch (Exception e){
			logger.error(e+"deletePlate()方法调用失败");
		}
		return "redirect:/admin/index.jsp";//重定向 
	}
}
