package com.billGenerate.BillGenerate;

import com.billGenerate.BillGenerate.model.Product;
import com.billGenerate.BillGenerate.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;

@SpringBootApplication
public class BillGenerateApplication {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(BillGenerateApplication.class, args);
    }

//    @PostConstruct
//    public void makeCsv(){
//        try (FileWriter fileWriter = new FileWriter("C:\\Users\\krohi\\Downloads\\BillGenerate\\BillGenerate\\src\\main\\java\\com\\billGenerate\\BillGenerate\\Service\\demo.csv");
//             ICsvBeanWriter iCsvBeanWriter = new CsvBeanWriter(fileWriter, CsvPreference.STANDARD_PREFERENCE);) {
//
//            String headers[] = {"Id", "productName", "stock", "price"};
//            iCsvBeanWriter.writeHeader(headers);
//
//            for (Product product : productRepository.findAll()) {
//                iCsvBeanWriter.write(product, headers);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
