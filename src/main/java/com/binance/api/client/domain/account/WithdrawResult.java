package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A withdraw result that was done to a Binance account.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawResult {

    private String id;

    @Override
    public String toString() {
        return "WithdrawResult{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
