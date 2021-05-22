package com.appointment.card.services;

import com.appointment.card.domain.Card;
import com.appointment.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;
	
	public Card getDeviceByCode(String cardCode) {
		
		return cardRepository.findCardByCardCode(cardCode);
	}
}

