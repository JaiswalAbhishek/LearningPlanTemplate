package org.learning.service;


import java.util.Date;
import java.util.List;

import org.learning.model.Skill;

public interface LearningPlanInterface {
	 public int createLearningPlanTemplate(int planId, String planName, Date createDate, Date modifiedDate, List <Skill> skills, String createdBy); 
	 public boolean createLearningPlan(int  planId, int empid, Date stDate, Date endDate);
	 }
