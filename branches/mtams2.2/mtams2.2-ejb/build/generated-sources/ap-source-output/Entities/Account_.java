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

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
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