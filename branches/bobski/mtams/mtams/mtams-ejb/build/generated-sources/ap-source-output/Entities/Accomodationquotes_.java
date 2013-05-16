package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-16T11:13:59")
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