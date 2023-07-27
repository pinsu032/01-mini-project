package com.ms.service;

import java.util.List;
import java.util.Map;

import com.ms.entity.Plan;

public interface PlanService {

	Map<Integer,String> getPlanCategories();
	
	Boolean createPlan(Plan plan);

	List<Plan> getAllPlan();
	
	Plan getPlanById(Integer planId);
	
	Boolean updatePlan(Plan plan);
	
	Boolean removePlanById(Integer planId);
	
	Boolean changePlanStatus(Integer planId,String status);
	
}
