package org.learning.dao;

import java.util.List;

import org.learning.model.Skill;
import org.learning.model.User;

public interface SkillDAO {

	public boolean createSkill(Skill skill);
	public boolean updateSkill(Skill skill);
	public boolean deleteSkill(int skillId);
	public Skill getSkill(int skillId);
	public List<Skill> getAllSkills() ;
	public List<String> getAllSkillsName();
	public boolean changeCourse(int id,String url);
	
}
