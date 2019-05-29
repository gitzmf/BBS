package com.controller;

import com.pojo.Admin;
import com.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("adminController")
@SessionAttributes(value = "adminList")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IAdminService adminService;
    @Autowired
    PlateController plateController;
    @Autowired
    UserController userController;

    List<Admin> list = new ArrayList<>();

    /**
     * 管理员登录判断
     *
     * @param admin
     * @param map
     * @return
     */
    @RequestMapping("getLogin")
    public String getLogin(Admin admin, Map<Object, Object> map) {
        logger.info("getLogin()方法被调用");
        // 调用管理员查询方法
        try {
            list = adminService.getAdmin(admin);
            String str = list.toString();
            if (!str.equals("[]")) {
                map.put("adminList", list.get(0));
                plateController.getPlate(map);
                userController.getUser(map);
                return "redirect:/admin/index.jsp";// 重定向
            } else {
                return "redirect:/admin/indexLogin.jsp";// 重定向
            }
        } catch (Exception e) {
            logger.error("getLogin()方法调用失败");
        }
        return "redirect:/admin/index.jsp";// 重定向
    }

    /**
     * 管理员注册
     *
     * @param admin
     * @param map
     * @return
     */
    @RequestMapping("/setSignUp")
    public String setSignUp(Admin admin, Map<Object, Object> map) {
        logger.info("setSignUp()方法被调用");
        try {
            if (adminService.getAdminName(admin).toString().equals("[]")) {
                // 调用管理员插入方法
                adminService.setAdmin(admin);
                // 调用管理员查询方法（获取刚刚注册的管理员信息）
                list = adminService.getAdmin(admin);
                map.put("adminList", list.get(0));
                return "admin";
            } else {
                logger.info("管理员注册失败");
                return "redirect:/admin/index.jsp";// 重定向
            }
        } catch (Exception e) {
            logger.error("setSignUp()方法调用失败");
        }
        return "redirect:/admin/index.jsp";// 重定向
    }

    /**
     * 退出管理员登录
     *
     * @param map
     * @return
     */
    @RequestMapping("/adminExit")
    public String adminExit(Map<Object, Object> map) {
        logger.info("adminExit()方法被调用");
        try {
            map.put("adminList", "");
        }catch (Exception e){
            logger.error("adminExit()方法调用失败");
        }
        return "redirect:/admin/indexLogin.jsp";// 重定向
    }
}
