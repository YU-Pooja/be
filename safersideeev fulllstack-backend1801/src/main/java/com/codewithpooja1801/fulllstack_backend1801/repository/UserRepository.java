package com.codewithpooja1801.fulllstack_backend1801.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithpooja1801.fulllstack_backend1801.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
