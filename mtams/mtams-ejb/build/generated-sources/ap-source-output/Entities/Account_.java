package Entities;

import Entities.Accountrole;
import Entities.Application;
import Entities.Approval;
import Entities.Session;
import Entities.Travelerprofile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-19T15:49:22")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> username;
    public static volatile SingularAttribute<Account, Integer> idaccount;
    public static volatile CollectionAttribute<Account, Travelerprofile> travelerprofileCollection;
    public static volatile CollectionAttribute<Account, Accountrole> accountroleCollection;
    public static volatile CollectionAttribute<Account, Session> sessionCollection;
    public static volatile SingularAttribute<Account, Date> datecreated;
    public static volatile CollectionAttribute<Account, Approval> approvalCollection;
    public static volatile SingularAttribute<Account, Date> datelogin;
    public static volatile CollectionAttribute<Account, Application> applicationCollection;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> salt;

}