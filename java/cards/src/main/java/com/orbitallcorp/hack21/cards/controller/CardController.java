package com.orbitallcorp.hack21.cards.controller;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        Card savedCard = cardService.save((card));

        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        List<Card> cards = cardService.findAll();
        return ResponseEntity.ok(cards);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        List<Card> cards = cardService.findAll();
        return ResponseEntity.ok(cards.get(0));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@RequestBody Card card, @PathVariable Long id) {
        cardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Card card) {
        cardService.replace(card);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
