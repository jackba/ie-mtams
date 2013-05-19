package Entities;

import Entities.Account;
import Entities.Application;
import Entities.Attachement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-19T19:35:40")
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