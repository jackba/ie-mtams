package Entities;

import Entities.Account;
import Entities.Approval;
import Entities.Attachement;
import Entities.Finalcosting;
import Entities.Forexorder;
import Entities.Motivation;
import Entities.Quotes;
import Entities.Travel;
import Entities.Travelerprofile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-11T12:39:30")
@StaticMetamodel(Application.class)
public class Application_ { 

    public static volatile SingularAttribute<Application, Forexorder> forexorderIdforexorder;
    public static volatile SingularAttribute<Application, Integer> idapplication;
    public static volatile ListAttribute<Application, Attachement> attachementList;
    public static volatile SingularAttribute<Application, Motivation> motivationIdmotivation;
    public static volatile ListAttribute<Application, Approval> approvalList;
    public static volatile SingularAttribute<Application, String> description;
    public static volatile SingularAttribute<Application, Travelerprofile> travelerprofileIdtravelerprofile;
    public static volatile SingularAttribute<Application, Date> datemodified;
    public static volatile SingularAttribute<Application, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Application, Finalcosting> finalcostingIdfinalcosting;
    public static volatile SingularAttribute<Application, Account> accountIdaccount;
    public static volatile SingularAttribute<Application, Travel> travelIdtravel;

}