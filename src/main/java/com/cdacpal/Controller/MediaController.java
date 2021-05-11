package com.cdacpal.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.util.ReactiveWrapperConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cdacpal.Entity.Course;
import com.cdacpal.Entity.Media;
import com.cdacpal.Repository.CourseRepository;
import com.cdacpal.Repository.MediaRepository;
import com.cdacpal.ResponsePojo.AcknowledgementPojo;
import com.cdacpal.ResponsePojo.CourseMaterialPojo;
import com.fasterxml.jackson.databind.util.JSONPObject;

@CrossOrigin("*")
@RestController
public class MediaController {

	@Autowired
	Environment environment;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	MediaRepository mediaRepository;
	
	@RequestMapping(value = "/media/fileupload" , method = RequestMethod.POST)
	@ResponseBody 
	public ResponseEntity<?> fileupload(
			
			@RequestParam("uploadfile") MultipartFile uploadFile ,@RequestParam("courseid")  Long courseid){
		Course course = courseRepository.findById(courseid).get();
		if(course!=null)
		{
			try {
				
				AcknowledgementPojo ack = new AcknowledgementPojo();
				//System.out.println("dsfdsfds"+courseid);
				System.out.println("///////////////////");
				// Get the filename and build the local file path (be sure that the 
			    // application have write permissions on such directory)
				String filename = uploadFile.getOriginalFilename();
				
				String perfectfilename = filename.replaceAll(" " ,"_");
				
				char ch[] = perfectfilename.toCharArray();
				int dot=0;
				for(int i=perfectfilename.length()-1;i>=0;i--)
				{
					if(ch[i] == '.')
					{
						if(dot++ > 0)
							ch[i] = '-';
					}
					
				}
				String s = new String(ch);
				perfectfilename = s;
				
				String directory = environment.getProperty("file.path.save");
				String filepath = Paths.get(directory,perfectfilename).toString();
				
				// Save the file locally
				BufferedOutputStream stream =  new BufferedOutputStream(new FileOutputStream(new File(filepath)));
						stream.write(uploadFile.getBytes());
						stream.close();
						int i=0;
						
						Media media = new Media();
						media.setCourseid(courseid);
						media.setCreationdate(new Date());
						media.setModificationdate(new Date());
						media.setFilename(perfectfilename);
						media.setFiletype(uploadFile.getContentType());
						media.setFilepath(directory);
						media.setStatus(1);
						media.setFilesize(uploadFile.getSize());
						mediaRepository.save(media);
						ack.setError("Uploaded Successfully");
						ack.setSuccess(1);
				
						
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);	
		}
		
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
				
	
	@RequestMapping("getcoursematerial")
    public List<CourseMaterialPojo> getCourseMaterial(Long courseid)
	{
		AcknowledgementPojo ack = new AcknowledgementPojo();
		List<CourseMaterialPojo> courseMaterialPojo = new ArrayList<>();
				List<Media> courseMaterial = mediaRepository.findMediaByCourseid(courseid);
		
				for (Media media : courseMaterial) {
				String fileurl = environment.getProperty("file.response.path");
				Course course = courseRepository.findById(media.getCourseid()).get();
			   	
				

				courseMaterialPojo.add(new CourseMaterialPojo(course.getName(), media.getFilename(),fileurl+ media.getFilename(), media.getFilesize()));
		       
			   }
				
		ModelAndView  modelAndView = new ModelAndView();
		
		return courseMaterialPojo;
		
				
	}
	
	@RequestMapping("getALLcoursematerial")
    public List<CourseMaterialPojo> getAllCourseMaterial()
	{
		AcknowledgementPojo ack = new AcknowledgementPojo();
		List<CourseMaterialPojo> courseMaterialPojo = new ArrayList<>();
				List<Media> courseMaterial = mediaRepository.findAll();
		
				for (Media media : courseMaterial) {
				String fileurl = environment.getProperty("file.response.path");
				Course course = courseRepository.findById(media.getCourseid()).get();
			   	
				

				courseMaterialPojo.add(new CourseMaterialPojo(course.getName(), media.getFilename(),fileurl+ media.getFilename(), media.getFilesize()));
		       
			   }
				
	//	ModelAndView  modelAndView = new ModelAndView();
		
		return courseMaterialPojo;
		
				
	}
	

	
	
	
  

	
	

	
}
