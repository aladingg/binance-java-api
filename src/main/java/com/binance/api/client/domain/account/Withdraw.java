package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * A withdraw that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Withdraw {

    private String address;
    private String amount;
    private String applyTime;
    private String coin;
    private String id;
    private String withdrawOrderId;
    private String network;
    private Integer transferType;
    private Status status;
    private BigDecimal transactionFee;
    private String txId;

    public enum Status {
        EMAIL_SENT(0),      // 已发送确认Email
        USER_CANCEL(1),     // 已被用户取消
        CONFIRMING(2),      // 等待确认
        REJECTED(3),        // 被拒绝
        PROCESSING(4),      // 处理中
        FAILED(5),          // 提现交易失败
        SUCCESS(7);         // 提现成功

        private final int status;

        @JsonCreator
        public Status from(int status) {
            if (EMAIL_SENT.getStatus() == status) {
                return EMAIL_SENT;
            } else if (USER_CANCEL.getStatus() == status) {
                return USER_CANCEL;
            } else if (CONFIRMING.getStatus() == status) {
                return CONFIRMING;
            } else if (REJECTED.getStatus() == status) {
                return REJECTED;
            } else if (PROCESSING.getStatus() == status) {
                return PROCESSING;
            } else if (FAILED.getStatus() == status) {
                return FAILED;
            } else if (SUCCESS.getStatus() == status) {
                return SUCCESS;
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

    @Override
    public String toString() {
        return "Withdraw{" +
                "address='" + address + '\'' +
                ", amount='" + amount + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", coin='" + coin + '\'' +
                ", id='" + id + '\'' +
                ", withdrawOrderId='" + withdrawOrderId + '\'' +
                ", network='" + network + '\'' +
                ", transferType=" + transferType +
                ", status=" + status +
                ", transactionFee=" + transactionFee +
                ", txId='" + txId + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWithdrawOrderId() {
        return withdrawOrderId;
    }

    public void setWithdrawOrderId(String withdrawOrderId) {
        this.withdrawOrderId = withdrawOrderId;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
}
