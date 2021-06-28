package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

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
        INIT(1),
        PROCESS(2),
        SUCCESS(3),
        FAILURE(4);

        private final int status;

        @JsonCreator
        public Status from(int status) {
            if (INIT.getStatus() == status) {
                return INIT;
            } else if (PROCESS.getStatus() == status) {
                return PROCESS;
            } else if (SUCCESS.getStatus() == status) {
                return SUCCESS;
            } else if (FAILURE.getStatus() == status) {
                return FAILURE;
            } else {
                return null;
            }
        }

        @JsonValue
        public int getStatus() {
            return status;
        }

        Status(int status) {
            this.status = status;
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
