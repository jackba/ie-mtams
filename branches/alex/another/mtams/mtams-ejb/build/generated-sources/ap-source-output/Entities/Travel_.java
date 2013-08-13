package Entities;

import Entities.Application;
import Entities.Attachement;
import Entities.Conference;
import Entities.Itinerary;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-12T21:17:10")
@StaticMetamodel(Travel.class)
public class Travel_ { 

    public static volatile ListAttribute<Travel, Itinerary> itineraryList;
    public static volatile SingularAttribute<Travel, Integer> idtravel;
    public static volatile ListAttribute<Travel, Application> applicationList;
    public static volatile ListAttribute<Travel, Attachement> attachementList;
    public static volatile SingularAttribute<Travel, String> description;
    public static volatile SingularAttribute<Travel, Conference> conferenceIdconference;
    public static volatile SingularAttribute<Travel, Date> datereturn;
    public static volatile SingularAttribute<Travel, Date> datedeparture;

}