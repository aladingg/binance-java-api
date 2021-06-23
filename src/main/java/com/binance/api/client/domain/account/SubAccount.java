package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccount {
    @JsonProperty("subaccountId")
    private String subAccountId;
    private String email;
    private BigDecimal makerCommission;
    private BigDecimal takerCommission;
    private BigDecimal marginMakerCommission;
    private BigDecimal marginTakerCommission;
    private Date createTime;

    @Override
    public String toString() {
        return "SubAccount{" +
                "subAccountId='" + subAccountId + '\'' +
                ", email='" + email + '\'' +
                ", makerCommission=" + makerCommission +
                ", takerCommission=" + takerCommission +
                ", marginMakerCommission=" + marginMakerCommission +
                ", marginTakerCommission=" + marginTakerCommission +
                ", createTime=" + createTime +
                '}';
    }

    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getMakerCommission() {
        return makerCommission;
    }

    public void setMakerCommission(BigDecimal makerCommission) {
        this.makerCommission = makerCommission;
    }

    public BigDecimal getTakerCommission() {
        return takerCommission;
    }

    public void setTakerCommission(BigDecimal takerCommission) {
        this.takerCommission = takerCommission;
    }

    public BigDecimal getMarginMakerCommission() {
        return marginMakerCommission;
    }

    public void setMarginMakerCommission(BigDecimal marginMakerCommission) {
        this.marginMakerCommission = marginMakerCommission;
    }

    public BigDecimal getMarginTakerCommission() {
        return marginTakerCommission;
    }

    public void setMarginTakerCommission(BigDecimal marginTakerCommission) {
        this.marginTakerCommission = marginTakerCommission;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
