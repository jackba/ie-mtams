package Entities;

import Entities.SessionsPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-12T20:08:09")
@StaticMetamodel(Sessions.class)
public class Sessions_ { 

    public static volatile SingularAttribute<Sessions, SessionsPK> sessionsPK;
    public static volatile SingularAttribute<Sessions, Date> date;
    public static volatile SingularAttribute<Sessions, Date> expirydate;

}