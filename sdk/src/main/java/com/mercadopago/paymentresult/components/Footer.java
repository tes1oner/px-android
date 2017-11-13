package com.mercadopago.paymentresult.components;

import android.support.annotation.NonNull;

import com.mercadopago.components.Action;
import com.mercadopago.components.ActionDispatcher;
import com.mercadopago.components.Component;

/**
 * Created by vaserber on 10/20/17.
 */
public class Footer extends Component<Footer.Props> {

    public Footer(@NonNull final Props props,
                  @NonNull final ActionDispatcher dispatcher) {
        super(props, dispatcher);
    }

    public static class Props {
        public final FooterAction buttonAction;
        public final FooterAction linkAction;
        public final String termsAndConditionsUrl;

        public Props(@NonNull final FooterAction buttonAction,
                     @NonNull final FooterAction linkAction,
                     @NonNull final String termsAndConditionsUrl) {
            this.buttonAction = buttonAction;
            this.linkAction = linkAction;
            this.termsAndConditionsUrl = termsAndConditionsUrl;
        }
    }

    public static class FooterAction {
        public final String label;
        public final Action action;

        public FooterAction(String label, Action action) {
            this.label = label;
            this.action = action;
        }
    }
}