package com.test.rest.webservices.restfulwebservices;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.webservices.restfulwebservices.Book;;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1l, "mastering Spring boot 2.1", "Me"));
	
	}
}
