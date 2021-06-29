package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountDeposit {
    private String subAccountId;
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

    @Override
    public String toString() {
        return "SubAccountDeposit{" +
                "subAccountId='" + subAccountId + '\'' +
                ", address='" + address + '\'' +
                ", addressTag='" + addressTag + '\'' +
                ", amount=" + amount +
                ", coin='" + coin + '\'' +
                ", insertTime=" + insertTime +
                ", network='" + network + '\'' +
                ", status=" + status +
                ", txId='" + txId + '\'' +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", confirmTimes='" + confirmTimes + '\'' +
                '}';
    }

    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressTag() {
        return addressTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getConfirmTimes() {
        return confirmTimes;
    }

    public void setConfirmTimes(String confirmTimes) {
        this.confirmTimes = confirmTimes;
    }
}
