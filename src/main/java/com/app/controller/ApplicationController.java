package com.app.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/app")
public class ApplicationController {	
	
	@RequestMapping(path = "/handlerMethod1")
	public ResponseEntity<Map<String, Object>> handlerMethod1(@RequestParam(name = "file") MultipartFile multipartFile){
		System.out.println("multipartFile"+multipartFile.toString());
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try{
			Map<String, Object> fileData = new LinkedHashMap<>();
			fileData.put("name", multipartFile.getName());
			fileData.put("originalFilename", multipartFile.getOriginalFilename());
			fileData.put("size", multipartFile.getSize());
			
			responseEntity = new ResponseEntity<Map<String, Object>>(fileData, HttpStatus.OK);
		}catch(Exception e) {
			responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@RequestMapping(path = "/handlerMethod2")
	public ResponseEntity<List<Map<String, Object>>> handlerMethod2(@RequestParam(name = "files") MultipartFile[] multipartFiles){
		ResponseEntity<List<Map<String, Object>>> responseEntity = null;
		try{
			List<Map<String, Object>> filesList = new LinkedList<>();
			Map<String, Object> fileData =  null;
			for(MultipartFile multipartFile : multipartFiles) {
				fileData = new LinkedHashMap<>();
				fileData.put("name", multipartFile.getName());
				fileData.put("originalFilename", multipartFile.getOriginalFilename());
				fileData.put("size", multipartFile.getSize());
				
				filesList.add(fileData);
			}
			
			responseEntity = new ResponseEntity<List<Map<String, Object>>>(filesList, HttpStatus.OK);
		}catch(Exception e) {
			responseEntity = new ResponseEntity<List<Map<String, Object>>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
}
