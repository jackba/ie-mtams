package Entities;

import Entities.Account;
import Entities.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-19T17:49:03")
@StaticMetamodel(Accountrole.class)
public class Accountrole_ { 

    public static volatile SingularAttribute<Accountrole, Role> roleid;
    public static volatile SingularAttribute<Accountrole, Integer> iduserroles;
    public static volatile SingularAttribute<Accountrole, Account> accountid;

}