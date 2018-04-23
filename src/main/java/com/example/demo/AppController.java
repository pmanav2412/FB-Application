package com.example.demo;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Controller
public class AppController {
	
	
	

	@GetMapping(value="/")
	public ModelAndView renderIndex() {
		System.out.println("in index");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fb_login");
		return mv;
	}
	
	@PostMapping(value="/facebookRedirect")
	public ModelAndView handleRedirect( 
		@RequestParam(name="myID") String myID,
		@RequestParam(name="myName") String myName,
		@RequestParam(name="myFriends") String myFriends,
		@RequestParam(name="myEmail") String myEmail,
		HttpServletRequest req
		 ) {
		System.out.println(myID + myName + myEmail + myFriends);
		String[] s= myFriends.split("/");
		for(int i=0;i< s.length;i++)
		{
			System.out.println(i +":" + s[i]);
		}
		req.getSession().setAttribute("userID", myID);
		
		return new ModelAndView("profile");
		
	}
	
	@GetMapping(value = "/createProfile")
	public ModelAndView renderPage() {
		ModelAndView indexPage = new ModelAndView();
		indexPage.setViewName("createProfile");
		return indexPage;
		
		
	}
	
	@Autowired
	private UserRepo UsersRepo;

	@PostMapping(value="/profile")
	public ModelAndView updateProfile(
			@RequestParam(name="id", required= false) Integer id,
			@RequestParam String name,
			@RequestParam String dis
			
		){
		Users usr= new Users();
		System.out.println("hey");
		usr.setId(id);
		usr.setName(name);
		usr.setDis(dis);
		UsersRepo.save(usr);
		
		return new ModelAndView("redirect:/profile1");
		
	}
	
	
@GetMapping(value="/profile1")
	public ModelAndView seeProfile(@RequestParam(name="id",required=true) String id) {
		ModelAndView mv= new ModelAndView();
	try {
			Optional<Users> user=UsersRepo.findById(Integer.parseInt(id));
			if(user.isPresent()) {
			Users u= user.get();
				mv.addObject("Users",u);
				mv.setViewName("profile");
			}
		else
		{
			throw new Exception("lol");
		}
			
	}
		catch(Exception e) {
			mv.addObject("error","User not present");
					mv.setViewName("error");
					e.printStackTrace();
		}
	return mv;
	}
	
	
	
//	@GetMapping(value="/addToProfile")
//	public ModelAndView viewProfile() {
//		ModelAndView mv= new ModelAndView();
//		List<Users> profile= UserRepo.findAll();
//		mv.addObject("Profile", profile);
//		mv.setViewName("profile");
//		return mv;
//	}
	
	
//	@PostMapping(value = "/profile")
//	public ModelAndView uploadToS3(
//			@RequestParam("file") MultipartFile image
//			)
//	{
//		ModelAndView profilePage = new ModelAndView();
//		BasicAWSCredentials cred = new BasicAWSCredentials(
//				"AKIAINUGJKC4BRTAYHEQ","kUu7z3WgLnpcXOMjF/c08YHlkI6huXR3lWG/D2Pl" 
//					);
//		
//		AmazonS3 s3client = AmazonS3ClientBuilder
//				.standard()
//				.withCredentials(new AWSStaticCredentialsProvider(cred))
//				.withRegion(Regions.US_EAST_1)
//				.build();
//		
//		try {
//			PutObjectRequest putReq = new PutObjectRequest("hw2se2",image.getOriginalFilename(),image.getInputStream(),new ObjectMetadata());
//			withCannedAcl(CannedAccessControlList.PublicRead);
//			s3client.putObject(putReq);
//			  String imgsrc =  "http://"+"hw2se2"  +".s3.amazonaws.com/"+image.getOriginalFilename();
//	    	   profilePage.addObject("imgsrc",imgsrc);
//	    	   profilePage.setViewName("profile");
//	    	   return profilePage;
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//			profilePage.setViewName("error");
//			return profilePage;
//		}
//			
//	}
	
	
	
	private void withCannedAcl (CannedAccessControlList publicread) {
		// TODO Auto-generated method stub
		
	}
}

