package com.billGenerate.BillGenerate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioConfig {

    @Value("${twilio.account_sid}")
    private String accountsid;

    @Value("${twilio.auth_token}")
    private String authtoken;

    @Value("${twilio.phone_number}")
    private String Phonenum;

    public String getAccountsid() {
        return accountsid;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public String getPhonenum() {
        return Phonenum;
    }
}
