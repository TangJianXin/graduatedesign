package com.guet.graduationdesign.repository;

import com.guet.graduationdesign.pojo.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {
}
