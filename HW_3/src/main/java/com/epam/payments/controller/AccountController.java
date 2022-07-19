package com.epam.payments.controller;

import com.epam.payments.api.AccountApi;
import com.epam.payments.controller.dto.AccountDto;
import com.epam.payments.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountController implements AccountApi {

    private final AccountService accountService;

    @Override
    public List<AccountDto> getAllAccounts() {
        log.info("getAllAccounts");
        return accountService.listAccounts();
    }

    @Override
    public AccountDto getAccountById(long id) {
        log.info("getAccount by id {}", id);
        return accountService.getAccount(id);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        log.info("createAccount with id {}", accountDto.getId());
        return accountService.createAccount(accountDto);
    }

    @Override
    public AccountDto updateAccount(long id, AccountDto accountDto) {
        log.info("updateAccount by id {}", id);
        return accountService.updateAccount(id, accountDto);
    }

    @Override
    public void deleteAccount(long id) {
        log.info("deleteAccount by id {}", id);
        accountService.deleteAccount(id);
    }

}
