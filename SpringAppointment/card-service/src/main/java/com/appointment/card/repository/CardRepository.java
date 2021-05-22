package com.appointment.card.repository;

import com.appointment.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

	Card findCardByCardCode(String cardCode);
}
