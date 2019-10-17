package com.uuhnaut69.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.uuhnaut69.api.model.entity.User;
import com.uuhnaut69.api.model.payload.UserRequest;

public interface UserService {

	User findById(String id) throws Exception;

	Page<User> findAll(Pageable pageable);

	User add(UserRequest request);

	User edit(String id, UserRequest request) throws Exception;

	void delete(String id) throws Exception;
}
