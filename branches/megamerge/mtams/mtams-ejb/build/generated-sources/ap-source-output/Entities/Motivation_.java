package Entities;

import Entities.Application;
import Entities.Attachement;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-19T15:49:22")
@StaticMetamodel(Motivation.class)
public class Motivation_ { 

    public static volatile SingularAttribute<Motivation, Double> amount;
    public static volatile SingularAttribute<Motivation, Integer> budget;
    public static volatile SingularAttribute<Motivation, String> costcenter;
    public static volatile SingularAttribute<Motivation, String> motivation;
    public static volatile SingularAttribute<Motivation, String> recommended;
    public static volatile SingularAttribute<Motivation, String> requestedby;
    public static volatile SingularAttribute<Motivation, Integer> idmotivation;
    public static volatile CollectionAttribute<Motivation, Application> applicationCollection;
    public static volatile CollectionAttribute<Motivation, Attachement> attachementCollection;
    public static volatile SingularAttribute<Motivation, String> supplier;
    public static volatile SingularAttribute<Motivation, String> currency;

}