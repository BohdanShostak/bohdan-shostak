package com.epam.payments.service;

import com.epam.payments.controller.dto.CardDto;

import java.util.List;

public interface CardService {

    CardDto getCard(long cardNumber);

    List<CardDto> listCards();

    CardDto createCard(CardDto cardDto);

    CardDto updateCard(long cardNumber, CardDto cardDto);

    void deleteCard(long cardNumber);

}
