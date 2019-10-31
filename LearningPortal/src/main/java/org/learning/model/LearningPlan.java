package org.learning.model;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class LearningPlan implements Serializable{

	private String empUserId;
	private int learningPlanId;
	
	private Date startDate;
	
	private Date endDate;
	public String getEmpUserId() {
		return empUserId;
	}
	public void setEmpUserId(String empUserId) {
		this.empUserId = empUserId;
	}
	public int getLearningPlanId() {
		return learningPlanId;
	}
	public void setLearningPlanId(int learningPlanId) {
		this.learningPlanId = learningPlanId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
