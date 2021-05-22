package com.appointment.appointment.client;

import java.io.Serializable;

public class CardMapper implements Serializable {

    private Long id;
    private Long userId;
    private String cardCode;
    private String description;

    public CardMapper() {
    }

    public CardMapper(Long id, Long userId, String cardCode, String description) {
        this.id = id;
        this.userId = userId;
        this.cardCode = cardCode;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
