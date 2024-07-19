package com.ssiluveru.userinfo.mapper;

import com.ssiluveru.userinfo.dto.UserDTO;
import com.ssiluveru.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOtoUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);

}
