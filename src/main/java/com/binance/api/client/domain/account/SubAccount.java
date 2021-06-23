package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccount {
    private Long subaccountId;
    private String email;
    private BigDecimal makerCommission;
    private BigDecimal takerCommission;
    private BigDecimal marginMakerCommission;
    private BigDecimal marginTakerCommission;
    private Date createTime;

    @Override
    public String toString() {
        return "SubAccount{" +
                "subaccountId=" + subaccountId +
                ", email='" + email + '\'' +
                ", makerCommission=" + makerCommission +
                ", takerCommission=" + takerCommission +
                ", marginMakerCommission=" + marginMakerCommission +
                ", marginTakerCommission=" + marginTakerCommission +
                ", createTime=" + createTime +
                '}';
    }

    public Long getSubaccountId() {
        return subaccountId;
    }

    public void setSubaccountId(Long subaccountId) {
        this.subaccountId = subaccountId;
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
