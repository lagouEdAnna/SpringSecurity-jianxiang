package com.appointment.appointment.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public CardMapper getCardByCardCode(String cardCode) {
        ResponseEntity<CardMapper> result =
                restTemplate.exchange("http://cardservice/cards/{cardCode}", HttpMethod.GET, null,
                        CardMapper.class, cardCode);

        return result.getBody();
    }
}
