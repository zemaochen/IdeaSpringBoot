package com.cdu.springboot.repository;

import com.cdu.springboot.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
