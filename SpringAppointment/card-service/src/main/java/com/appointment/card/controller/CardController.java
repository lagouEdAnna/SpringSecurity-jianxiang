package com.appointment.card.controller;

import com.appointment.card.domain.Card;
import com.appointment.card.services.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="cards")
public class CardController {

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);
    
	@Autowired
	CardService cardService;

	@RequestMapping(value = "/{cardCode}", method = RequestMethod.GET)
    public Card getDevice(@PathVariable String cardCode) {

		Card card = cardService.getDeviceByCode(cardCode);
    	return card;
    }
}
