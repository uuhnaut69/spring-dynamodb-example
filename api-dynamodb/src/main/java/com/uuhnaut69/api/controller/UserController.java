package com.uuhnaut69.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.entity.User;
import com.uuhnaut69.api.model.payload.UserRequest;
import com.uuhnaut69.api.service.UserService;

@RestController
@RequestMapping(path = "/v1/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<Page<User>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		Page<User> users = userService.findAll(PageRequest.of(page, pageSize));
		return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) throws Exception {
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody UserRequest request) throws Exception {
		User user = userService.add(request);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> edit(@PathVariable String id, @RequestBody UserRequest request) throws Exception {
		User user = userService.edit(id, request);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Object> delete(@PathVariable String id) throws Exception {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
