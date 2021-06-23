package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountDeposit {
    private Long subaccountId;
    private String address;
    private String addressTag;
    private BigDecimal amount;
    private String coin;
    private Date insertTime;
    private String network;
    private Status status;
    private String txId;
    private String sourceAddress;
    private String confirmTimes;

    public enum Status {
        PENDING(0),
        SUCCESS(1),
        CREDITED_BUT_CANNOT_WITHDRAW(6);

        private final int status;

        @JsonValue
        public int getStatus() {
            return status;
        }

        @JsonCreator
        public Status from(int status) {
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

        Status(int status) {
            this.status = status;
        }
    }

}
