package com.banking.user.mapper;

import org.mapstruct.Mapper;

import com.banking.user.entity.User;
import com.banking.user.model.request.UserSaveRequestDTO;
import com.banking.user.model.response.UserDTO;

@Mapper
public interface UserRequestMapper {

	User userReqDTOToUser(UserSaveRequestDTO userRequestDTO);
	
	UserSaveRequestDTO userToUserSaveReqDTO(User user);
	
	UserDTO userTOUserDTO(User user);
}
