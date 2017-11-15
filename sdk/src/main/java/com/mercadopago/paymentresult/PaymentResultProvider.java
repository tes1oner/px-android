package com.mercadopago.paymentresult;

import com.mercadopago.R;
import com.mercadopago.model.Instructions;
import com.mercadopago.mvp.OnResourcesRetrievedCallback;
import com.mercadopago.mvp.ResourcesProvider;

public interface PaymentResultProvider extends ResourcesProvider {

    void getInstructionsAsync(Long paymentId, String paymentTypeId, final OnResourcesRetrievedCallback<Instructions> onResourcesRetrievedCallback);

    String getStandardErrorMessage();

    String getApprovedTitle();

    String getPendingTitle();

    String getRejectedOtherReasonTitle(final String paymentMethodName);

    String getRejectedInsufficientAmountTitle(final String paymentMethodName);

    String getRejectedDuplicatedPaymentTitle(final String paymentMethodName);

    String getRejectedCardDisabledTitle(final String paymentMethodName);

    String getRejectedBadFilledCardTitle(final String paymentMethodName);

    String getRejectedHighRiskTitle();

    String getRejectedMaxAttemptsTitle();

    String getRejectedInsufficientDataTitle();

    String getRejectedBadFilledOther();

    String getRejectedCallForAuthorizeTitle();

    String getEmptyText();

    String getPendingLabel();

    String getRejectionLabel();

    String getExitButtonDefaultText();

    String getChengePaymentMethodLabel();

    String getRecoverPayment();
}
