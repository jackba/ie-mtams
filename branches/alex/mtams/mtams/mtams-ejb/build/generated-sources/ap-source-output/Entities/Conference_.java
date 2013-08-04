package Entities;

import Entities.Attachement;
import Entities.Travel;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-08-03T20:41:29")
@StaticMetamodel(Conference.class)
public class Conference_ { 

    public static volatile SingularAttribute<Conference, String> replacement;
    public static volatile SingularAttribute<Conference, String> replacementarrangments;
    public static volatile ListAttribute<Conference, Attachement> attachementList;
    public static volatile SingularAttribute<Conference, Integer> idconference;
    public static volatile SingularAttribute<Conference, String> country;
    public static volatile SingularAttribute<Conference, String> city;
    public static volatile SingularAttribute<Conference, String> authors;
    public static volatile ListAttribute<Conference, Travel> travelList;
    public static volatile SingularAttribute<Conference, String> presentationtitle;
    public static volatile SingularAttribute<Conference, Date> datefrom;
    public static volatile SingularAttribute<Conference, Integer> presenting;
    public static volatile SingularAttribute<Conference, String> webpage;
    public static volatile SingularAttribute<Conference, String> otherreasonattendance;
    public static volatile SingularAttribute<Conference, String> conferencename;
    public static volatile SingularAttribute<Conference, Integer> conferenceduration;
    public static volatile SingularAttribute<Conference, Date> dateto;
    public static volatile SingularAttribute<Conference, Date> datemsapresentation;

}