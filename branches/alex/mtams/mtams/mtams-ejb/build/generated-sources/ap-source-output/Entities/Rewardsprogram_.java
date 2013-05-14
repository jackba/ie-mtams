package Entities;

import Entities.Attachement;
import Entities.Travelerprofile;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-13T13:46:22")
@StaticMetamodel(Rewardsprogram.class)
public class Rewardsprogram_ { 

    public static volatile ListAttribute<Rewardsprogram, Attachement> attachementList;
    public static volatile SingularAttribute<Rewardsprogram, String> membershiptype;
    public static volatile SingularAttribute<Rewardsprogram, String> description;
    public static volatile SingularAttribute<Rewardsprogram, Integer> idrewardsprogram;
    public static volatile SingularAttribute<Rewardsprogram, Travelerprofile> travelerprofileIdtravelerprofile;
    public static volatile SingularAttribute<Rewardsprogram, String> provider;
    public static volatile SingularAttribute<Rewardsprogram, String> membershipnumber;

}