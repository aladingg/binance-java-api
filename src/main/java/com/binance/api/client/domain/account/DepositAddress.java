package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A deposit address for a given asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositAddress {

    private String address;
    private String tag;
    private String coin;
    private String url;

    @Override
    public String toString() {
        return "DepositAddress{" +
                "address='" + address + '\'' +
                ", tag='" + tag + '\'' +
                ", coin='" + coin + '\'' +
                ", url='" + url + '\'' +
                '}';
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

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}