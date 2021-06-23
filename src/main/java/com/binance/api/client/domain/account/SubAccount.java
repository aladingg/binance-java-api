package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccount {
    private Long subaccountId;
    private String email;
    private String tag;
    private Long makerCommission;
    private Long takerCommission;
    private Long marginMakerCommission;
    private Long marginTakerCommission;
    private Date createTime;

    public Long getMakerCommission() {
        return makerCommission;
    }

    public void setMakerCommission(Long makerCommission) {
        this.makerCommission = makerCommission;
    }

    public Long getTakerCommission() {
        return takerCommission;
    }

    public void setTakerCommission(Long takerCommission) {
        this.takerCommission = takerCommission;
    }

    public Long getMarginMakerCommission() {
        return marginMakerCommission;
    }

    public void setMarginMakerCommission(Long marginMakerCommission) {
        this.marginMakerCommission = marginMakerCommission;
    }

    public Long getMarginTakerCommission() {
        return marginTakerCommission;
    }

    public void setMarginTakerCommission(Long marginTakerCommission) {
        this.marginTakerCommission = marginTakerCommission;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SubAccount{" +
                "subaccountId=" + subaccountId +
                ", email='" + email + '\'' +
                ", tag='" + tag + '\'' +
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
