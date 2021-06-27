package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountTransferResult {
    private String txnId;
    private String clientTranId;

    @Override
    public String toString() {
        return "SubAccountTransferResult{" +
                "txnId='" + txnId + '\'' +
                ", clientTranId='" + clientTranId + '\'' +
                '}';
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getClientTranId() {
        return clientTranId;
    }

    public void setClientTranId(String clientTranId) {
        this.clientTranId = clientTranId;
    }
}
