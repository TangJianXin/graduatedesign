package com.guet.graduationdesign.repository;

import com.guet.graduationdesign.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
