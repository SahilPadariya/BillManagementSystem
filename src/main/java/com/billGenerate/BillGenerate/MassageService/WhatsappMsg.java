package com.billGenerate.BillGenerate.MassageService;
import com.billGenerate.BillGenerate.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsappMsg {
    @Autowired
    TwilioConfig twilioConfig;

    public WhatsappMsg(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(twilioConfig.getAccountsid(), twilioConfig.getAuthtoken());
    }

    public void OutOfStoc(String ReceiverNum){
        Message.creator(
                new PhoneNumber("whatsapp:"+ReceiverNum), // TO: Receiver+
                new PhoneNumber("whatsapp:"+twilioConfig.getPhonenum()),                 // FROM: Twilio Sandbox number
                "We not Enough Stock for this product" // ✅ message string + variable
        ).create();
    }
    public void SuccessFullyBuy(String ReceiverNum){
        Message.creator(
                new PhoneNumber("whatsapp:"+ReceiverNum), // TO: Receiver+
                new PhoneNumber("whatsapp:"+twilioConfig.getPhonenum()),                 // FROM: Twilio Sandbox number
                "You have successfully bought:"
        ).create();
    }
    public void UnsuccessBUy(String ReceiverNum){
        Message.creator(
                new PhoneNumber("whatsapp:"+ReceiverNum), // TO: Receiver+
                new PhoneNumber("whatsapp:"+twilioConfig.getPhonenum()),                 // FROM: Twilio Sandbox number
                "payment fail" // ✅ message string + variable
        ).create();
    }
    public void UpdateStock(String ReceiverNum){
        Message.creator(
               new PhoneNumber("whatsapp:"+ReceiverNum),
               new PhoneNumber("whatsapp:"+twilioConfig.getPhonenum()),
               "Please update stock"
        ).create();
    }
}
