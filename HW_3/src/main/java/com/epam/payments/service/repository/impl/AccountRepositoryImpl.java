package com.epam.payments.service.repository.impl;

import com.epam.payments.exception.AccountNotFoundException;
import com.epam.payments.service.model.Account;
import com.epam.payments.service.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final List<Account> accountList = new ArrayList<>();

    @Override
    public Account getAccount(long id) {
        return accountList.stream()
                .filter(account -> account.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public List<Account> listAccounts() {
        return new ArrayList<>(accountList);
    }

    @Override
    public Account createAccount(Account account) {
        account.setId(accountList.size() + 1);
        accountList.add(account);
        return account;
    }

    @Override
    public Account updateAccount(long id, Account account) {
        Account oldAccount = accountList.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(id));
        accountList.remove(oldAccount);
        account.setId(oldAccount.getId());
        accountList.add(account);
        return account;
    }

    @Override
    public void deleteAccount(long id) {
        accountList.removeIf(account -> account.getId() == id);
    }

}
