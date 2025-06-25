package com.billGenerate.BillGenerate.MassageService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class WhatsappMsg {

    public void UpdateMassage(){
        Message.creator(
                new PhoneNumber("whatsapp:+917990747312"), // TO: Receiver+
                new PhoneNumber("whatsapp:+14155238886"),// FROM: Twilio Sandbox number
                "please Update Stock"
        ).create();
    }
    public void OutOfStoc(){
        Message.creator(
                new PhoneNumber("whatsapp:+917990747312"), // TO: Receiver+
                new PhoneNumber("whatsapp:+14155238886"),                 // FROM: Twilio Sandbox number
                "We not Enough Stock for this product" // ✅ message string + variable
        ).create();
    }
    public void SuccessFullyBuy(){
        Message.creator(
                new PhoneNumber("whatsapp:+917990747312"), // TO: Receiver+
                new PhoneNumber("whatsapp:+14155238886"),                 // FROM: Twilio Sandbox number
                "You have successfully bought:"
        ).create();
    }
    public void UnsuccessBUy(){
        Message.creator(
                new PhoneNumber("whatsapp:+917990747312"), // TO: Receiver+
                new PhoneNumber("whatsapp:+14155238886"),                 // FROM: Twilio Sandbox number
                "payment fail" // ✅ message string + variable
        ).create();
    }
}
