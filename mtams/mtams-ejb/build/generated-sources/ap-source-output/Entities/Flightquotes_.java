package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-14T23:52:40")
@StaticMetamodel(Flightquotes.class)
public class Flightquotes_ { 

    public static volatile SingularAttribute<Flightquotes, String> flightfrom;
    public static volatile SingularAttribute<Flightquotes, Date> datearrival;
    public static volatile SingularAttribute<Flightquotes, String> quotecost;
    public static volatile SingularAttribute<Flightquotes, String> quotesource;
    public static volatile SingularAttribute<Flightquotes, String> quotesourcedescription;
    public static volatile SingularAttribute<Flightquotes, String> flightto;
    public static volatile SingularAttribute<Flightquotes, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Flightquotes, Date> datedeparture;
    public static volatile CollectionAttribute<Flightquotes, Attachement> attachementCollection;
    public static volatile SingularAttribute<Flightquotes, Integer> idflightquotes;
    public static volatile SingularAttribute<Flightquotes, String> flightnumber;

}