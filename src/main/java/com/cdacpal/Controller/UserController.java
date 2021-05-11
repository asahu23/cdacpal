package com.cdacpal.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cdacpal.Entity.User;
import com.cdacpal.Repository.UserRepository;
import com.cdacpal.ResponsePojo.AcknowledgementPojo;
import com.cdacpal.ResponsePojo.UserLoginPojo;
import com.cdacpal.ResponsePojo.UserProfile;
import com.cdacpal.ResponsePojo.UserRegisterationPojo;
import com.cdacpal.Service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	UserService userService; 
	
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@RequestMapping("user/register")
	public AcknowledgementPojo getRegister(UserRegisterationPojo userRegisterationPojo,BindingResult bindingResult)
	{
		AcknowledgementPojo ack = new AcknowledgementPojo();
		System.out.println("userRegisterationPojo => "+userRegisterationPojo.toString());
		if(bindingResult.hasErrors())
		{
			System.out.println("ERRORRRRRRRRRRRRRRR CAME.......");
			ack.setSuccess(0);
			ack.setError("Invalid Form");
			return ack;
		}
		ack =	userService.registerUser(userRegisterationPojo);
		
		ack.setError("Successfully registered");
		
		return ack;
	}
	@PostMapping("user/login")
	public AcknowledgementPojo getLogin(UserLoginPojo userLoginPojo)
	{  
		System.out.println("ffdfdfdsfdsfsdf+++++++++++");
	
		
		 AcknowledgementPojo ack = userService.loginUser(userLoginPojo);
		 		 		
		
		System.out.println(userLoginPojo.toString());
	
		
		return ack;
		
	}


	@RequestMapping("user/logindetail")
	public List<UserLoginPojo> getDetails(UserLoginPojo  UserLoginPojo)
	{
	
		System.out.println("-----------------"); 
		List<UserLoginPojo> userLoginPojo = new ArrayList<>();
		  List<User>  userMaterial = (List)userRepository.findByLoginid(UserLoginPojo.getLoginid());
		 		  for (User user : userMaterial) {
			  
			  		userLoginPojo.add(new UserLoginPojo(user.getLoginid()));
			     
		  		}
		 		 System.out.println("++++++++++++++++++"); 
	     System.out.println(userLoginPojo.toString()); 
		return userLoginPojo;
	}
	
	@RequestMapping("user/getprofile")
	public UserProfile getDetailsOfUser(Long userid)
	{
		System.out.println(userid);
		return userService.userprofile(userid);
	}
	
	
	


	
	@RequestMapping("user/updateprofile")
	public AcknowledgementPojo updateDetailsOfUser(UserProfile userProfile)
	{
		System.out.println("Ho ja update");
		
		return userService.updateuserprofile(userProfile);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
