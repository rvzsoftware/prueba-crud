package com.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.dao.AdminUserDao;
import com.spring.model.UserDetails;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class TestController {
	
	@Autowired
	AdminUserDao userService;
	
	@RequestMapping(value="/test",method = RequestMethod.GET,
			headers="Accept=application/json")
	@ResponseBody
	public HashMap<String,String>test(){
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		map.put("1", "OK");
		
		System.out.println(map);
		
		return map;
	}
	
	@RequestMapping(value="/rest/findUsers",method = RequestMethod.GET,
			headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<List<UserDetails>>findUsers(){
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		List<UserDetails> listUser = userService.findAllUsers();
		
		if(listUser.isEmpty()){
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDetails>>(listUser, HttpStatus.OK);
		
	
	}
	
	@RequestMapping(value = "/rest/addUser", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserDetails user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getNombre());
  
       
        userService.saveUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
