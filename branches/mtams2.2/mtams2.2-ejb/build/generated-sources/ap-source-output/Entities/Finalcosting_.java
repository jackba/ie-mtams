package Entities;

import Entities.Application;
import Entities.Attachement;
import Entities.Quotes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Finalcosting.class)
public class Finalcosting_ { 

    public static volatile SingularAttribute<Finalcosting, Double> accommodationbudget;
    public static volatile SingularAttribute<Finalcosting, Integer> idfinalcosting;
    public static volatile SingularAttribute<Finalcosting, Double> accommodationcost;
    public static volatile SingularAttribute<Finalcosting, Double> airfarecost;
    public static volatile SingularAttribute<Finalcosting, Double> carrentalcost;
    public static volatile CollectionAttribute<Finalcosting, Application> applicationCollection;
    public static volatile SingularAttribute<Finalcosting, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Finalcosting, Double> carrentalbudget;
    public static volatile CollectionAttribute<Finalcosting, Attachement> attachementCollection;
    public static volatile SingularAttribute<Finalcosting, Double> airfarebudget;

}