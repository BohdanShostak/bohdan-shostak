package com.epam.payments.api;

import com.epam.payments.controller.dto.UserDto;
import com.epam.payments.controller.validation.group.OnCreate;
import com.epam.payments.controller.validation.group.OnUpdate;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@Api(tags = "API for retrieving user data")
@ApiResponses({
        @ApiResponse(code = 400, message = "Validation Error"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface UserApi {

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<UserDto> getAllUsers();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Get user by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    UserDto getUserByEmail(@PathVariable String email);

    @ApiOperation("Create user")
      @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDto createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    UserDto updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Delete user by email")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{email}")
    void deleteUser(@PathVariable String email);

}
