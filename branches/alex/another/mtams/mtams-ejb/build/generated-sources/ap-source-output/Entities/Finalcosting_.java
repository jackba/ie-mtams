package Entities;

import Entities.Application;
import Entities.Attachement;
import Entities.Quotes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-12T21:17:10")
@StaticMetamodel(Finalcosting.class)
public class Finalcosting_ { 

    public static volatile SingularAttribute<Finalcosting, Integer> accommodatedays;
    public static volatile SingularAttribute<Finalcosting, String> citys;
    public static volatile SingularAttribute<Finalcosting, Double> visacost;
    public static volatile SingularAttribute<Finalcosting, Double> airfarecost;
    public static volatile SingularAttribute<Finalcosting, String> ozemail;
    public static volatile SingularAttribute<Finalcosting, Integer> checks;
    public static volatile SingularAttribute<Finalcosting, String> countries;
    public static volatile SingularAttribute<Finalcosting, Double> conferencecost;
    public static volatile SingularAttribute<Finalcosting, Double> visabudget;
    public static volatile ListAttribute<Finalcosting, Application> applicationList;
    public static volatile SingularAttribute<Finalcosting, String> oztel;
    public static volatile SingularAttribute<Finalcosting, Integer> perdiemdays;
    public static volatile SingularAttribute<Finalcosting, String> administrativeunit;
    public static volatile SingularAttribute<Finalcosting, String> name;
    public static volatile SingularAttribute<Finalcosting, Double> othercost;
    public static volatile SingularAttribute<Finalcosting, Integer> absenceprivate;
    public static volatile SingularAttribute<Finalcosting, Double> carrentalcost;
    public static volatile SingularAttribute<Finalcosting, Double> approvedcost;
    public static volatile SingularAttribute<Finalcosting, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Finalcosting, Double> carrentalbudget;
    public static volatile SingularAttribute<Finalcosting, Integer> fromoz;
    public static volatile SingularAttribute<Finalcosting, String> ozname;
    public static volatile SingularAttribute<Finalcosting, Integer> idfinalcosting;
    public static volatile ListAttribute<Finalcosting, Attachement> attachementList;
    public static volatile SingularAttribute<Finalcosting, Double> approvedbudget;
    public static volatile SingularAttribute<Finalcosting, Double> accommodationcost;
    public static volatile SingularAttribute<Finalcosting, Double> perdiemcost;
    public static volatile SingularAttribute<Finalcosting, Double> perdiembudget;
    public static volatile SingularAttribute<Finalcosting, Double> otherbudget;
    public static volatile SingularAttribute<Finalcosting, Double> accommodationbudget;
    public static volatile SingularAttribute<Finalcosting, Double> conferencebudget;
    public static volatile SingularAttribute<Finalcosting, String> otherdiscription;
    public static volatile SingularAttribute<Finalcosting, Double> airfarebudget;
    public static volatile SingularAttribute<Finalcosting, Integer> absencebussiness;

}