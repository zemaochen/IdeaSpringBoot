package com.cdu.springboot.service;

import com.cdu.springboot.bean.User;
import com.cdu.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
//    注入

    @Resource
    private UserRepository userRepository;
    /**
     * save、update、delete方法需要绑定事务。使用@Transactional进行事务的绑定
     */
    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }
    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }
    @Transactional
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
    @Transactional
    public User getById(Integer id){
        Optional<User>op = userRepository.findById(id);
        return op.get();
    }
    @Transactional
    public void update(User user){
        //直接调用持久化对象的set方法修改对象数据
        user.setUsername("派克");
        user.setLoginName("水手");
    }
}
