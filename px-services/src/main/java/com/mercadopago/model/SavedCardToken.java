package com.mercadopago.model;

/**
 * Created by mromar on 10/24/17.
 */

public class SavedCardToken {

    private String cardId;
    private String securityCode;
    private Device device;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
