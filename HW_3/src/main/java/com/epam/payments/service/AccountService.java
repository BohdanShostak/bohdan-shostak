package com.epam.payments.service;

import com.epam.payments.controller.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto getAccount(long id);

    List<AccountDto> listAccounts();

    AccountDto createAccount(AccountDto accountDto);

    AccountDto updateAccount(long id, AccountDto accountDto);

    void deleteAccount(long id);

}
