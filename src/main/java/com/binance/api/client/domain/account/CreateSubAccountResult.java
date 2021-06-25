package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSubAccountResult {
    @JsonProperty("subaccountId")
    private String subAccountId;
    private String email;
    private String tag;

    @Override
    public String toString() {
        return "CreateSubAccountResult{" +
                "subAccountId='" + subAccountId + '\'' +
                ", email='" + email + '\'' +
                ", tab='" + tag + '\'' +
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
