package com.epam.payments.service.mapper;

import com.epam.payments.controller.dto.CardDto;
import com.epam.payments.service.model.Card;
import org.mapstruct.Mapper;

@Mapper
public interface CardMapper {

    CardDto mapModelToDto(Card card);

    Card mapDtoToModel(CardDto cardDto);

}
