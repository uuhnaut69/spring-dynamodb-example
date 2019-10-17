package com.uuhnaut69.api.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.uuhnaut69.api.model.entity.User;

@EnableScan
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	Page<User> findAll(Pageable pageable);

}
