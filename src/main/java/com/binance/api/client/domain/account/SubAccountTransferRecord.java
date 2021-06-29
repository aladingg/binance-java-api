package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountTransferRecord {
    private String fromId;
    private String toId;
    private String asset;
    private BigDecimal qty;
    private Date time;
    private String txnId;
    private String clientTranId;
    private Status status;

    public enum Status {
        INIT("INIT"),
        PROCESS("PROCESS"),
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE");

        private final String status;

        @JsonCreator
        public Status from(String status) {
            if (INIT.getStatus().equals(status)) {
                return INIT;
            } else if (PROCESS.getStatus().equals(status)) {
                return PROCESS;
            } else if (SUCCESS.getStatus().equals(status)) {
                return SUCCESS;
            } else if (FAILURE.getStatus().equals(status)) {
                return FAILURE;
            } else {
                return null;
            }
        }

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubAccountTransferRecord{" +
                "fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", asset='" + asset + '\'' +
                ", qty=" + qty +
                ", time=" + time +
                ", txnId='" + txnId + '\'' +
                ", clientTranId='" + clientTranId + '\'' +
                ", status=" + status +
                '}';
    }

}
