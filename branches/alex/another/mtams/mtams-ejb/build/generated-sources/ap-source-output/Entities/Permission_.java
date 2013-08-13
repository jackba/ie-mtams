package Entities;

import Entities.Role;
import Entities.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-12T21:17:10")
@StaticMetamodel(Permission.class)
public class Permission_ { 

    public static volatile SingularAttribute<Permission, Integer> idpermissions;
    public static volatile SingularAttribute<Permission, Short> readperm;
    public static volatile SingularAttribute<Permission, Short> deleteperm;
    public static volatile SingularAttribute<Permission, Short> updateperm;
    public static volatile SingularAttribute<Permission, String> description;
    public static volatile SingularAttribute<Permission, Short> createperm;
    public static volatile SingularAttribute<Permission, String> permission;
    public static volatile SingularAttribute<Permission, Short> grantperm;
    public static volatile SingularAttribute<Permission, Task> tasksIdtasks;
    public static volatile SingularAttribute<Permission, Role> rolesIdroles;

}