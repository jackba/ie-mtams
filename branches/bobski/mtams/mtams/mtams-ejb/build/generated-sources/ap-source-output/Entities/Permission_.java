package Entities;

import Entities.Role;
import Entities.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-19T19:35:40")
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