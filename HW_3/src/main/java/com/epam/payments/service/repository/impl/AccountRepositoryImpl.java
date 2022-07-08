package com.epam.payments.service.repository.impl;

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
                .orElseThrow(() -> new RuntimeException("Account is not found!"));
    }

    @Override
    public List<Account> listAccounts() {
        return new ArrayList<>(accountList);
    }

    @Override
    public Account createAccount(Account account) {
        accountList.add(account);
        return account;
    }

    @Override
    public Account updateAccount(long id, Account account) {
        boolean isDeleted = accountList.removeIf(a -> a.getId() == id);
        if (isDeleted) {
            accountList.add(account);
        } else {
            throw new RuntimeException("Account is not found!");
        }
        return account;
    }

    @Override
    public void deleteAccount(long id) {
        accountList.removeIf(account -> account.getId() == id);
    }

}
