package Entities;

import Entities.Application;
import Entities.Attachement;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-19T19:35:40")
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