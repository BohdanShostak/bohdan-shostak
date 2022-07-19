package com.epam.payments.api;

import com.epam.payments.controller.dto.CardDto;
import com.epam.payments.controller.validation.group.OnCreate;
import com.epam.payments.controller.validation.group.OnUpdate;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/card")
@Api(tags = "API for retrieving card data")
@ApiResponses({
        @ApiResponse(code = 400, message = "Validation Error"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface CardApi {

    @ApiOperation("Get all cards")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CardDto> getAllCards();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardNumber", paramType = "path", required = true, value = "Card number")
    })
    @ApiOperation("Get card by cardNumber")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cardNumber}")
    CardDto getCardByCardNumber(@PathVariable long cardNumber);

    @ApiOperation("Create card")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CardDto createCard(@RequestBody @Validated(OnCreate.class) CardDto cardDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardNumber", paramType = "path", required = true, value = "Card number")
    })
    @ApiOperation("Update card")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{cardNumber}")
    CardDto updateCard(@PathVariable long cardNumber, @RequestBody @Validated(OnUpdate.class) CardDto cardDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardNumber", paramType = "path", required = true, value = "Card number")
    })
    @ApiOperation("Delete card by card number")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{cardNumber}")
    void deleteCard(@PathVariable long cardNumber);

}
