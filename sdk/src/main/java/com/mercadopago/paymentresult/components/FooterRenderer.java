package com.mercadopago.paymentresult.components;

import android.view.LayoutInflater;
import android.view.View;

import com.mercadopago.R;
import com.mercadopago.components.Renderer;

public class FooterRenderer extends Renderer<Footer> {
    @Override
    public View render() {
        final View view = LayoutInflater.from(context)
                .inflate(R.layout.mpsdk_payment_result_footer, null);
        return view;
    }
}