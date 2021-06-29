package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransferType {
    EXTERNAL(0),        // 站外
    INTERNAL(1);        // 站内

    private final int type;

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public TransferType from(int type) {
        if (EXTERNAL.getType() == type) {
            return EXTERNAL;
        } else {
            return INTERNAL;
        }
    }

    TransferType(int type) {
        this.type = type;
    }
}
