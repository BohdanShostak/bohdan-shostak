package com.epam.payments.service.repository.impl;

import com.epam.payments.service.model.Card;
import com.epam.payments.service.repository.CardRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cardList = new ArrayList<>();

    @Override
    public Card getCard(long cardNumber) {
        return cardList.stream()
                .filter(card -> card.getCardNumber() == cardNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Card is not found!"));
    }

    @Override
    public List<Card> listCards() {
        return new ArrayList<>(cardList);
    }

    @Override
    public Card createCard(Card card) {
        cardList.add(card);
        return card;
    }

    @Override
    public Card updateCard(long cardNumber, Card card) {
        boolean isDeleted = cardList.removeIf(c -> c.getCardNumber() == cardNumber);
        if (isDeleted) {
            cardList.add(card);
        } else {
            throw new RuntimeException("Card is not found!");
        }
        return card;
    }

    @Override
    public void deleteCard(long cardNumber) {
        cardList.removeIf(card -> card.getCardNumber() == cardNumber);
    }

}
