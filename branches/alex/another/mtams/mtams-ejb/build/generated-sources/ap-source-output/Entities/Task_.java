package Entities;

import Entities.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-12T21:17:10")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, String> task;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile ListAttribute<Task, Permission> permissionList;
    public static volatile SingularAttribute<Task, Integer> idtasks;

}