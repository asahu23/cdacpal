package com.cdacpal.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cdacpal.Entity.User;
import com.cdacpal.Repository.UserRepository;
import com.cdacpal.ResponsePojo.AcknowledgementPojo;
import com.cdacpal.ResponsePojo.UserLoginPojo;
import com.cdacpal.ResponsePojo.UserProfile;
import com.cdacpal.ResponsePojo.UserRegisterationPojo;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public AcknowledgementPojo registerUser(UserRegisterationPojo userRegisterationPojo)
	{
		AcknowledgementPojo ack = new AcknowledgementPojo();
		try {
			User user =new User();
			User existinguser = userRepository.findByLoginid(userRegisterationPojo.getLoginid());
			if(existinguser!=null)
			{
				ack.setSuccess(0);
				ack.setError("User Already registered with this email");
				return ack;
				
			}
			user.setName(userRegisterationPojo.getName());
			user.setPassword(userRegisterationPojo.getPassword());
			user.setLoginid(userRegisterationPojo.getLoginid());
			user.setCreationdate(new Date());
			user.setModificationdate(new Date());
			user.setMobileno(userRegisterationPojo.getMobile());
			user.setStatus(1);
			user.setLastlogin(new Date());
			user.setCourse(userRegisterationPojo.getCourse());
			user.setDob(userRegisterationPojo.getDob());
			user.setGender(userRegisterationPojo.getGender());
			user.setAddress(userRegisterationPojo.getAddress());
			userRepository.save(user);
			ack.setSuccess(1);
			ack.setError("Registration successfull!!!");
			
		} catch (Exception e) {
			// TODO: handle exception
			ack.setSuccess(0);
			ack.setError("Failed...");
		}
		
		return ack;
		
	}
	
	public AcknowledgementPojo loginUser(UserLoginPojo userLoginPojo )
	{
		AcknowledgementPojo ack = new AcknowledgementPojo();
		User user = userRepository.findByLoginid(userLoginPojo.getLoginid());
		
		if(userLoginPojo.getPassword().equals(user.getPassword()))
		{
			System.out.println("MATCHED......");
			ack.setSuccess(1);
			ack.setUserId(user.getId());
			ack.setError("Logged in!!!");
		}
		else
		{
			System.out.println("FAILED......");
			ack.setSuccess(0);
			ack.setError("Failed!!!");
		}
		
		System.out.println(user.toString());
		
		return ack;
	}
	
	public UserProfile userprofile(Long userid)
	{
	  
		User user = userRepository.findById(userid).get();
		if(user!=null)
		{
			UserProfile userprofile = new UserProfile();
			userprofile.setEmail(user.getLoginid());
			userprofile.setName(user.getName());
			userprofile.setAddress(user.getAddress());
			userprofile.setPassword(user.getPassword());
			userprofile.setMobileno(user.getMobileno());
			userprofile.setUserid(user.getId());
			return userprofile;
		}
		else
		{
			return null;
		}
	}
	

	public AcknowledgementPojo updateuserprofile(UserProfile userprofile)
	{
		
		AcknowledgementPojo ack = new AcknowledgementPojo();
		User user = userRepository.findById(userprofile.getUserid()).get();
		try {
			if(user!=null)
			{
				
				user.setName(userprofile.getName());
				user.setPassword(userprofile.getPassword());
				user.setAddress(userprofile.getAddress());
				user.setMobileno(userprofile.getMobileno());
				userRepository.save(user);
				ack.setSuccess(1);
				ack.setError("Updated Successfully");	
				return ack;
			}
			else
			{
				ack.setSuccess(0);
				ack.setError("Failed");
				return ack;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ack.setSuccess(0);
			ack.setError("Failed with exception");
			return ack;
		}
	}

}
