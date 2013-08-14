package Entities;

import Entities.Accountrole;
import Entities.Application;
import Entities.Approval;
import Entities.Session;
import Entities.Travelerprofile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-11T12:39:30")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> username;
    public static volatile ListAttribute<Account, Application> applicationList;
    public static volatile SingularAttribute<Account, Integer> idaccount;
    public static volatile ListAttribute<Account, Approval> approvalList;
    public static volatile ListAttribute<Account, Accountrole> accountroleList;
    public static volatile ListAttribute<Account, Session> sessionList;
    public static volatile SingularAttribute<Account, Date> datecreated;
    public static volatile SingularAttribute<Account, Date> datelogin;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> salt;
    public static volatile ListAttribute<Account, Travelerprofile> travelerprofileList;

}