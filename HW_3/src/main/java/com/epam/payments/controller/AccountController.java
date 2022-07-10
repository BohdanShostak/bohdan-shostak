package com.epam.payments.controller;

import com.epam.payments.controller.dto.AccountDto;
import com.epam.payments.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AccountDto> getAllAccounts() {
        log.info("getAllAccounts");
        return accountService.listAccounts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable long id) {
        log.info("getAccount by id {}", id);
        return accountService.getAccount(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        log.info("createAccount with id {}", accountDto.getId());
        return accountService.createAccount(accountDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public AccountDto updateAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {
        log.info("updateAccount by id {}", id);
        return accountService.updateAccount(id, accountDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        log.info("deleteAccount by id {}", id);
        accountService.deleteAccount(id);
    }

}
