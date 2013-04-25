package Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-22T00:36:45")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> username;
    public static volatile SingularAttribute<Account, Integer> idAccount;
    public static volatile SingularAttribute<Account, Integer> fkIdRole;
    public static volatile SingularAttribute<Account, String> password;

}