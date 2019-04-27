package com.cdu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepController {
    @RequestMapping("/add")
    public String add(String deptname) throws Exception{
        System.out.println("add().....");
        if (deptname==null){
            throw new NullPointerException("部门名不能为空！");
        }
        return "success";
    }
}
