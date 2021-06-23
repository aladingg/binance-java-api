package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrokerAccountInfo {
    private Long maxMakerCommission;
    private Long minMakerCommission;
    private Long maxTakerCommission;
    private Long minTakerCommission;
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

    public Long getMaxMakerCommission() {
        return maxMakerCommission;
    }

    public void setMaxMakerCommission(Long maxMakerCommission) {
        this.maxMakerCommission = maxMakerCommission;
    }

    public Long getMinMakerCommission() {
        return minMakerCommission;
    }

    public void setMinMakerCommission(Long minMakerCommission) {
        this.minMakerCommission = minMakerCommission;
    }

    public Long getMaxTakerCommission() {
        return maxTakerCommission;
    }

    public void setMaxTakerCommission(Long maxTakerCommission) {
        this.maxTakerCommission = maxTakerCommission;
    }

    public Long getMinTakerCommission() {
        return minTakerCommission;
    }

    public void setMinTakerCommission(Long minTakerCommission) {
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
