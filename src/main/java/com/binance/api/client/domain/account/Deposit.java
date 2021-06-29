package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * A deposit that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deposit {
    private BigDecimal amount;
    private String coin;
    private String network;
    private DepositStatus status;
    private String address;
    private String addressTag;
    private String txId;
    private Date insertTime;
    private TransferType transferType;
    private String confirmTimes;

    @Override
    public String toString() {
        return "Deposit{" +
                "amount=" + amount +
                ", coin='" + coin + '\'' +
                ", network='" + network + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", addressTag='" + addressTag + '\'' +
                ", txId='" + txId + '\'' +
                ", insertTime=" + insertTime +
                ", transferType=" + transferType +
                ", confirmTimes='" + confirmTimes + '\'' +
                '}';
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public DepositStatus getStatus() {
        return status;
    }

    public void setStatus(DepositStatus status) {
        this.status = status;
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

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public String getConfirmTimes() {
        return confirmTimes;
    }

    public void setConfirmTimes(String confirmTimes) {
        this.confirmTimes = confirmTimes;
    }
}

