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

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Quotes.class)
public class Quotes_ { 

    public static volatile SingularAttribute<Quotes, Integer> idquotes;
    public static volatile CollectionAttribute<Quotes, Flightquotes> flightquotesCollection;
    public static volatile SingularAttribute<Quotes, String> new1;
    public static volatile SingularAttribute<Quotes, String> discritption;
    public static volatile CollectionAttribute<Quotes, Accomodationquotes> accomodationquotesCollection;
    public static volatile SingularAttribute<Quotes, String> costcenter;
    public static volatile CollectionAttribute<Quotes, Carquotes> carquotesCollection;
    public static volatile CollectionAttribute<Quotes, Application> applicationCollection;
    public static volatile CollectionAttribute<Quotes, Attachement> attachementCollection;
    public static volatile CollectionAttribute<Quotes, Finalcosting> finalcostingCollection;

}