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

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
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