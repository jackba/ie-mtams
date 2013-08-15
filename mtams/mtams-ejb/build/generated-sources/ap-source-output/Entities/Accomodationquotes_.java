package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-14T23:52:40")
@StaticMetamodel(Accomodationquotes.class)
public class Accomodationquotes_ { 

    public static volatile SingularAttribute<Accomodationquotes, Date> datecheckin;
    public static volatile SingularAttribute<Accomodationquotes, String> description;
    public static volatile SingularAttribute<Accomodationquotes, String> accomodationprovider;
    public static volatile SingularAttribute<Accomodationquotes, String> quotecost;
    public static volatile SingularAttribute<Accomodationquotes, Date> datecheckout;
    public static volatile SingularAttribute<Accomodationquotes, String> quotesource;
    public static volatile SingularAttribute<Accomodationquotes, Integer> idaccomodationquotes;
    public static volatile SingularAttribute<Accomodationquotes, Quotes> quotesIdquotes;
    public static volatile CollectionAttribute<Accomodationquotes, Attachement> attachementCollection;
    public static volatile SingularAttribute<Accomodationquotes, String> country;
    public static volatile SingularAttribute<Accomodationquotes, String> city;

}