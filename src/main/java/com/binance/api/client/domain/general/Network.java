package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {
    private String addressRegex;
    private String coin;
    private String depositDesc;
    private Boolean depositEnable;
    private Boolean isDefault;
    private String memoRegex;
    private Integer minConfirm;
    private String name;
    private String network;
    private Boolean resetAddressStatus;
    private String specialTips;
    private Integer unLockConfirm;
    private String withdrawDesc;
    private Boolean withdrawEnable;
    private BigDecimal withdrawFee;
    private BigDecimal withdrawMin;

    @Override
    public String toString() {
        return "Network{" +
                "addressRegex='" + addressRegex + '\'' +
                ", coin='" + coin + '\'' +
                ", depositDesc='" + depositDesc + '\'' +
                ", depositEnable=" + depositEnable +
                ", isDefault=" + isDefault +
                ", memoRegex='" + memoRegex + '\'' +
                ", minConfirm=" + minConfirm +
                ", name='" + name + '\'' +
                ", network='" + network + '\'' +
                ", resetAddressStatus=" + resetAddressStatus +
                ", specialTips='" + specialTips + '\'' +
                ", unLockConfirm=" + unLockConfirm +
                ", withdrawDesc='" + withdrawDesc + '\'' +
                ", withdrawEnable=" + withdrawEnable +
                ", withdrawFee=" + withdrawFee +
                ", withdrawMin=" + withdrawMin +
                '}';
    }

    public String getAddressRegex() {
        return addressRegex;
    }

    public void setAddressRegex(String addressRegex) {
        this.addressRegex = addressRegex;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getDepositDesc() {
        return depositDesc;
    }

    public void setDepositDesc(String depositDesc) {
        this.depositDesc = depositDesc;
    }

    public String getMemoRegex() {
        return memoRegex;
    }

    public void setMemoRegex(String memoRegex) {
        this.memoRegex = memoRegex;
    }

    public Integer getMinConfirm() {
        return minConfirm;
    }

    public void setMinConfirm(Integer minConfirm) {
        this.minConfirm = minConfirm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getSpecialTips() {
        return specialTips;
    }

    public void setSpecialTips(String specialTips) {
        this.specialTips = specialTips;
    }

    public Integer getUnLockConfirm() {
        return unLockConfirm;
    }

    public void setUnLockConfirm(Integer unLockConfirm) {
        this.unLockConfirm = unLockConfirm;
    }

    public String getWithdrawDesc() {
        return withdrawDesc;
    }

    public void setWithdrawDesc(String withdrawDesc) {
        this.withdrawDesc = withdrawDesc;
    }

    public Boolean getDepositEnable() {
        return depositEnable;
    }

    public void setDepositEnable(Boolean depositEnable) {
        this.depositEnable = depositEnable;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getResetAddressStatus() {
        return resetAddressStatus;
    }

    public void setResetAddressStatus(Boolean resetAddressStatus) {
        this.resetAddressStatus = resetAddressStatus;
    }

    public Boolean getWithdrawEnable() {
        return withdrawEnable;
    }

    public void setWithdrawEnable(Boolean withdrawEnable) {
        this.withdrawEnable = withdrawEnable;
    }

    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public BigDecimal getWithdrawMin() {
        return withdrawMin;
    }

    public void setWithdrawMin(BigDecimal withdrawMin) {
        this.withdrawMin = withdrawMin;
    }
}
