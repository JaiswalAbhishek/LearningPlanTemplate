package org.learning.controller;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.learning.dao.LearningPlanDAO;
import org.learning.dao.LearningPlanTemplateDAO;
import org.learning.dao.LoginDAO;
import org.learning.dao.SkillDAO;
import org.learning.dao.UserDAO;
import org.learning.model.LearningPlan;
import org.learning.model.LearningPlanTemplate;
import org.learning.model.Login;
import org.learning.model.Skill;
import org.learning.model.User;
import org.learning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/index")
//@RequestMapping(value="/login")
public class DefaultFrontController {

	@Autowired
	LoginService defaultLoginService;
	@Autowired
	LoginDAO defaultLoginDAO;
	@Autowired
	UserDAO defaultUserDAO;
	
	@Autowired
	SkillDAO defaultSkillDAO;
	
	@Autowired
	LearningPlanTemplateDAO defaultLearningPlanTemplateDAO;
	
	@Autowired
	LearningPlanDAO defaultLearningPlanDAO;
	
	
//home page
	@RequestMapping(method=RequestMethod.GET)
	public String loadHome(Model model) {
				model.addAttribute("home", "home page");
		
		return "index";
	}
	
	
// Login User
		@RequestMapping(value="/login",method = RequestMethod.GET)
		public String showLoginPage(Model model) {
			model.addAttribute("login", new Login());
			
			return "login";		
		}
		
		@RequestMapping(value="/login",method = RequestMethod.POST)
		public String validateUser(@ModelAttribute("login") Login login, BindingResult result,HttpServletRequest request, HttpServletResponse response) {
			String view = "login";
			if (result.hasErrors()) {
				return "login";
			}
				
			//create a session   object and store user's details..
	 	     HttpSession session=request.getSession();  
		    
			boolean valid = defaultLoginService.validateLogin(login.getUserid(), login.getPassword());
			String role = defaultLoginDAO.getRole(login.getUserid()) ;
			if(valid) 
			{
				session.setAttribute("loginUser",login.getUserid());
				
				if (role.equalsIgnoreCase("Manager"))
						view =  "createTemplate";
				if(role.equalsIgnoreCase("Trainer"))
						view =  "assignPlan";
				if(role.equalsIgnoreCase("Employee"))
				{ System.out.println(role);
						view =  "employee";
				}
			}
			else {
				//print - invalid user in Login Page with Red Color
				
			}
			return "redirect:/index/"+view;
		} 
		
		
		@RequestMapping(value = "/redirect", method = RequestMethod.GET)
		   public String redirect() {
		      return "redirect:index/login/register";
		   }
		   
	
	
	
//New User Registration	

		@RequestMapping(value="/register",method = RequestMethod.GET)
		public  String showRegistrationPage(Model model) {
			model.addAttribute("registration", new User());
			return "Registration";
		}
		
		@RequestMapping(value="register",method = RequestMethod.POST)
		public  String showRegistrationPage(@ModelAttribute("registration") User user,BindingResult result,Model model) {
			 
			String msg="";
			if(result.hasErrors()) {
				msg="**ERROR**";
				return "Registration";
			}
			boolean valid = defaultUserDAO.createUser(user);
			if(valid) {
				msg="SUCCESS";
				model.addAttribute("success", "Successfully added  New User!!!");
			}
			System.out.println(msg);
			return "CheckingPage";
		}
	
		
//New Skill Adding To database
	
		@RequestMapping(value="/skill",method = RequestMethod.GET)
		public  String showSkillPage(Model model) {
			model.addAttribute("skill", new Skill());
			return "skill";
		}
		
		@RequestMapping(value="skill",method = RequestMethod.POST)
		public  String addSkillPage(@ModelAttribute("skill") Skill skill,BindingResult result,Model model) {
			 
			String msg="";
			if(result.hasErrors()) {
				msg="**ERROR**";
				return "skill";
			}
			boolean valid = defaultSkillDAO.createSkill(skill);
			List<Skill> skillList = defaultSkillDAO.getAllSkills();
			if(valid) {
				msg="SUCCESS";
				model.addAttribute("success", "Successfully added  New Skill!!!");
				model.addAttribute("skillList", skillList);
				
			}
			System.out.println(msg);
			System.out.println(skill.getSkillId() +"	"+skill.getCourseAttachedToTheSkill());
			
			return "redirect:/index/skill";
			//return "CheckingPage";
		}

//	Learning Plan Template
		
		@RequestMapping(value="/createTemplate",method = RequestMethod.GET)
		public  String showLearningPlanTemplate(Model model) {

			List<String> skillListCheckBox = defaultSkillDAO.getAllSkillsName();
			List<LearningPlanTemplate> planList = defaultLearningPlanTemplateDAO.getAllLearningPlanTemplate();
			Iterator<String> itr=skillListCheckBox.iterator();

	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }

			model.addAttribute("createTemplate", new LearningPlanTemplate());
			model.addAttribute("skill", skillListCheckBox);
			model.addAttribute("planList", planList);
			
			return "learningTemplate";
		}
		
		@RequestMapping(value="createTemplate",method = RequestMethod.POST)
		public  String showRegistrationPage(@ModelAttribute("createTemplate") LearningPlanTemplate learningPlanTemplate,BindingResult result,Model model)
		{
			 
			String msg="**ERROR**";
			if(result.hasErrors()) {
				//msg="";
				return "learningTemplate";
			}
			
			boolean valid = defaultLearningPlanTemplateDAO.createLearningPlanTemplate(learningPlanTemplate);

			//LearningPlanTemplate lpt = new LearningPlanTemplate();
			List<String> skillListCheckBox = defaultSkillDAO.getAllSkillsName();
			
			Iterator<String> itr=skillListCheckBox.iterator();

	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
			
			if(valid) {
				msg="SUCCESS";
				model.addAttribute("success", "Successfully added  New LearningPlan Template!!!");
				model.addAttribute("skill",skillListCheckBox );
				
			}
			System.out.println(msg);

			List<LearningPlanTemplate> learningPlanTemplateList = (List<LearningPlanTemplate>) defaultLearningPlanTemplateDAO.getAllLearningPlanTemplate();
			
			model.addAttribute("planList", learningPlanTemplateList);

			//return "CheckingPage";
			return "redirect:/index/createTemplate";
		}
	
	
	
	//Assigning LearningPlan to employee	
	
		@RequestMapping(value="/assignPlan",method = RequestMethod.GET)
		public String showAssignPage(Model model) {
			
			//list of users
			//List<User> usersList = (List<User>)defaultUserDAO.getAllUsers();
			//List<User> usersList = (List<User>)defaultUserDAO.getAllUsers("Employee");
			
			//List<LearningPlanTemplate> learningPlanTemplateList = (List<LearningPlanTemplate>) defaultLearningPlanTemplateDAO.getAllLearningPlanTemplate();
			
			model.addAttribute("assignPlan", new LearningPlan());
			//model.addAttribute("userList", usersList);
			//model.addAttribute("planList", learningPlanTemplateList);
			return "AssignPlan";		
		}
		
		@RequestMapping(value="assignPlan",method = RequestMethod.POST)
		public  String addAssignPage(@ModelAttribute("assignPlan") LearningPlan learningPlan,BindingResult result,Model model)
		{

			System.out.println(learningPlan.getEmpUserId()+learningPlan.getLearningPlanId()+learningPlan.getStartDate()+learningPlan.getEndDate());
			
			SimpleDateFormat formaDate = new SimpleDateFormat("yyyy-MM-dd");
			
			
			String msg="**ERROR**";
			if(result.hasErrors()) {
				//msg="";
				return "assignPlan";
			}
			
			boolean valid = defaultLearningPlanDAO.createLearningPlan(learningPlan);
			
	        
			if(valid) {
				
				msg="SUCCESS";
				model.addAttribute("success", "Plan Successfully assigned to employee!!!");
				
			}
			System.out.println(msg);
			//return "redirect:/login/createTemplate";
			//return "redirect:/index/assignPlan";
			return "CheckingPage";
		}
	 
//All Learning Plan for trainer to update/delete operation........
		@RequestMapping(value="/trainers",method = RequestMethod.GET)
		public String trainersCRUD(Model model,HttpServletRequest request, HttpServletResponse response) {
			
			model.addAttribute("assignPlan", new LearningPlan());
			
			List<LearningPlan> learningList = defaultLearningPlanDAO.getAllLearningPlan();
			
			model.addAttribute("learninglistForEmployee", learningList);
			model.addAttribute("success","Hii");
			
			if(learningList.size()<1) {
				model.addAttribute("assignedPlanCount", "No Records");
			}
			
						return "TrainerUpdateDelete";		
		}
		
		
///{emp.learningPlanId} @PathVariable("emp.learningPlanId")
		
		@RequestMapping( value="/trainers",method = RequestMethod.POST)
		public String deletetrainer(@RequestParam("planId") int learningPlanId,Model model) {
			//	System.out.println(learningPlanId);
			System.out.println(learningPlanId);
			boolean valid = defaultLearningPlanDAO.deleteLearningPlan(learningPlanId);
			
			System.out.println(valid);
			if(valid)
			{
				System.out.println("Learning Plan deleted successfully");
			} 
			return "redirect:/index/trainers";
		}
//delete plan-id
		@RequestMapping( value="{emp.learningPlanId}",method = RequestMethod.GET)
		public String deleteT(@PathVariable("emp.learningPlanId") int learningPlanId,Model model) {
			//	System.out.println(learningPlanId);
			System.out.println(learningPlanId);
			boolean valid = defaultLearningPlanDAO.deleteLearningPlan(learningPlanId);
			
			System.out.println(valid);
			if(valid)
			{
				System.out.println("Learning Plan deleted successfully");
			} 
			return "redirect:/index/trainers";
		}

		
		//Assigning LearningPlan to employee	
		
		
				@RequestMapping(value="/employee",method = RequestMethod.GET)
			public String showEmployee(Model model,HttpServletRequest request, HttpServletResponse response) {
				System.out.println("**HERE*");
				//model.addAttribute("assignPlan", new LearningPlan());
				
				HttpSession session=request.getSession();  
					
					String data=(String)session.getAttribute( "loginUser" );
					System.out.println(data);		
				List<LearningPlan> learningList = defaultLearningPlanDAO.getAllLearningPlanAssignedToEmployee(data);
				model.addAttribute("learninglistForEmployee", learningList);
				System.out.println("fetchdata");
				
				if(learningList.size()<1) {
					System.out.println("in if");
					model.addAttribute("assignedPlanCount", "No Records");
				}
				
				return "employeePage";	
			}
	
		

			 //logout
				@RequestMapping(value="/logout",method = RequestMethod.POST)
				public String logout(HttpSession session ) {
					session.invalidate();
					return "redirect:/index/login";
				}
				
			
		
}
