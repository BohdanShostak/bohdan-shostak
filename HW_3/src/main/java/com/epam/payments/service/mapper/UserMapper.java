package com.epam.payments.service.mapper;

import com.epam.payments.controller.dto.UserDto;
import com.epam.payments.service.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto mapModelToDto(User user);

    User mapDtoToModel(UserDto userDto);

}
