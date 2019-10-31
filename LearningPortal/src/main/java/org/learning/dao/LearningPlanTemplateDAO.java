package org.learning.dao;

import java.util.List;
import org.learning.model.LearningPlanTemplate;

public interface LearningPlanTemplateDAO {
	 public boolean createLearningPlanTemplate (LearningPlanTemplate learningPlanTemplate);
	 public boolean updateLearningPlanTemplate (LearningPlanTemplate learningPlanTemplate);
	 public boolean deleteLearningPlanTemplate (int templateId);
	 public LearningPlanTemplate getLearningPlanTemplatel(int templateId);
	 public List<LearningPlanTemplate> getAllLearningPlanTemplate () ;

}
