package com.cdu.springboot.controller;

import com.cdu.springboot.bean.User;
import com.cdu.springboot.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    //注入UserService
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save(){
        User user = new User();
        user.setLoginName("dlei");
        user.setUsername("徐磊");
        user.setAge(3);
        user.setSex('男');
        userService.save(user);
        return "保存数据成功";
    }
    @RequestMapping("/update")
    public String update(){
        //修改对象必须是持久化对象，所以先从数据库查询id为1的对象开始修改
        User user = userService.getById(1);
        userService.update(user);
        return "修改成功";
    }
    @RequestMapping("/delete")
    public String delete(){
        userService.delete(1);
        return "删除数据成功";
    }
    @RequestMapping("/getAll")
    public Iterable<User> getAll(){
        return userService.getAll();
    }
}
