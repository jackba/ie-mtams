package Entities;

import Entities.Account;
import Entities.SessionPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-12T21:17:10")
@StaticMetamodel(Session.class)
public class Session_ { 

    public static volatile SingularAttribute<Session, SessionPK> sessionPK;
    public static volatile SingularAttribute<Session, Date> expires;
    public static volatile SingularAttribute<Session, Account> account;
    public static volatile SingularAttribute<Session, Date> date;

}