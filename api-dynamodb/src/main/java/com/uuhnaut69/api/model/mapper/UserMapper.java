package com.uuhnaut69.api.model.mapper;

import org.mapstruct.Mapper;

import com.uuhnaut69.api.model.entity.User;
import com.uuhnaut69.api.model.payload.UserRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User toUserEntity(UserRequest request);
}
