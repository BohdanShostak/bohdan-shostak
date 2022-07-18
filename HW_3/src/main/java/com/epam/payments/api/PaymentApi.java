package com.epam.payments.api;

import com.epam.payments.controller.dto.PaymentDto;
import com.epam.payments.controller.dto.validation.group.OnCreate;
import com.epam.payments.controller.dto.validation.group.OnUpdate;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/payment")
@Api(tags = "API for retrieving payment data")
@ApiResponses({
        @ApiResponse(code = 400, message = "Validation Error"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public interface PaymentApi {

    @ApiOperation("Get all payments")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<PaymentDto> getAllPayments();

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Payment id")
    })
    @ApiOperation("Get payment by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    PaymentDto getPaymentById(@PathVariable int id);

    @ApiOperation("Create payment")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    PaymentDto createPayment(@RequestBody @Validated(OnCreate.class) PaymentDto paymentDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Payment id")
    })
    @ApiOperation("Update payment")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    PaymentDto updatePayment(@PathVariable int id, @RequestBody @Validated(OnUpdate.class) PaymentDto paymentDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Payment id")
    })
    @ApiOperation("Delete payment by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletePayment(@PathVariable int id);

}
