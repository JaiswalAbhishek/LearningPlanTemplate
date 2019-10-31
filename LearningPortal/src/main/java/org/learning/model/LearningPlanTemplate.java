package org.learning.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LearningPlanTemplate  implements Serializable {
	

	private int LearningPlanId;
	private String LearningPlanName;
    private Date CreationDate;
	private Date ModifiedDate;
	private List ListOfSkills;
	private String CreatorUserId;
	
	public int getLearningPlanId() {
		return LearningPlanId;
	}
	public void setLearningPlanId(int learningPlanId) {
		LearningPlanId = learningPlanId;
	}
	public String getLearningPlanName() {
		return LearningPlanName;
	}
	public void setLearningPlanName(String learningPlanName) {
		LearningPlanName = learningPlanName;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	public List getListOfSkills() {
		return ListOfSkills;
	}
	public void setListOfSkills(List listOfSkills) {
		ListOfSkills = listOfSkills;
	}
	public String getCreatorUserId() {
		return CreatorUserId;
	}
	public void setCreatorUserId(String creatorUserId) {
		CreatorUserId = creatorUserId;
	}









}
