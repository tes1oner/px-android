package com.mercadopago.core;

import com.google.gson.reflect.TypeToken;

import com.mercadopago.constants.ProcessingModes;
import com.mercadopago.model.ApiException;
import com.mercadopago.model.BankDeal;
import com.mercadopago.model.Campaign;
import com.mercadopago.model.Discount;
import com.mercadopago.model.IdentificationType;
import com.mercadopago.model.Installment;
import com.mercadopago.model.Issuer;
import com.mercadopago.model.Payment;
import com.mercadopago.model.PaymentBody;
import com.mercadopago.model.PaymentMethod;
import com.mercadopago.model.SecurityCodeIntent;
import com.mercadopago.model.Token;
import com.mercadopago.preferences.ServicePreference;
import com.mercadopago.util.JsonUtil;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

class ModelsAdapter{

    static Map<String, Object> adapt(PaymentBody paymentBody) {
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> payload = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(paymentBody), type);
        payload.put("issuer_id", paymentBody.getIssuerId());
        payload.put("installments", paymentBody.getInstallments());
        payload.put("campaign_id", paymentBody.getCampaignId());
        return payload;
    }

    static com.mercadopago.lite.preferences.ServicePreference adapt(ServicePreference servicePreference) {
        if (servicePreference == null) {
            return null;
        } else {
            com.mercadopago.lite.preferences.ServicePreference.Builder builder = new com.mercadopago.lite.preferences.ServicePreference.Builder();
            builder.setDefaultBaseURL(servicePreference.getDefaultBaseURL());
            builder.setGatewayURL(servicePreference.getGatewayBaseURL());
            if (servicePreference.hasGetCustomerURL()) {
                builder.setGetCustomerURL(servicePreference.getGetCustomerURL(), servicePreference.getGetCustomerURI(), servicePreference.getGetCustomerAdditionalInfo());
            }

            if (servicePreference.hasGetDiscountURL()) {
                builder.setDiscountURL(servicePreference.getGetMerchantDiscountBaseURL(), servicePreference.getGetMerchantDiscountURI(), servicePreference.getGetDiscountAdditionalInfo());
            }

            if (servicePreference.hasCreateCheckoutPrefURL()) {
                builder.setCreateCheckoutPreferenceURL(servicePreference.getCreateCheckoutPreferenceURL(), servicePreference.getCreateCheckoutPreferenceURI(), servicePreference.getCreateCheckoutPreferenceAdditionalInfo());
            }

            if (servicePreference.hasCreatePaymentURL()) {
                builder.setCreatePaymentURL(servicePreference.getCreatePaymentURL(), servicePreference.getCreatePaymentURI(), servicePreference.getCreatePaymentAdditionalInfo());
            }

            if (ProcessingModes.HYBRID.equals(servicePreference.getProcessingModeString())) {
                builder.setHybridAsProcessingMode();
            } else if (ProcessingModes.GATEWAY.equals(servicePreference.getProcessingModeString())) {
                builder.setGatewayAsProcessingMode();
            } else {
                builder.setAggregatorAsProcessingMode();
            }

            return builder.build();
        }
    }

    static Payment adapt(com.mercadopago.lite.model.Payment payment) {
        return JsonUtil.getInstance().fromJson(JsonUtil.getInstance().toJson(payment), Payment.class);
    }

    static ApiException adapt(com.mercadopago.lite.model.ApiException apiException) {
        return JsonUtil.getInstance().fromJson(JsonUtil.getInstance().toJson(apiException), ApiException.class);
    }



    static List<PaymentMethod> adaptPaymentMethods(List<com.mercadopago.lite.model.PaymentMethod> list){
        List<PaymentMethod> adaptedList;
        try {
            Type listType = new TypeToken<List<PaymentMethod>>() {
            }.getType();
            adaptedList = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(list), listType);
        } catch (Exception ex) {
            adaptedList = null;
        }

        return adaptedList;
    }

    static List<Issuer> adaptIssuers(List<com.mercadopago.lite.model.Issuer> list){
        List<Issuer> adaptedList;
        try {
            Type listType = new TypeToken<List<Issuer>>() {
            }.getType();
            adaptedList = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(list), listType);
        } catch (Exception ex) {
            adaptedList = null;
        }

        return adaptedList;
    }

    static List<BankDeal> adaptBankDeals(List<com.mercadopago.lite.model.BankDeal> list){
        List<BankDeal> adaptedList;
        try {
            Type listType = new TypeToken<List<BankDeal>>() {
            }.getType();
            adaptedList = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(list), listType);
        } catch (Exception ex) {
            adaptedList = null;
        }

        return adaptedList;
    }

    static List<Campaign> adaptCampaigns(List<com.mercadopago.lite.model.Campaign> list){
        List<Campaign> adaptedList;
        try {
            Type listType = new TypeToken<List<Campaign>>() {
            }.getType();
            adaptedList = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(list), listType);
        } catch (Exception ex) {
            adaptedList = null;
        }

        return adaptedList;
    }

    static Discount adapt(com.mercadopago.lite.model.Discount discount){
        return JsonUtil.getInstance().fromJson(JsonUtil.getInstance().toJson(discount), Discount.class);
    }

    static List<Installment> adaptInstallments(List<com.mercadopago.lite.model.Installment> list){
        List<Installment> adaptedList;
        try {
            Type listType = new TypeToken<List<Installment>>() {
            }.getType();
            adaptedList = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(list), listType);
        } catch (Exception ex) {
            adaptedList = null;
        }

        return adaptedList;
    }

    static List<IdentificationType> adaptIdentificationTypes(List<com.mercadopago.lite.model.IdentificationType> list){
        List<IdentificationType> adaptedList;
        try {
            Type listType = new TypeToken<List<IdentificationType>>() {
            }.getType();
            adaptedList = JsonUtil.getInstance().getGson().fromJson(JsonUtil.getInstance().toJson(list), listType);
        } catch (Exception ex) {
            adaptedList = null;
        }

        return adaptedList;
    }

    static Token adapt(com.mercadopago.lite.model.Token token){
        return JsonUtil.getInstance().fromJson(JsonUtil.getInstance().toJson(token), Token.class);
    }


    public static com.mercadopago.lite.model.requests.SecurityCodeIntent adapt(SecurityCodeIntent securityCodeIntent) {
        return JsonUtil.getInstance().fromJson(JsonUtil.getInstance().toJson(securityCodeIntent), com.mercadopago.lite.model.requests.SecurityCodeIntent.class);
    }
}