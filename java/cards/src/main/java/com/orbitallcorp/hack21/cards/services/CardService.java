package com.orbitallcorp.hack21.cards.services;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save((card));
    }

    public List<Card> findAll() {
        List<Card> cards = new ArrayList<Card>();
        for (Card card : (List<Card>) cardRepository.findAll()){
            cards.add(card);
        }
        return cards;
    }

    public void delete(Long id) {
        findAll().remove(cardRepository);
    }

    public void replace(Card card) {
        delete(card.getId());
        card.add(card);
    }
}
