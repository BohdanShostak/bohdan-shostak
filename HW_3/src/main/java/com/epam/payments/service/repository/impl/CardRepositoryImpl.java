package com.epam.payments.service.repository.impl;

import com.epam.payments.exception.CardNotFoundException;
import com.epam.payments.exception.EntityExistsException;
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
                .orElseThrow(() -> new CardNotFoundException(cardNumber));
    }

    @Override
    public List<Card> listCards() {
        return new ArrayList<>(cardList);
    }

    @Override
    public Card createCard(Card card) {
        if (cardList.stream().anyMatch((c)->c.getCardNumber() == (card.getCardNumber()))) {
            throw new EntityExistsException("Card with this cardNumber already exists");
        }
        cardList.add(card);
        return card;
    }

    @Override
    public Card updateCard(long cardNumber, Card card) {
        Card oldCard = cardList.stream()
                .filter(c -> c.getCardNumber() == cardNumber)
                .findFirst()
                .orElseThrow(() -> new CardNotFoundException(cardNumber));
        cardList.remove(oldCard);
        card.setCardNumber(oldCard.getCardNumber());
        cardList.add(card);
        return card;
    }

    @Override
    public void deleteCard(long cardNumber) {
        cardList.removeIf(card -> card.getCardNumber() == cardNumber);
    }

}
