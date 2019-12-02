package com.test.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserRepository service;

	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		Optional<User> user = service.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return user.get();
	}
	
	@PostMapping("/users")
	public User createUser(User user) {
		User savedUser = service.save(user);
		return savedUser;
	}
	
	@DeleteMapping("users/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);		
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrievePost(@PathVariable int id) {
		Optional<User> user = service.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public void createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> user = service.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		post.setUser(user.get());
		postRepository.save(post);
	}
/*
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id-"+ id);
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		model.add(linkTo.withRel("all-users"));
		//HATEOAS
		return model;
	}

	// input - user
	// output - CREATED & the created Uri
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		//CREATED
		// /user/4
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	*/
	// input - id
	// output - DELETED

}
