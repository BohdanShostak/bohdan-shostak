package com.epam.payments.service.impl;

import com.epam.payments.controller.dto.AccountDto;
import com.epam.payments.service.AccountService;
import com.epam.payments.service.mapper.AccountMapper;
import com.epam.payments.service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public AccountDto getAccount(long id) {
        return accountMapper.mapModelToDto(accountRepository.getAccount(id));
    }

    @Override
    public List<AccountDto> listAccounts() {
        return accountRepository.listAccounts()
                .stream()
                .map(accountMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        log.info("Account with id {} was created", accountDto.getId());
        return accountMapper.mapModelToDto(accountRepository.createAccount(accountMapper.mapDtoToModel(accountDto)));
    }

    @Override
    public AccountDto updateAccount(long id, AccountDto accountDto) {
        accountDto.setId(id);
        log.info("Account with id {} was updated", accountDto.getId());
        return accountMapper.mapModelToDto(accountRepository.updateAccount(id, accountMapper.mapDtoToModel(accountDto)));
    }

    @Override
    public void deleteAccount(long id) {
        accountRepository.deleteAccount(id);
        log.info("Account with id {} was deleted", id);
    }

}
