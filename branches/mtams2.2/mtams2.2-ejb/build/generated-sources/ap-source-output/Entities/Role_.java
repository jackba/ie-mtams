package Entities;

import Entities.Accountrole;
import Entities.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> idroles;
    public static volatile CollectionAttribute<Role, Permission> permissionCollection;
    public static volatile SingularAttribute<Role, String> discritption;
    public static volatile CollectionAttribute<Role, Accountrole> accountroleCollection;
    public static volatile SingularAttribute<Role, String> role;

}