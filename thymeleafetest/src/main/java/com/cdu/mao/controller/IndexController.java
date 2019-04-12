package com.cdu.mao.controller;

import java.util.ArrayList;
import java.util.List;

import com.cdu.mao.bean.User;
import com.cdu.mao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String index(){
		System.out.println("IndexController index方法被调用......");
		return "index";
	}

	/**
	 * 内容显示 ：application_zh_CN.properties
	 * 符号：# 例：#{student.id}
	 * @return
	 */
	
	@RequestMapping("/showStudent")
	public String index2(){
		return "showStudent";
	}

	/**
	 * 数据回显单个对象：使用ModelMap
	 * 符号$ 例：th:text="${user.id}
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/showOneUser")
	public String index3(User user, ModelMap map){
		
		user=userService.findOneUser();
		map.addAttribute(user);
		return "showOneUser";

	}

	/**
	 * 数据回显List集合 ：map.addAttribute("users",users);
	 *使用each="user:${users}回显数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/showAllUser")
	public String index4(ModelMap map){
		List<User> users = new ArrayList<User>(); 
		users=userService.findAllUsers();
		System.out.println(users.toString());
		map.addAttribute("users",users);
		return "showAllUser";
	}

	/**
	 *
	 * @param map
	 * @return
	 */
	@RequestMapping("/showAllUser2")
	public String index5(ModelMap map){
		List<User> users = new ArrayList<User>(); 
		users=userService.findAllUsers();
		System.out.println(users.toString());
		map.addAttribute("users",users);
		return "showAllUser2";
	}
	
	@RequestMapping("/welcome")
	public String index6(Model model){
		model.addAttribute("name","张三");
		return "welcome";
	}
	
}
