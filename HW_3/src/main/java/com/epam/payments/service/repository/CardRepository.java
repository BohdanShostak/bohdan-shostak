package com.epam.payments.service.repository;

import com.epam.payments.service.model.Card;

import java.util.List;

public interface CardRepository {

    Card getCard(long cardNumber);

    List<Card> listCards();

    Card createCard(Card card);

    Card updateCard(long cardNumber, Card card);

    void deleteCard(long cardNumber);

}
