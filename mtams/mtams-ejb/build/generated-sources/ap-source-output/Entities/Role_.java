package Entities;

import Entities.Accountrole;
import Entities.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-15T01:42:00")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> idroles;
    public static volatile CollectionAttribute<Role, Permission> permissionCollection;
    public static volatile SingularAttribute<Role, String> description;
    public static volatile CollectionAttribute<Role, Accountrole> accountroleCollection;
    public static volatile SingularAttribute<Role, String> role;

}