package Entities;

import Entities.Application;
import Entities.Attachement;
import Entities.Conference;
import Entities.Itinerary;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-20T21:04:48")
@StaticMetamodel(Travel.class)
public class Travel_ { 

    public static volatile SingularAttribute<Travel, Integer> idtravel;
    public static volatile SingularAttribute<Travel, String> description;
    public static volatile CollectionAttribute<Travel, Itinerary> itineraryCollection;
    public static volatile SingularAttribute<Travel, Conference> conferenceIdconference;
    public static volatile SingularAttribute<Travel, Date> datereturn;
    public static volatile CollectionAttribute<Travel, Application> applicationCollection;
    public static volatile SingularAttribute<Travel, Date> datedeparture;
    public static volatile CollectionAttribute<Travel, Attachement> attachementCollection;

}