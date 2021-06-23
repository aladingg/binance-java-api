package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubAccountDepositAddress {
    private String coin;
    private String address;
    private String tag;
    private String url;

    @Override
    public String toString() {
        return "SubAccountDepositAddress{" +
                "coin='" + coin + '\'' +
                ", address='" + address + '\'' +
                ", tag='" + tag + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
