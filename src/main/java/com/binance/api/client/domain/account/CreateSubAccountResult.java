package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSubAccountResult {
    private Long subaccountId;
    private String email;
    private String tab;

    @Override
    public String toString() {
        return "SubAccount{" +
                "subaccountId=" + subaccountId +
                ", email='" + email + '\'' +
                ", tab='" + tab + '\'' +
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

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }
}
