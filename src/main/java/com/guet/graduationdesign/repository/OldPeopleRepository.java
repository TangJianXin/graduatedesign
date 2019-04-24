package com.guet.graduationdesign.repository;

import com.guet.graduationdesign.pojo.OldPeople;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldPeopleRepository extends JpaRepository<OldPeople,Integer> {
}
