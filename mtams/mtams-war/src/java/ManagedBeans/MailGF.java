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

import DataAccess.MessagesFacadeLocal;
import Entities.Messages;
import ServiceLayer.MessagesHandlerLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
//@RequestScoped
@ConversationScoped
//@SessionScoped
public class MailGF implements Serializable {
// mailGF Glassfish
    //java mail session linked to jndi/javamail/mySession

    @Resource(name = "mail/mySession")
    private Session mailSession;
    //
    @EJB
    private MessagesHandlerLocal daoMessageHandler;
    @EJB
    private MessagesFacadeLocal daoMessage;
    private String NameS;
    private String DescriptionS;
    private String SubjectS;
    private String MessageS;
    private Messages messagesE;
    private String toAddress;
    private ArrayList<Messages> messagesList;
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());

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
        logger.log(Level.INFO, "ToAddressS : {0}", ToAddressS);
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
        String txt = String.format("<h3> A new application has arrived pending your approval. Please log in to view the application details</h3> <p> %tB %te, %tY%n %tl:%tM %tp%n\"</p>", cal, cal, cal, cal, cal, cal);

        //this.send("nelaaro@gmail.com", txt);
        this.send("bwanarm@gmail.com", "New Application pending aproval", txt);

//        try {
//            InternetAddress address = new InternetAddress("nelaaro@gmail.com");
//            this.send(address, txt);
//        } catch (AddressException ex) {
//            Logger.getLogger(MailGF.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }

    public void test2() {
        logger.log(Level.INFO, "getToAddress() : {0}", this.getToAddress());
        for (Messages messages : messagesList) {
            logger.log(Level.INFO, "update messages : {0}", messages.getName());
            logger.log(Level.INFO, "update messages msg : {0}", messages.getMessage());
                this.send(this.getToAddress(), messages.getSubject(), messages.getMessage());
        }
    }
    
    public void test3() {
        Messages m = new Messages();
        m = daoMessageHandler.findMessages(NameS);
        this.send(this.getToAddress(),m.getSubject(),m.getMessage());
                
    }

    /**
     * Creates a new instance of MailGF
     */
    public MailGF() {
        logger.log(Level.INFO, "MailGF.class.getEnclosingMethod() : {0}", MailGF.class.getName());
        //logger.log(Level.INFO, "daoMessage.findAll() : {0}", daoMessageHandler.getMessages());

    }

    @PostConstruct
    public void init() {
        messagesList = new ArrayList<Messages>();
        messagesList.addAll(daoMessageHandler.getMessages());
        logger.log(Level.INFO, "messagesList : {0}", messagesList);
        //daoMessage.findAll()
        if (!(messagesList.isEmpty())) {
            messagesE = messagesList.get(0);
            logger.log(Level.INFO, "messagesE : {0}", messagesE);
        }
    }

    public String cancel() {
        return "/superHome.xhtml";
    }

    public String updateAll() {
        logger.log(Level.INFO, "update all message : {0}", "is starting");
        //logger.log(Level.INFO, "update messages : {0}", messages);
        for (Messages messages : messagesList) {

            logger.log(Level.INFO, "update messages msg : {0}", messages.getMessage());
            daoMessageHandler.updateMessages(messages);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Mail templates updated"));
        return "/messageAdmin.xhtml";
    }

    public String toAppHome() {
        return "/applicationHome.xhtml";
    }

    /**
     * *
     *
     * AUTO GENERATED Methods | VVV
     *
     */
    public String getMessageS() {
        return MessageS;
    }

    public void setMessageS(String MessageS) {
        this.MessageS = MessageS;
    }

    public MessagesFacadeLocal getDaoMessage() {
        return daoMessage;
    }

    public void setDaoMessage(MessagesFacadeLocal daoMessage) {
        this.daoMessage = daoMessage;
    }

    public Messages getMessagesE() {
        return messagesE;
    }

    public void setMessagesE(Messages messagesE) {
        this.messagesE = messagesE;
    }

    public Session getMailSession() {
        return mailSession;
    }

    public void setMailSession(Session mailSession) {
        this.mailSession = mailSession;
    }

    public ArrayList<Messages> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(ArrayList<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    public MessagesHandlerLocal getDaoMessageHandler() {
        return daoMessageHandler;
    }

    public void setDaoMessageHandler(MessagesHandlerLocal daoMessageHandler) {
        this.daoMessageHandler = daoMessageHandler;
    }

    public String getNameS() {
        return NameS;
    }

    public void setNameS(String NameS) {
        this.NameS = NameS;
    }

    public String getDescriptionS() {
        return DescriptionS;
    }

    public void setDescriptionS(String DescriptionS) {
        this.DescriptionS = DescriptionS;
    }

    public String getSubjectS() {
        return SubjectS;
    }

    public void setSubjectS(String SubjectS) {
        this.SubjectS = SubjectS;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
    
    
}
