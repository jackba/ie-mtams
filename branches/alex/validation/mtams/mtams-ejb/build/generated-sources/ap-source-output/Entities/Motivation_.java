package Entities;

import Entities.Application;
import Entities.Attachement;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-11T12:39:30")
@StaticMetamodel(Motivation.class)
public class Motivation_ { 

    public static volatile SingularAttribute<Motivation, String> amount;
    public static volatile SingularAttribute<Motivation, Integer> budget;
    public static volatile ListAttribute<Motivation, Application> applicationList;
    public static volatile ListAttribute<Motivation, Attachement> attachementList;
    public static volatile SingularAttribute<Motivation, String> costcenter;
    public static volatile SingularAttribute<Motivation, String> motivation;
    public static volatile SingularAttribute<Motivation, String> recommended;
    public static volatile SingularAttribute<Motivation, String> requestedby;
    public static volatile SingularAttribute<Motivation, Integer> idmotivation;
    public static volatile SingularAttribute<Motivation, String> supplier;

}