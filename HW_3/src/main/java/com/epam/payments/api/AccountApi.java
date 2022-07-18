package com.epam.payments.api;

import com.epam.payments.controller.dto.AccountDto;
import com.epam.payments.controller.dto.group.OnCreate;
import com.epam.payments.controller.dto.group.OnUpdate;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/account")
@Api(tags = "API for retrieving account data")
@ApiResponses({
        @ApiResponse(code = 400, message = "Validation Error"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface AccountApi {

    @ApiOperation("Get all accounts")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<AccountDto> getAllAccounts();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Account id")
    })
    @ApiOperation("Get account by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    AccountDto getAccountById(@PathVariable long id);

    @ApiOperation("Create account")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccountDto createAccount(@RequestBody @Validated(OnCreate.class) AccountDto accountDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Account id")
    })
    @ApiOperation("Update account")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    AccountDto updateAccount(@PathVariable long id, @RequestBody @Validated(OnUpdate.class) AccountDto accountDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Account id")
    })
    @ApiOperation("Delete account by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable long id);

}
