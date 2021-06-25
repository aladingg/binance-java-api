package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountApiKey {
    @JsonProperty("subaccountId")
    private String subAccountId;
    private String apiKey;
    private String secretKey;
    private Boolean canTrade;
    private Boolean marginTrade;
    private Boolean futuresTrade;

    @Override
    public String toString() {
        return "SubAccountApiKey{" +
                "subAccountId='" + subAccountId + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", canTrade=" + canTrade +
                ", marginTrade=" + marginTrade +
                ", futuresTrade=" + futuresTrade +
                '}';
    }

    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Boolean getCanTrade() {
        return canTrade;
    }

    public void setCanTrade(Boolean canTrade) {
        this.canTrade = canTrade;
    }

    public Boolean getMarginTrade() {
        return marginTrade;
    }

    public void setMarginTrade(Boolean marginTrade) {
        this.marginTrade = marginTrade;
    }

    public Boolean getFuturesTrade() {
        return futuresTrade;
    }

    public void setFuturesTrade(Boolean futuresTrade) {
        this.futuresTrade = futuresTrade;
    }
}
