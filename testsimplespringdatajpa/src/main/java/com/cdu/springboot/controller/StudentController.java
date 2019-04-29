package com.cdu.springboot.controller;

import com.cdu.springboot.bean.Student;
import com.cdu.springboot.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping("/save")
    public String save(){
        Student student1 = new Student();
        student1.setAddress("广州");
        student1.setName("蔡徐坤");
        student1.setAge(30);
        student1.setSex('男');
        Student student2 = new Student();
        student2.setAddress("广州1");
        student2.setName("蔡徐坤1");
        student2.setAge(31);
        student2.setSex('男');
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        studentService.saveAll(students);
        return "保存学生数据成功";
    }
    @RequestMapping("/name")
    public Student getByName(String name){
        return studentService.getStudentByName(name);
    }
    @RequestMapping("/nameAndAddress")
    public List<Student> getByNameAndAddress(String name,String address){
        return studentService.getStudentByNameAndAddr(name,address);
    }
    @RequestMapping("/nameLike")
    public List<Student> getByNameLike(String name){
        return studentService.getStudentByNameLike(name);
    }

}
