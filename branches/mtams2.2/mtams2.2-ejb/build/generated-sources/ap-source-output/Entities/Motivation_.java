package Entities;

import Entities.Application;
import Entities.Attachement;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Motivation.class)
public class Motivation_ { 

    public static volatile SingularAttribute<Motivation, String> amount;
    public static volatile SingularAttribute<Motivation, Integer> budget;
    public static volatile SingularAttribute<Motivation, String> costcenter;
    public static volatile SingularAttribute<Motivation, String> motivation;
    public static volatile SingularAttribute<Motivation, String> recommended;
    public static volatile SingularAttribute<Motivation, String> requestedby;
    public static volatile SingularAttribute<Motivation, Integer> idmotivation;
    public static volatile CollectionAttribute<Motivation, Application> applicationCollection;
    public static volatile CollectionAttribute<Motivation, Attachement> attachementCollection;
    public static volatile SingularAttribute<Motivation, String> supplier;

}