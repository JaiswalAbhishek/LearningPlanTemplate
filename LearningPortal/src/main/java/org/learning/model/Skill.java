package org.learning.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class Skill  implements Serializable {

	private int skillId;
	private String skillName;
	private String CourseAttachedToTheSkill;
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getCourseAttachedToTheSkill() {
		return CourseAttachedToTheSkill;
	}
	public void setCourseAttachedToTheSkill(String courseAttachedToTheSkill) {
		CourseAttachedToTheSkill = courseAttachedToTheSkill;
	}
	
	

}
