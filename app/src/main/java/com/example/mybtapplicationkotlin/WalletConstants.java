package com.example.mybtapplicationkotlin;

import android.accounts.Account;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class WalletConstants {
    public static final int CARD_NETWORK_AMEX = 1;
    public static final int CARD_NETWORK_DISCOVER = 2;
    public static final int CARD_NETWORK_JCB = 3;
    public static final int CARD_NETWORK_MASTERCARD = 4;
    public static final int CARD_NETWORK_VISA = 5;
    public static final int CARD_NETWORK_INTERAC = 6;
    public static final int CARD_NETWORK_OTHER = 1000;
    public static final int BILLING_ADDRESS_FORMAT_MIN = 0;
    public static final int BILLING_ADDRESS_FORMAT_FULL = 1;
    public static final int PAYMENT_METHOD_UNKNOWN = 0;
    public static final int PAYMENT_METHOD_CARD = 1;
    public static final int PAYMENT_METHOD_TOKENIZED_CARD = 2;
    public static final int CARD_CLASS_UNKNOWN = 0;
    public static final int CARD_CLASS_CREDIT = 1;
    public static final int CARD_CLASS_DEBIT = 2;
    public static final int CARD_CLASS_PREPAID = 3;
    public static final int PAYMENT_METHOD_TOKENIZATION_TYPE_PAYMENT_GATEWAY = 1;
    /** @deprecated */
    @Deprecated
    public static final int PAYMENT_METHOD_TOKENIZATION_TYPE_NETWORK_TOKEN = 2;
    public static final int PAYMENT_METHOD_TOKENIZATION_TYPE_DIRECT = 3;
    public static final int TOTAL_PRICE_STATUS_NOT_CURRENTLY_KNOWN = 1;
    public static final int TOTAL_PRICE_STATUS_ESTIMATED = 2;
    public static final int TOTAL_PRICE_STATUS_FINAL = 3;
    public static final int RESULT_ERROR = 1;
    public static final String EXTRA_IS_USER_PREAUTHORIZED = "com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED";
    public static final String EXTRA_MASKED_WALLET = "com.google.android.gms.wallet.EXTRA_MASKED_WALLET";
    public static final String EXTRA_FULL_WALLET = "com.google.android.gms.wallet.EXTRA_FULL_WALLET";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.wallet.EXTRA_ERROR_CODE";
    public static final String EXTRA_MASKED_WALLET_REQUEST = "com.google.android.gms.wallet.EXTRA_MASKED_WALLET_REQUEST";
    public static final String EXTRA_IS_READY_TO_PAY = "com.google.android.gms.wallet.EXTRA_IS_READY_TO_PAY";
    public static final int ERROR_CODE_INTERNAL_ERROR = 8;
    public static final int ERROR_CODE_DEVELOPER_ERROR = 10;
    public static final int ERROR_CODE_SERVICE_UNAVAILABLE = 402;
    public static final int ERROR_CODE_INVALID_PARAMETERS = 404;
    public static final int ERROR_CODE_MERCHANT_ACCOUNT_ERROR = 405;
    /** @deprecated */
    @Deprecated
    public static final int ERROR_CODE_SPENDING_LIMIT_EXCEEDED = 406;
    public static final int ERROR_CODE_BUYER_ACCOUNT_ERROR = 409;
    public static final int ERROR_CODE_INVALID_TRANSACTION = 410;
    public static final int ERROR_CODE_AUTHENTICATION_FAILURE = 411;
    public static final int ERROR_CODE_UNSUPPORTED_API_VERSION = 412;
    public static final int ERROR_CODE_UNKNOWN = 413;
    public static final int ENVIRONMENT_PRODUCTION = 1;
    public static final int ENVIRONMENT_TEST = 3;
    /** @deprecated */
    @Deprecated
    public static final int ENVIRONMENT_SANDBOX = 0;
    /** @deprecated */
    @Deprecated
    public static final int ENVIRONMENT_STRICT_SANDBOX = 2;
    /** @deprecated */
    @Deprecated
    public static final int THEME_HOLO_DARK = 0;
    /** @deprecated */
    @Deprecated
    public static final int THEME_HOLO_LIGHT = 1;
    public static final int THEME_DARK = 0;
    public static final int THEME_LIGHT = 1;
    /** @deprecated */
    @Deprecated
    public static final String ACTION_ENABLE_WALLET_OPTIMIZATION = "com.google.android.gms.wallet.ENABLE_WALLET_OPTIMIZATION";
    public static final String METADATA_TAG_WALLET_API_ENABLED = "com.google.android.gms.wallet.api.enabled";
    private static final Account zzeu = new Account("ACCOUNT_NO_WALLET", "com.google");

    private WalletConstants() {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TotalPriceStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PaymentMethodTokenizationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CardClass {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PaymentMethod {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BillingAddressFormat {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CardNetwork {
        /** @deprecated */
        @Deprecated
        int AMEX = 1;
        /** @deprecated */
        @Deprecated
        int DISCOVER = 2;
        /** @deprecated */
        @Deprecated
        int JCB = 3;
        /** @deprecated */
        @Deprecated
        int MASTERCARD = 4;
        /** @deprecated */
        @Deprecated
        int VISA = 5;
        /** @deprecated */
        @Deprecated
        int INTERAC = 6;
        /** @deprecated */
        @Deprecated
        int OTHER = 1000;
    }
}
