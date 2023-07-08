package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizeMailAuth extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return  new PasswordAuthentication(MailMetaData.myUserEmail,MailMetaData.password);

    }
}
