package com.ms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.Plan;
import com.ms.entity.PlanCategory;
import com.ms.repository.PlanCategoryRepository;
import com.ms.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private PlanCategoryRepository planCategoryRepository;
	
	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> planCategoryList= planCategoryRepository.findAll();
		Map<Integer, String> categoriesMap = planCategoryList.stream().
				                                         collect(Collectors.toMap(
				                                             PlanCategory::getCategoryId,
				                                             PlanCategory::getCategoryName, 
				                                             (x, y) -> x + ", " + y,
				                                             HashMap::new));
		return categoriesMap;
	}

	@Override
	public Boolean createPlan(Plan plan) {
		Plan saved = planRepository.save(plan);
		return saved.getPlanId() !=null;
	}

	@Override
	public List<Plan> getAllPlan() {
		return planRepository.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> planOpt = planRepository.findById(planId);
		if(planOpt.isPresent())
			return planOpt.get();
		
		return null;
	}

	@Override
	public Boolean updatePlan(Plan plan) {
	    planRepository.save(plan);
		return plan.getPlanId() !=null;
	}

	@Override
	public Boolean removePlanById(Integer planId) {
		Boolean status = false;
		try {
			planRepository.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean changePlanStatus(Integer planId, String status) {
		Optional<Plan> planOpt  = planRepository.findById(planId);
		if(planOpt.isPresent()) {
			Plan plan = planOpt.get();
			plan.setActiveSw(status);
			planRepository.save(plan);
		    return true;
		}
		return false;
	}
	
	

}
