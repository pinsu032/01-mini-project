package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ms.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
