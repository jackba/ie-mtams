package Entities;

import Entities.Attachement;
import Entities.Travel;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-19T15:49:22")
@StaticMetamodel(Itinerary.class)
public class Itinerary_ { 

    public static volatile SingularAttribute<Itinerary, String> destinationCity;
    public static volatile SingularAttribute<Itinerary, Date> datefrom;
    public static volatile SingularAttribute<Itinerary, String> travelday;
    public static volatile SingularAttribute<Itinerary, String> leavetype;
    public static volatile SingularAttribute<Itinerary, String> leavedescription;
    public static volatile SingularAttribute<Itinerary, Date> dateto;
    public static volatile SingularAttribute<Itinerary, String> destinationCountry;
    public static volatile SingularAttribute<Itinerary, Date> date;
    public static volatile SingularAttribute<Itinerary, Integer> iditinerary;
    public static volatile SingularAttribute<Itinerary, Travel> travelIdtravel;
    public static volatile CollectionAttribute<Itinerary, Attachement> attachementCollection;

}