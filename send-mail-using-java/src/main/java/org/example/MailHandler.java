package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sendmail(){
        Properties sysProperties =  System.getProperties(); //this gives me a hashmap/hashtable

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host",MailMetaData.hostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authPermission,"true");

        // create a session using email and password
        Authenticator customizemailAuth = new CustomizeMailAuth();
        Session mailsession =  Session.getInstance(sysProperties,customizemailAuth);

        MimeMessage mailMessage = new MimeMessage(mailsession);

        try {
            mailMessage.setFrom(MailMetaData.myUserEmail);
            mailMessage.setSubject("This is my java code testing");
            mailMessage.setText("Hey Murli Kumar");

            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

            Transport.send(mailMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
