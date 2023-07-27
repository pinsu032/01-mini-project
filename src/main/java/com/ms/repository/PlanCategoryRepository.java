package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ms.entity.PlanCategory;

public interface PlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
