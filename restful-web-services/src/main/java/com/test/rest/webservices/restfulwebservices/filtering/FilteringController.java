package com.test.rest.webservices.restfulwebservices.filtering;

import java.util.List;

import java.util.Arrays;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//dynamic filtering
	//field1, field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("v1", "v2", "v3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); 
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//dyanmic
	//field2, field3
	@GetMapping(path="/filtering-list")
	public MappingJacksonValue retrieveBeanList() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("val1", "val2", "val3"), new SomeBean("value11", "value22", "value33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2", "value3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); 
		
		MappingJacksonValue mapping = new MappingJacksonValue(asList);
		mapping.setFilters(filters);
		return mapping;
	}
}
