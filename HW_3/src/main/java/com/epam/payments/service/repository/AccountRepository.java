package com.epam.payments.service.repository;

import com.epam.payments.service.model.Account;

import java.util.List;

public interface AccountRepository {

    Account getAccount(long id);

    List<Account> listAccounts();

    Account createAccount(Account account);

    Account updateAccount(long id, Account account);

    void deleteAccount(long id);

}
