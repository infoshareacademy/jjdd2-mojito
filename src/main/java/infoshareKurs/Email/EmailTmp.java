package infoshareKurs.Email;

import javax.mail.MessagingException;

public class EmailTmp {

    public static void main(String[] args) {
        EmailService email = new EmailService("mojitobikeproject.gmail.com", "bikeproject1", "smtp.gmail.com", 465);
        try {
            email.send("mojitobikeproject@gmail.com", "subject", "Hello World");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}