package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DepositStatus {
    PENDING(0),
    SUCCESS(1),
    CREDITED_BUT_CANNOT_WITHDRAW(6);

    private final int status;

    @JsonValue
    public int getStatus() {
        return status;
    }

    @JsonCreator
    public DepositStatus from(int status) {
        if (PENDING.getStatus() == status) {
            return PENDING;
        } else if (SUCCESS.getStatus() == status) {
            return SUCCESS;
        } else if (CREDITED_BUT_CANNOT_WITHDRAW.getStatus() == status) {
            return CREDITED_BUT_CANNOT_WITHDRAW;
        } else {
            return null;
        }
    }

    DepositStatus(int status) {
        this.status = status;
    }
}
