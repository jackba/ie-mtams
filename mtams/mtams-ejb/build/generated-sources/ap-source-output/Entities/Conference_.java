package Entities;

import Entities.Attachement;
import Entities.Travel;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-19T15:49:22")
@StaticMetamodel(Conference.class)
public class Conference_ { 

    public static volatile SingularAttribute<Conference, String> replacement;
    public static volatile SingularAttribute<Conference, String> replacementarrangments;
    public static volatile SingularAttribute<Conference, String> otherfundingsources;
    public static volatile SingularAttribute<Conference, Integer> idconference;
    public static volatile SingularAttribute<Conference, String> country;
    public static volatile SingularAttribute<Conference, String> city;
    public static volatile SingularAttribute<Conference, String> authors;
    public static volatile SingularAttribute<Conference, Date> datefrom;
    public static volatile SingularAttribute<Conference, String> presentationtitle;
    public static volatile SingularAttribute<Conference, Integer> presenting;
    public static volatile SingularAttribute<Conference, String> webpage;
    public static volatile SingularAttribute<Conference, String> otherreasonattendance;
    public static volatile SingularAttribute<Conference, String> conferencename;
    public static volatile SingularAttribute<Conference, Integer> conferenceduration;
    public static volatile SingularAttribute<Conference, Date> dateto;
    public static volatile CollectionAttribute<Conference, Travel> travelCollection;
    public static volatile SingularAttribute<Conference, String> fundingsources;
    public static volatile CollectionAttribute<Conference, Attachement> attachementCollection;
    public static volatile SingularAttribute<Conference, Date> datemsapresentation;
    public static volatile SingularAttribute<Conference, String> fundname;

}