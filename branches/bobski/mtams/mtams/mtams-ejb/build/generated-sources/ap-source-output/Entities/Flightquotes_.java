package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-16T11:13:59")
@StaticMetamodel(Flightquotes.class)
public class Flightquotes_ { 

    public static volatile SingularAttribute<Flightquotes, String> flightfrom;
    public static volatile ListAttribute<Flightquotes, Attachement> attachementList;
    public static volatile SingularAttribute<Flightquotes, Date> datearrival;
    public static volatile SingularAttribute<Flightquotes, String> quotecost;
    public static volatile SingularAttribute<Flightquotes, String> quotesource;
    public static volatile SingularAttribute<Flightquotes, String> quotesourcedescription;
    public static volatile SingularAttribute<Flightquotes, String> flightto;
    public static volatile SingularAttribute<Flightquotes, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Flightquotes, Date> datedeparture;
    public static volatile SingularAttribute<Flightquotes, Integer> idflightquotes;
    public static volatile SingularAttribute<Flightquotes, String> flightnumber;

}