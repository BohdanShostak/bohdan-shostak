package com.epam.payments.service.impl;

import com.epam.payments.controller.dto.CardDto;
import com.epam.payments.service.CardService;
import com.epam.payments.service.mapper.CardMapper;
import com.epam.payments.service.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    @Override
    public CardDto getCard(long cardNumber) {
        return cardMapper.mapModelToDto(cardRepository.getCard(cardNumber));
    }

    @Override
    public List<CardDto> listCards() {
        return cardRepository.listCards()
                .stream()
                .map(cardMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto createCard(CardDto cardDto) {
        log.info("Card with cardNumber {} was created", cardDto.getCardNumber());
        return cardMapper.mapModelToDto(cardRepository.createCard(cardMapper.mapDtoToModel(cardDto)));
    }

    @Override
    public CardDto updateCard(long cardNumber, CardDto cardDto) {
        cardDto.setCardNumber(cardNumber);
        log.info("Card with cardNumber {} was updated", cardDto.getCardNumber());
        return cardMapper.mapModelToDto(cardRepository.updateCard(cardNumber, cardMapper.mapDtoToModel(cardDto)));
    }

    @Override
    public void deleteCard(long cardNumber) {
        cardRepository.deleteCard(cardNumber);
        log.info("Card with cardNumber {} was deleted", cardNumber);
    }

}
