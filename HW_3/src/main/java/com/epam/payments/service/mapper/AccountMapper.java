package com.epam.payments.service.mapper;

import com.epam.payments.controller.dto.AccountDto;
import com.epam.payments.service.model.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountDto mapModelToDto(Account account);

    Account mapDtoToModel(AccountDto accountDto);

}
