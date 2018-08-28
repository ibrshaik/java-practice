package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentServiceDelegate;

@RestController
public class SchoolServiceController {
	
	@Autowired
	private StudentServiceDelegate studetnServiceDelegate;
	
	
	@RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.POST)
	public String getStudents(@PathVariable String schoolname) {
		
		System.out.println("getting student details ");
		
		return studetnServiceDelegate.callStudentServiceAndGetData(schoolname);
	}
	
}