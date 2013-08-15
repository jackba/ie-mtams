package Entities;

import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Attachement;
import Entities.Carquotes;
import Entities.Finalcosting;
import Entities.Flightquotes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-14T23:52:40")
@StaticMetamodel(Quotes.class)
public class Quotes_ { 

    public static volatile SingularAttribute<Quotes, Integer> idquotes;
    public static volatile SingularAttribute<Quotes, Integer> amended;
    public static volatile CollectionAttribute<Quotes, Flightquotes> flightquotesCollection;
    public static volatile CollectionAttribute<Quotes, Accomodationquotes> accomodationquotesCollection;
    public static volatile SingularAttribute<Quotes, String> description;
    public static volatile SingularAttribute<Quotes, String> costcenter;
    public static volatile CollectionAttribute<Quotes, Carquotes> carquotesCollection;
    public static volatile CollectionAttribute<Quotes, Application> applicationCollection;
    public static volatile CollectionAttribute<Quotes, Attachement> attachementCollection;
    public static volatile CollectionAttribute<Quotes, Finalcosting> finalcostingCollection;

}