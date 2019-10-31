package org.learning.service.util;


import java.util.Date;
import java.util.List;

import org.learning.model.Skill;
import org.learning.service.LearningPlanInterface;

import org.springframework.stereotype.Component;
@Component
public class DefaultLearningPlan {



	public int createLearningPlanTemplate(int planId, String planName, Date createDate, Date modifiedDate,
			List<Skill> skills, String createdBy) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean createLearningPlan(int planId, int empid, Date stDate, Date endDate) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
