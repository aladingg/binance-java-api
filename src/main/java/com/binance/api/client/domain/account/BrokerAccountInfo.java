package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrokerAccountInfo {
    private BigDecimal maxMakerCommission;
    private BigDecimal minMakerCommission;
    private BigDecimal maxTakerCommission;
    private BigDecimal minTakerCommission;
    private Long subAccountQty;
    private Long maxSubAccountQty;

    @Override
    public String toString() {
        return "BrokerAccountInfo{" +
                "maxMakerCommission=" + maxMakerCommission +
                ", minMakerCommission=" + minMakerCommission +
                ", maxTakerCommission=" + maxTakerCommission +
                ", minTakerCommission=" + minTakerCommission +
                ", subAccountQty=" + subAccountQty +
                ", maxSubAccountQty=" + maxSubAccountQty +
                '}';
    }

    public BigDecimal getMaxMakerCommission() {
        return maxMakerCommission;
    }

    public void setMaxMakerCommission(BigDecimal maxMakerCommission) {
        this.maxMakerCommission = maxMakerCommission;
    }

    public BigDecimal getMinMakerCommission() {
        return minMakerCommission;
    }

    public void setMinMakerCommission(BigDecimal minMakerCommission) {
        this.minMakerCommission = minMakerCommission;
    }

    public BigDecimal getMaxTakerCommission() {
        return maxTakerCommission;
    }

    public void setMaxTakerCommission(BigDecimal maxTakerCommission) {
        this.maxTakerCommission = maxTakerCommission;
    }

    public BigDecimal getMinTakerCommission() {
        return minTakerCommission;
    }

    public void setMinTakerCommission(BigDecimal minTakerCommission) {
        this.minTakerCommission = minTakerCommission;
    }

    public Long getSubAccountQty() {
        return subAccountQty;
    }

    public void setSubAccountQty(Long subAccountQty) {
        this.subAccountQty = subAccountQty;
    }

    public Long getMaxSubAccountQty() {
        return maxSubAccountQty;
    }

    public void setMaxSubAccountQty(Long maxSubAccountQty) {
        this.maxSubAccountQty = maxSubAccountQty;
    }
}
