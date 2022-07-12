package com.epam.payments.controller;

import com.epam.payments.controller.dto.CardDto;
import com.epam.payments.controller.dto.group.OnCreate;
import com.epam.payments.controller.dto.group.OnUpdate;
import com.epam.payments.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardService cardService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CardDto> getAllCards() {
        log.info("getAllCards");
        return cardService.listCards();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cardNumber}")
    public CardDto getCardByCardNumber(@PathVariable long cardNumber) {
        log.info("getCard by carNumber {}", cardNumber);
        return cardService.getCard(cardNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CardDto createCard(@RequestBody @Validated(OnCreate.class) CardDto cardDto) {
        log.info("createCard with cardNumber {}", cardDto.getCardNumber());
        return cardService.createCard(cardDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{cardNumber}")
    public CardDto updateCard(@PathVariable long cardNumber, @RequestBody @Validated(OnUpdate.class) CardDto cardDto) {
        log.info("updateCard by cardNumber {}", cardNumber);
        return cardService.updateCard(cardNumber, cardDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{cardNumber}")
    public void deleteCard(@PathVariable long cardNumber) {
        log.info("deleteCard by cardNumber {}", cardNumber);
        cardService.deleteCard(cardNumber);
    }

}
