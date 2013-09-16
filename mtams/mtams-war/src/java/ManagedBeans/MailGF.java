/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * http://spitballer.blogspot.com/2010/02/sending-email-via-glassfish-v3.html
 * http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 * http://www.hildeberto.com/2010/02/sending-e-mails-with-javamail-on.html
 * 
 * see the image attached to issue 114 https://code.google.com/p/ie-mtams/issues/detail?id=114
 * for instructions on how to set up glassfish to send emails.
 * or refer to the links above. 
 * 
 */
package ManagedBeans;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author aaron
 */
@Named(value = "mailGF")
@RequestScoped
public class MailGF {

    //sendMailTLS sndTLS;
    @Resource(name = "mail/mySession")
    private Session mailSession;
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());

    public void sendMessage() {
        logger.log(Level.INFO, "MailGF.class.getClass() : {0}", MailGF.class.getClass());
        Message msg = new MimeMessage(mailSession);
        //InternetAddress address = new InternetAddress("nelaaro@gmail.com");
        try {
            msg.setSubject("[app] Email Alert");
            msg.setRecipient(RecipientType.TO, new InternetAddress("nelaaro@gmail.com"));

//            msg.setRecipient(RecipientType.TO,
//                    new InternetAddress(userAccount.getEmail(),
//                    userAccount.toString()));
            msg.setText("Hello test email \n <h1> Test heading</h1>");
            Calendar cal = Calendar.getInstance();
            String txt = String.format("<h1> test html </h1> <p> %tB %te, %tY%n %tl:%tM %tp%n\"</p>", cal, cal, cal, cal, cal, cal);
            msg.setContent(txt, "text/html");
            Transport.send(msg);
        } catch (AddressException ex) {
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException me) {
            // manage exception
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, me);
        }
//        catch (AddressException address) {
//            // manage exception
//        }
        logger.log(Level.INFO, "email msg : {0}", msg);
    }

    public void send(Address ToAddress, String MSGText) {
        logger.log(Level.INFO, "MailGF.class.getClass() : {0}", MailGF.class.getClass());
        Message msg = new MimeMessage(mailSession);

        try {
            msg.setSubject("[app] Email Alert");
            msg.setRecipient(RecipientType.TO, ToAddress);
            msg.setContent(MSGText, "text/html");
            Transport.send(msg);
        } catch (MessagingException me) {
            // manage exception
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, me);
        }
    }

    public void send(String ToAddressS, String MSGText) {
        logger.log(Level.INFO, "MailGF.class.getClass() : {0}", MailGF.class.getClass());
        Message msg = new MimeMessage(mailSession);

        try {
            InternetAddress ToAddress = new InternetAddress(ToAddressS);
            
            msg.setSubject("[app] Email Alert");
            msg.setRecipient(RecipientType.TO, ToAddress);
            msg.setContent(MSGText, "text/html");
            Transport.send(msg);
        } catch (AddressException ex) {
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException me) {
            // manage exception
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, me);
        }
    }
    
        public void send(String ToAddressS, String Subject, String MSGText) {
        logger.log(Level.INFO, "MailGF.class.getClass() : {0}", MailGF.class.getClass());
        Message msg = new MimeMessage(mailSession);

        try {
            InternetAddress ToAddress = new InternetAddress(ToAddressS);
            
            msg.setSubject(Subject);
            msg.setRecipient(RecipientType.TO, ToAddress);
            msg.setContent(MSGText, "text/html");
            Transport.send(msg);
        } catch (AddressException ex) {
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException me) {
            // manage exception
            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, me);
        }
    }

    public void test() {

        Calendar cal = Calendar.getInstance();
        String txt = String.format("<h1> test html </h1> <p> %tB %te, %tY%n %tl:%tM %tp%n\"</p>", cal, cal, cal, cal, cal, cal);

        this.send("nelaaro@gmail.com", txt);
        this.send("nelaaro@gmail.com", "test subject", txt);
        
//        try {
//            InternetAddress address = new InternetAddress("nelaaro@gmail.com");
//            this.send(address, txt);
//        } catch (AddressException ex) {
//            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }

    /**
     * Creates a new instance of MailGF
     */
    public MailGF() {
        //sndTLS = new sendMailTLS();
    }
}
