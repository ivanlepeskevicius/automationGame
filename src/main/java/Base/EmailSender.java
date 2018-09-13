package Base;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailSender {

    public static void main() {

        final String username = "email.test.lepi@gmail.com";
        final String password = "Pass123**";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("email.test.lepi@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("i.lepeskevicius@gmail.com"));
            message.setSubject("Testing Failure");
            message.setText("Here you can find the test results.");

            MimeBodyPart messageBodyPart;
            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = "test-output/emailable-report.html";
            String fileName = "TestResult";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}