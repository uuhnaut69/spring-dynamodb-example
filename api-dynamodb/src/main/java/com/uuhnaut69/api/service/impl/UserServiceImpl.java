package com.uuhnaut69.api.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uuhnaut69.api.model.entity.User;
import com.uuhnaut69.api.model.mapper.UserMapper;
import com.uuhnaut69.api.model.payload.UserRequest;
import com.uuhnaut69.api.repository.UserRepository;
import com.uuhnaut69.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public User findById(String id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new Exception());
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User add(UserRequest request) {
		return save(request, new User());
	}

	@Override
	public User edit(String id, UserRequest request) throws Exception {
		User user = findById(id);
		return save(request, user);
	}

	@Override
	public void delete(String id) throws Exception {
		User user = findById(id);
		userRepository.delete(user);
	}

	private User save(UserRequest request, User user) {
		user = userMapper.toUserEntity(request);
		return userRepository.save(user);
	}
}
