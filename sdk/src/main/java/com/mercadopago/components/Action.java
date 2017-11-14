package com.mercadopago.components;

public class Action {

    public static final int TYPE_CONTINUE = 100;

    public final int type;

    public Action(final int type) {
        this.type = type;
    }

    //Factory methods

    public static Action continueAction() {
        return new Action(TYPE_CONTINUE);
    }
}
