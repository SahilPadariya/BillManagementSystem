package com.billGenerate.BillGenerate.EmailSend;
import com.billGenerate.BillGenerate.model.Coustomer;
import com.billGenerate.BillGenerate.repository.CoustomerRepository;
import jakarta.annotation.PostConstruct;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@Component
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    CoustomerRepository coustomerRepository;
    @PostConstruct  //method application startup
    public String sendStartupMail() {
        LocalDate date = LocalDate.now();
        List<Coustomer> report = coustomerRepository.findByLocalDate(date);
        File csv = new File("report.csv");
        try (PrintWriter writer = new PrintWriter(csv)) {
            writer.println("ID,Name,Mobile,Product,Amount");
            for (Coustomer c : report) {
                writer.println(c.getId() + "," + c.getCoustomer_name() + "," + c.getMobile_number() + "," + c.getProduct_name() + "," + c.getTotal_amount());
            }
            writer.flush();
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("sahilpa24@gmail.com");
            helper.setTo("rahulbhutaiya613@gmail.com");
            helper.setSubject("Customer CSV Report");
            helper.setText("Please find attached customer report CSV file.");

            // 3. Attach file
            FileSystemResource file = new FileSystemResource(csv);
            helper.addAttachment("CustomerReport.csv", file);

            mailSender.send(message);
            return "Mail Send Successfully";
        } catch (Exception e) {
            e.printStackTrace();

            return "Error Sending Email: " + e.getMessage();
        }
    }
}
