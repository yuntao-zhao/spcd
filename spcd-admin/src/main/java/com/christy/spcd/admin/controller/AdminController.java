package com.christy.spcd.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christy.spcd.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping("/hello")
	public String hello(){
		return adminService.hello();
	}
	
}
