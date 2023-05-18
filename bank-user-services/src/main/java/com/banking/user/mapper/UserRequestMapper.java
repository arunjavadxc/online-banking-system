package com.banking.user.mapper;

import org.mapstruct.Mapper;

import com.banking.user.entity.User;
import com.banking.user.model.request.UserSaveRequestDTO;

@Mapper
public interface UserRequestMapper {

	User userReqDTOToUser(UserSaveRequestDTO userRequestDTO);
	
}
