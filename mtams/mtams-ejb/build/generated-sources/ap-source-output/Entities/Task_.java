package Entities;

import Entities.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-19T17:49:03")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, String> task;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile ListAttribute<Task, Permission> permissionList;
    public static volatile SingularAttribute<Task, Integer> idtasks;

}