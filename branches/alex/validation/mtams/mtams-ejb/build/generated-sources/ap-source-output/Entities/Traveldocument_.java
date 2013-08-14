package Entities;

import Entities.Attachement;
import Entities.Travelerprofile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-11T12:39:30")
@StaticMetamodel(Traveldocument.class)
public class Traveldocument_ { 

    public static volatile SingularAttribute<Traveldocument, String> passportnumber;
    public static volatile ListAttribute<Traveldocument, Attachement> attachementList;
    public static volatile SingularAttribute<Traveldocument, Date> dateofissue;
    public static volatile SingularAttribute<Traveldocument, Integer> idtraveldocuments;
    public static volatile SingularAttribute<Traveldocument, Date> expirydate;
    public static volatile SingularAttribute<Traveldocument, Travelerprofile> travlerprofileIdtravlerprofile;
    public static volatile SingularAttribute<Traveldocument, String> country;
    public static volatile SingularAttribute<Traveldocument, String> validvisa;

}