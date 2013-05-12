package Entities;

import Entities.Account;
import Entities.Application;
import Entities.Attachement;
import Entities.Rewardsprogram;
import Entities.Traveldocument;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Travelerprofile.class)
public class Travelerprofile_ { 

    public static volatile SingularAttribute<Travelerprofile, String> position;
    public static volatile SingularAttribute<Travelerprofile, String> businessfax;
    public static volatile SingularAttribute<Travelerprofile, String> carpreference1;
    public static volatile SingularAttribute<Travelerprofile, String> department;
    public static volatile SingularAttribute<Travelerprofile, String> carpreference2;
    public static volatile SingularAttribute<Travelerprofile, String> classinternational;
    public static volatile SingularAttribute<Travelerprofile, Date> datecreated;
    public static volatile CollectionAttribute<Travelerprofile, Traveldocument> traveldocumentCollection;
    public static volatile SingularAttribute<Travelerprofile, String> spousecontactnumber;
    public static volatile SingularAttribute<Travelerprofile, String> mobilephone;
    public static volatile SingularAttribute<Travelerprofile, String> title;
    public static volatile SingularAttribute<Travelerprofile, String> travelbooker;
    public static volatile SingularAttribute<Travelerprofile, String> aircon;
    public static volatile SingularAttribute<Travelerprofile, String> smoking;
    public static volatile SingularAttribute<Travelerprofile, String> homeemail;
    public static volatile SingularAttribute<Travelerprofile, Date> datemodified;
    public static volatile SingularAttribute<Travelerprofile, String> classdomestic;
    public static volatile SingularAttribute<Travelerprofile, String> seatinglocation;
    public static volatile SingularAttribute<Travelerprofile, String> cargroup;
    public static volatile SingularAttribute<Travelerprofile, String> homephone;
    public static volatile SingularAttribute<Travelerprofile, String> businessaddress;
    public static volatile SingularAttribute<Travelerprofile, Account> accountid;
    public static volatile SingularAttribute<Travelerprofile, Integer> idtravelerprofile;
    public static volatile CollectionAttribute<Travelerprofile, Rewardsprogram> rewardsprogramCollection;
    public static volatile SingularAttribute<Travelerprofile, String> hotelprefrence;
    public static volatile SingularAttribute<Travelerprofile, String> airadditionalrequirements;
    public static volatile SingularAttribute<Travelerprofile, String> middlename;
    public static volatile SingularAttribute<Travelerprofile, String> attachmentid;
    public static volatile SingularAttribute<Travelerprofile, String> knownmedicalconditions;
    public static volatile SingularAttribute<Travelerprofile, String> mealrequirements;
    public static volatile SingularAttribute<Travelerprofile, String> businessphone;
    public static volatile SingularAttribute<Travelerprofile, String> manualautomatic;
    public static volatile SingularAttribute<Travelerprofile, String> idnumber;
    public static volatile SingularAttribute<Travelerprofile, String> firstname;
    public static volatile SingularAttribute<Travelerprofile, String> doctorsemail;
    public static volatile SingularAttribute<Travelerprofile, String> doctorsname;
    public static volatile SingularAttribute<Travelerprofile, String> hoteladditionalrequirements;
    public static volatile SingularAttribute<Travelerprofile, String> caradditionalrequirements;
    public static volatile SingularAttribute<Travelerprofile, String> homeaddress;
    public static volatile SingularAttribute<Travelerprofile, String> familyname;
    public static volatile SingularAttribute<Travelerprofile, String> doctorsconctactnumber;
    public static volatile SingularAttribute<Travelerprofile, String> spousename;
    public static volatile SingularAttribute<Travelerprofile, String> seatingposition;
    public static volatile SingularAttribute<Travelerprofile, String> spouseemail;
    public static volatile SingularAttribute<Travelerprofile, String> staffid;
    public static volatile SingularAttribute<Travelerprofile, String> frequentguestnum;
    public static volatile CollectionAttribute<Travelerprofile, Application> applicationCollection;
    public static volatile CollectionAttribute<Travelerprofile, Attachement> attachementCollection;

}