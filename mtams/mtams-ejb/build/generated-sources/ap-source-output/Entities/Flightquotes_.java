package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-20T21:04:48")
@StaticMetamodel(Flightquotes.class)
public class Flightquotes_ { 

    public static volatile SingularAttribute<Flightquotes, Date> datearrival;
    public static volatile SingularAttribute<Flightquotes, String> flightfromCity;
    public static volatile SingularAttribute<Flightquotes, String> flighttoCity;
    public static volatile SingularAttribute<Flightquotes, String> flighttoCountry;
    public static volatile SingularAttribute<Flightquotes, String> currency;
    public static volatile SingularAttribute<Flightquotes, String> flightfromCountry;
    public static volatile SingularAttribute<Flightquotes, Double> quotecost;
    public static volatile SingularAttribute<Flightquotes, String> quotesource;
    public static volatile SingularAttribute<Flightquotes, String> quotesourcedescription;
    public static volatile SingularAttribute<Flightquotes, Quotes> quotesIdquotes;
    public static volatile CollectionAttribute<Flightquotes, Attachement> attachementCollection;
    public static volatile SingularAttribute<Flightquotes, Date> datedeparture;
    public static volatile SingularAttribute<Flightquotes, Integer> idflightquotes;
    public static volatile SingularAttribute<Flightquotes, String> flightnumber;

}