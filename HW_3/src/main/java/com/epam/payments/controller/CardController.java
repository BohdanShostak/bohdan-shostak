package com.epam.payments.controller;

import com.epam.payments.api.CardApi;
import com.epam.payments.controller.dto.CardDto;
import com.epam.payments.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CardController implements CardApi {

    private final CardService cardService;

    @Override
    public List<CardDto> getAllCards() {
        log.info("getAllCards");
        return cardService.listCards();
    }

    @Override
    public CardDto getCardByCardNumber(long cardNumber) {
        log.info("getCard by carNumber {}", cardNumber);
        return cardService.getCard(cardNumber);
    }

    @Override
    public CardDto createCard(CardDto cardDto) {
        log.info("createCard with cardNumber {}", cardDto.getCardNumber());
        return cardService.createCard(cardDto);
    }

    @Override
    public CardDto updateCard(long cardNumber, CardDto cardDto) {
        log.info("updateCard by cardNumber {}", cardNumber);
        return cardService.updateCard(cardNumber, cardDto);
    }

    @Override
    public void deleteCard(long cardNumber) {
        log.info("deleteCard by cardNumber {}", cardNumber);
        cardService.deleteCard(cardNumber);
    }

}
