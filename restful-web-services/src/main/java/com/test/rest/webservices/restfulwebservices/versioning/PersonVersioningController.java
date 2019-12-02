package com.test.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	//1. different uri
	@GetMapping("v1/person")
	public Person personV1() {
		return new Person("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//2. different params versioning
	@GetMapping(value="/person/params", params="version=1")
	public Person paramV1() {
		return new Person("Bob Charlie");
	}
	
	@GetMapping(value="/person/params", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//3. header versioning
	@GetMapping(value="/person/header", headers = "X-API-VERSION=1")
	public Person headerV1() {
		return new Person("Bob Charlie");
	}

	@GetMapping(value="/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//4. produces (MIME type, a.k.a content negotiation or accept header)
	@GetMapping(value="/person/produces", produces = "application/cnd.test.com-v1+json")
	public Person producesV1() {
		return new Person("Bob Charlie");
	}

	@GetMapping(value="/person/produces", produces = "application/cnd.test.com-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
