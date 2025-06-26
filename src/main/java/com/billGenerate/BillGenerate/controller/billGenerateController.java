package com.billGenerate.BillGenerate.controller;

import com.billGenerate.BillGenerate.EmailSend.MailService;
import com.billGenerate.BillGenerate.model.Coustomer;
import com.billGenerate.BillGenerate.model.CoustomerDTO;
import com.billGenerate.BillGenerate.model.Product;
import com.billGenerate.BillGenerate.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("ProductBuy")
public class billGenerateController {

    @Autowired
    BillService billService;
    @Autowired
    MailService mailService;

    @PostMapping("AddProduct")
    public String addProduct(@RequestBody List<Product> products){
        return billService.AddAllProduct(products);
    }
    @GetMapping("BuyProduct")
    public String buyProduct(@RequestBody CoustomerDTO info){
        return billService.buyProduct(info);
    }
    @GetMapping("/report")
    public String getReport() throws FileNotFoundException {
        System.out.println("hello");

        return mailService.sendStartupMail();
    }
}
