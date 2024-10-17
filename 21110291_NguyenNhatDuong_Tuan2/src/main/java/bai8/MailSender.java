package bai8;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailSender{
    public static void main(String[] args) {
        String to = "duongasd512@gmail.com";
        String user = "duongnhat512@gmail.com";
        String pass = "msew kftz sgsp hynm";
        String host = "smtp.gmail.com";
        String port = "587";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        };

        Session session = Session.getInstance(properties, authenticator); // Lay doi tuong mac dinh
        try{
            MimeMessage message = new MimeMessage(session); // Tao doi tuong mac dinh MimeMessage
            message.setFrom(new InternetAddress(user)); // Thiet lap dia chi nguoi gui
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to)); // Thiet lap dia chi nguoi nhan
            message.setSubject("Subject Line!");

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText("Message body"); // Noi dung email

            Multipart multipart = new MimeMultipart(); // Email se gom 2 part (text, file dinh kem)

            multipart.addBodyPart(messageBodyPart); // Them phan noi dung email

            // Xu ly phan file dinh kem
            messageBodyPart = new MimeBodyPart();
            String filename = "files/photo.jpg";
            DataSource source = new FileDataSource(filename);
            DataHandler dataHandler = new DataHandler(source);
            messageBodyPart.setDataHandler(dataHandler);
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
