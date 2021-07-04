package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {
    private String coin;
    private Boolean depositAllEnable;
    private BigDecimal free;
    private BigDecimal freeze;
    private BigDecimal ipoable;
    private BigDecimal ipoing;
    private Boolean isLegalMoney;
    private BigDecimal locked;
    private String name;
    List<Network> networkList;
    private BigDecimal storage;
    private Boolean trading;
    private Boolean withdrawAllEnable;
    private BigDecimal withdrawing;

    @Override
    public String toString() {
        return "Coin{" +
                "coin='" + coin + '\'' +
                ", depositAllEnable=" + depositAllEnable +
                ", free=" + free +
                ", freeze=" + freeze +
                ", ipoable=" + ipoable +
                ", ipoing=" + ipoing +
                ", isLegalMoney=" + isLegalMoney +
                ", locked=" + locked +
                ", name='" + name + '\'' +
                ", networkList=" + networkList +
                ", storage=" + storage +
                ", trading=" + trading +
                ", withdrawAllEnable=" + withdrawAllEnable +
                ", withdrawing=" + withdrawing +
                '}';
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Boolean getDepositAllEnable() {
        return depositAllEnable;
    }

    public void setDepositAllEnable(Boolean depositAllEnable) {
        this.depositAllEnable = depositAllEnable;
    }

    public Boolean getLegalMoney() {
        return isLegalMoney;
    }

    public void setLegalMoney(Boolean legalMoney) {
        isLegalMoney = legalMoney;
    }

    public void setTrading(Boolean trading) {
        this.trading = trading;
    }

    public void setWithdrawAllEnable(Boolean withdrawAllEnable) {
        this.withdrawAllEnable = withdrawAllEnable;
    }

    public BigDecimal getFree() {
        return free;
    }

    public void setFree(BigDecimal free) {
        this.free = free;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    public BigDecimal getIpoable() {
        return ipoable;
    }

    public void setIpoable(BigDecimal ipoable) {
        this.ipoable = ipoable;
    }

    public BigDecimal getIpoing() {
        return ipoing;
    }

    public void setIpoing(BigDecimal ipoing) {
        this.ipoing = ipoing;
    }

    public BigDecimal getLocked() {
        return locked;
    }

    public void setLocked(BigDecimal locked) {
        this.locked = locked;
    }

    public String getName() {
        return name;
    }

    public Boolean getTrading() {
        return trading;
    }

    public Boolean getWithdrawAllEnable() {
        return withdrawAllEnable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(List<Network> networkList) {
        this.networkList = networkList;
    }

    public BigDecimal getStorage() {
        return storage;
    }

    public void setStorage(BigDecimal storage) {
        this.storage = storage;
    }

    public BigDecimal getWithdrawing() {
        return withdrawing;
    }

    public void setWithdrawing(BigDecimal withdrawing) {
        this.withdrawing = withdrawing;
    }
}
