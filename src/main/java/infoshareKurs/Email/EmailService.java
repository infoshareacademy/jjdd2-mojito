package infoshareKurs.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private final String eMailAdress;
    private final String pass;
    private final String smtpAdress;
    private final Integer port;
    private final Session session;

    public EmailService(String eMailAdress, String pass, String smtpAdress, Integer port) {
        this.eMailAdress = eMailAdress;
        this.pass = pass;
        this.smtpAdress = smtpAdress;
        this.port = port;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpAdress);
        properties.put("mail.smtp.socketFactory.port", port);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", port);

        session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(eMailAdress, pass);
                    }
                });
    }
//TODO metoda ktora bierze dane z bazy danch lub sesji = content jako lista stringow

    public void send(String recipient, String subject, String content) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(eMailAdress));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(content);
        Transport.send(message);
    }
}


