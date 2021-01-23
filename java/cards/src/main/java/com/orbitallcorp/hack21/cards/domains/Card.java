package com.orbitallcorp.hack21.cards.domains;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Data
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private String embossName;
    private String customerName;
    private String documentNumber;
    private String motherName;
    private String address;
    private String city;

    public void add(Card card) {
    }
}
