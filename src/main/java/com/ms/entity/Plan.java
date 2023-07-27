package com.ms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	private String planName;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String planCategoryId;
	private String activeSw;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;
}
