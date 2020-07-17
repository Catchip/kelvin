package grp.team7.kelvin.controller;

import grp.team7.kelvin.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testservice;
	public TestController() {
	
	}
}
