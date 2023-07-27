package com.ms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PlanCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	private String categoryName;
	private Boolean activeSw;
	private LocalDate createDate;
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;
	
}
