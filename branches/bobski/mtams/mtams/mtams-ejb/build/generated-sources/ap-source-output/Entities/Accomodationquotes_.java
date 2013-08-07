package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-07T17:31:48")
@StaticMetamodel(Accomodationquotes.class)
public class Accomodationquotes_ { 

    public static volatile SingularAttribute<Accomodationquotes, Date> datecheckin;
    public static volatile ListAttribute<Accomodationquotes, Attachement> attachementList;
    public static volatile SingularAttribute<Accomodationquotes, String> description;
    public static volatile SingularAttribute<Accomodationquotes, String> accomodationprovider;
    public static volatile SingularAttribute<Accomodationquotes, String> quotecost;
    public static volatile SingularAttribute<Accomodationquotes, Date> datecheckout;
    public static volatile SingularAttribute<Accomodationquotes, String> quotesource;
    public static volatile SingularAttribute<Accomodationquotes, Integer> idaccomodationquotes;
    public static volatile SingularAttribute<Accomodationquotes, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Accomodationquotes, String> country;
    public static volatile SingularAttribute<Accomodationquotes, String> city;

}