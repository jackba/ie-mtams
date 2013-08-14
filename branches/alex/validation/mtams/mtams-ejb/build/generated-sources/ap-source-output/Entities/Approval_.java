package Entities;

import Entities.Account;
import Entities.Application;
import Entities.Attachement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-11T12:39:30")
@StaticMetamodel(Approval.class)
public class Approval_ { 

    public static volatile SingularAttribute<Approval, Integer> sectionapproved;
    public static volatile ListAttribute<Approval, Attachement> attachementList;
    public static volatile SingularAttribute<Approval, Integer> sectionid;
    public static volatile SingularAttribute<Approval, String> fromsection;
    public static volatile SingularAttribute<Approval, Application> applicationIdapplication;
    public static volatile SingularAttribute<Approval, Account> accountIdaccount;
    public static volatile SingularAttribute<Approval, String> notes;
    public static volatile SingularAttribute<Approval, Date> date;
    public static volatile SingularAttribute<Approval, Integer> idapproval;

}