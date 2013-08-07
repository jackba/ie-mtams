package Entities;

import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Approval;
import Entities.Carquotes;
import Entities.Conference;
import Entities.Finalcosting;
import Entities.Flightquotes;
import Entities.Forexorder;
import Entities.Itinerary;
import Entities.Motivation;
import Entities.Quotes;
import Entities.Rewardsprogram;
import Entities.Travel;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-07T17:48:31")
@StaticMetamodel(Attachement.class)
public class Attachement_ { 

    public static volatile SingularAttribute<Attachement, Rewardsprogram> rewardsprogramIdrewardsprogram;
    public static volatile SingularAttribute<Attachement, Forexorder> forexorderIdforexorder;
    public static volatile SingularAttribute<Attachement, Motivation> motivationIdmotivation;
    public static volatile SingularAttribute<Attachement, Approval> approvalIdapproval;
    public static volatile SingularAttribute<Attachement, String> documentlocation;
    public static volatile SingularAttribute<Attachement, Flightquotes> flightquotesIdflightquotes;
    public static volatile SingularAttribute<Attachement, Traveldocument> traveldocumentIdtraveldocuments;
    public static volatile SingularAttribute<Attachement, Travelerprofile> travelerprofileIdtravelerprofile;
    public static volatile SingularAttribute<Attachement, Itinerary> itineraryIditinerary;
    public static volatile SingularAttribute<Attachement, Integer> idattachement;
    public static volatile SingularAttribute<Attachement, Carquotes> carquotesIdcarquotes;
    public static volatile SingularAttribute<Attachement, String> description;
    public static volatile SingularAttribute<Attachement, Conference> conferenceIdconference;
    public static volatile SingularAttribute<Attachement, Accomodationquotes> accomodationquotesIdaccomodationquotes;
    public static volatile SingularAttribute<Attachement, Application> applicationIdapplication;
    public static volatile SingularAttribute<Attachement, Finalcosting> finalcostingIdfinalcosting;
    public static volatile SingularAttribute<Attachement, Quotes> quotesIdquotes;
    public static volatile SingularAttribute<Attachement, Travel> travelIdtravel;

}