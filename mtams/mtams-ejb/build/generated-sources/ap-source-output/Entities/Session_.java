package Entities;

import Entities.Account;
import Entities.SessionPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-22T20:20:57")
@StaticMetamodel(Session.class)
public class Session_ { 

    public static volatile SingularAttribute<Session, SessionPK> sessionPK;
    public static volatile SingularAttribute<Session, Date> expires;
    public static volatile SingularAttribute<Session, Account> account;
    public static volatile SingularAttribute<Session, Date> date;

}