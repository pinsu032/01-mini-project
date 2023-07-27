package com.ms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.ms.constant.AppConstant.*;

import com.ms.entity.Plan;
import com.ms.props.AppProperties;
import com.ms.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanRestController {

	private PlanService service;
	private Map<String,String> messages;
	public  PlanRestController(PlanService service, AppProperties props) {
		this.service = service;
	    messages = props.getMessages();
	    System.out.println(messages);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> getPlanCategories(){
		Map<Integer,String> categoriesMap = service.getPlanCategories();
		return new ResponseEntity<Map<Integer,String>>(categoriesMap,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String msg = " ";
		Boolean status = service.createPlan(plan);
		if(status)
			msg = messages.get(PLAN_SAVED);
		else
			msg = messages.get(PLAN_NOT_SAVED);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> fetchAllPlan(){
		List<Plan> planList = service.getAllPlan();
		return new ResponseEntity<>(planList,HttpStatus.OK);
	}
	
	@GetMapping("/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable("planId") Integer planId){
		Plan plan = service.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		String msg = " ";
		Boolean status = service.updatePlan(plan);
		if(status)
			msg = messages.get(PLAN_UPDATED);
		else
			msg = messages.get(PLAN_NOT_UPDATED);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{planId}")
	public ResponseEntity<String> removePlanById(@PathVariable("planId") Integer planId){
		Boolean status = false;
		String msg = " ";
		status = service.removePlanById(planId);
		if(status)
			msg = messages.get(PLAN_REMOVED);
		else
			msg = messages.get(PLAN_NOT_REMOVED);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable("planId") Integer planId,@PathVariable("status") String status){
		String msg ;
		Boolean isUpdated = service.changePlanStatus(planId, status);
		if(isUpdated)
			msg = messages.get(PLAN_STATUS_CHANGED);
		else
			msg = messages.get(PLAN_STATUS_NOT_CHANGED);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
}
