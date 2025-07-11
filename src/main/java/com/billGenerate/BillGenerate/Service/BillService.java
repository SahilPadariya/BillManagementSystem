package com.billGenerate.BillGenerate.Service;

import com.billGenerate.BillGenerate.MassageService.WhatsappMsg;
import com.billGenerate.BillGenerate.TwilioConfig;
import com.billGenerate.BillGenerate.model.*;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.billGenerate.BillGenerate.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {
    @Autowired
    ProductRepository productrepository;
    @Autowired
    CoustomerRepository coustomerRepository;
    @Autowired
    TwilioConfig twilioConfig;
    @Autowired
    WhatsappMsg whatsappMsg;

    // Method to add all received products into the database
    public String AddAllProduct(List<Product> products) {
        productrepository.saveAll(products);
        return "Receive All Product Success Fully";
    }

    // Method to process the purchase of a product
    public String buyProduct(CoustomerDTO info) {

        Product product = productrepository.findByProductName(info.getProduct_name());
        try {
            // Check if requested quantity is more than stock
            if (info.getProduct_count() > product.getStock()) {
                whatsappMsg.OutOfStoc("+919773198780"); // Send out-of-stock message
                return "Out Of Stock : stock is " + product.getStock();
            }

            int productprice = product.getPrice();// Get unit price

            long calculate_price_withothgst = calculatePrice(productprice, info.getProduct_count());// Calculate price without GST

            double total_amount = calculate_price_withothgst + calculate_Gst(calculate_price_withothgst); // Add GST

            // Simulate payment success/failure
            if (!getRandomBoolean()) {
                whatsappMsg.UnsuccessBUy("+919773198780");// Send failure message
                return "Payment Unsuccessfully";
            }

            // Save customer purchase details
            Coustomer coustomer = new Coustomer(info.getCoustomer_name(), info.getMobile_number(), info.getProduct_name(), info.getProduct_count(), product.getPrice(), total_amount, LocalDate.now());
            coustomerRepository.save(coustomer);

            // Update stock after successful purchase
            product.setStock(product.getStock() - info.getProduct_count());
            whatsappMsg.SuccessFullyBuy("+919773198780"); // Send success message
            productrepository.save(product);
            return "Payment SuccessFully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            // Notify if stock is running low
            if (product.getStock()<=5){
               whatsappMsg.UpdateStock("+919773198780");
            }
        }
    }

    // Simulate a random payment success or failure
    public boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
    // Calculate GST (18%)
    public double calculate_Gst(long value){
        return value*(18.0/100);
    }
    // Calculate total price based on quantity and unit price
    public long calculatePrice(int value,int product) {
        return value * product;
    }
}
