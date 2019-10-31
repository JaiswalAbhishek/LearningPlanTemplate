package org.learning.dao;

import java.util.List;

import org.learning.model.LearningPlan;

public interface LearningPlanDAO {
	 public boolean createLearningPlan (LearningPlan learningPlan);
	 public boolean updateLearningPlan (LearningPlan learningPlan);
	 public boolean deleteLearningPlan (int learningPlanId);
	 public LearningPlan getLearningPlan(int learningPlanId);
	 public List<LearningPlan> getAllLearningPlan ();
	 public boolean updateLearningPlanById(int id);
public List<LearningPlan> getAllLearningPlanAssignedToEmployee(String userID);
}
