package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.User;
import com.demo.service.UserService;

@Controller
public class UserController {
	   private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService uservice;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addinguser(@ModelAttribute User user,Model model)
	{
		User u=uservice.useradd(user);
		System.out.println("controller add");
		model.addAttribute("ac",user.getAcnumber());
		LOGGER.info("printHello ended.****************************");
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("************************************************");
		LOGGER.debug("__-----_________------________-----");
		return "success";
	}
	@RequestMapping("/create")
	public String about()
	{
		LOGGER.info("printHello ended.");

	
		return "account";
	}
	@RequestMapping(path = "/list")
	public String home(Model m) {

		List<User> list = uservice.getAll();
		System.out.println(list);
		m.addAttribute("userList", list);
		return "list";
	}
	@RequestMapping(value="/addd",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> adding(User user)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		if(uservice.useradd(user)!=null)
		{
			map.put("status", "200");
			map.put("massage","your record have been saved successfully");
		}
		return map;
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAa(User user)
	{
		List<User> list=uservice.getAll();
		Map<String,Object> map=new HashMap<String,Object>();
		if(list!=null)
		{
			map.put("status", "200");
			map.put("massage","your record have been saved successfully");
			map.put("data", list);
		}
		else {
			map.put("status", "404");
			map.put("massage","not successdylly");
		}
		return map;
	}
	@RequestMapping("/newone")
	public String aboutt()
	{
		LOGGER.info("printHello ended.");

	
		return "newform";
	
	
	}
}
