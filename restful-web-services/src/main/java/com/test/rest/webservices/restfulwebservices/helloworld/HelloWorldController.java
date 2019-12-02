package com.test.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	//GET
	//URI - /hello-world
	//method - "Hello World"
	//@RequestMapping(method=RequestMethod.Get, path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWord() {
		return "Hello World";
	}
	
	//GET
	//URI - /hello-world-bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//URI - /hello-world/{id}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldById(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	//internalization
	@GetMapping(path="/hello-world-internalized")
	public String helloWorldInternalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
}
