package com.cdu.springboot.service;

import com.cdu.springboot.bean.Student;
import com.cdu.springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;
    @Transactional
    public void saveAll(List<Student> students){
        studentRepository.saveAll(students);
    }
    public Student getStudentByName(String name){
        return studentRepository.findByName(name);
    }
    public List<Student> getStudentByNameAndAddr(String name,String address){
        return studentRepository.findByNameAndAddress(name,address);
    }
    public List<Student> getStudentByNameLike(String name){
        return studentRepository.findByNameLike("%"+name+"%");
    }
}
