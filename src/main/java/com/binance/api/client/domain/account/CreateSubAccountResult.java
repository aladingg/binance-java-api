package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSubAccountResult {
    @JsonProperty("subaccountId")
    private String subAccountId;
    private String email;
    private String tab;

    @Override
    public String toString() {
        return "CreateSubAccountResult{" +
                "subAccountId='" + subAccountId + '\'' +
                ", email='" + email + '\'' +
                ", tab='" + tab + '\'' +
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

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }
}
