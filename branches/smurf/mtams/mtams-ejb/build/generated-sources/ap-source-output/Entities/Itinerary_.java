package Entities;

import Entities.Attachement;
import Entities.Travel;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-19T17:49:03")
@StaticMetamodel(Itinerary.class)
public class Itinerary_ { 

    public static volatile SingularAttribute<Itinerary, Date> datefrom;
    public static volatile SingularAttribute<Itinerary, String> travelday;
    public static volatile ListAttribute<Itinerary, Attachement> attachementList;
    public static volatile SingularAttribute<Itinerary, String> leavetype;
    public static volatile SingularAttribute<Itinerary, String> leavedescription;
    public static volatile SingularAttribute<Itinerary, Date> dateto;
    public static volatile SingularAttribute<Itinerary, Date> date;
    public static volatile SingularAttribute<Itinerary, Integer> iditinerary;
    public static volatile SingularAttribute<Itinerary, Travel> travelIdtravel;
    public static volatile SingularAttribute<Itinerary, String> destination;

}