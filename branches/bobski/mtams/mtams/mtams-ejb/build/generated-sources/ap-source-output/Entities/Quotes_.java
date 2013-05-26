package Entities;

import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Attachement;
import Entities.Carquotes;
import Entities.Finalcosting;
import Entities.Flightquotes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-26T22:00:54")
@StaticMetamodel(Quotes.class)
public class Quotes_ { 

    public static volatile SingularAttribute<Quotes, Integer> idquotes;
    public static volatile ListAttribute<Quotes, Carquotes> carquotesList;
    public static volatile ListAttribute<Quotes, Flightquotes> flightquotesList;
    public static volatile SingularAttribute<Quotes, Integer> amended;
    public static volatile ListAttribute<Quotes, Application> applicationList;
    public static volatile ListAttribute<Quotes, Attachement> attachementList;
    public static volatile SingularAttribute<Quotes, String> description;
    public static volatile SingularAttribute<Quotes, String> costcenter;
    public static volatile ListAttribute<Quotes, Finalcosting> finalcostingList;
    public static volatile ListAttribute<Quotes, Accomodationquotes> accomodationquotesList;

}