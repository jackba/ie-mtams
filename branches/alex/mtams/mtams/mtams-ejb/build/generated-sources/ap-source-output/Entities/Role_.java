package Entities;

import Entities.Accountrole;
import Entities.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-08-03T20:41:29")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> idroles;
    public static volatile ListAttribute<Role, Accountrole> accountroleList;
    public static volatile SingularAttribute<Role, String> description;
    public static volatile SingularAttribute<Role, String> role;
    public static volatile ListAttribute<Role, Permission> permissionList;

}