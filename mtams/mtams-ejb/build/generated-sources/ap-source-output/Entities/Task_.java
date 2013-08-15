package Entities;

import Entities.Permission;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-15T01:42:00")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile CollectionAttribute<Task, Permission> permissionCollection;
    public static volatile SingularAttribute<Task, String> task;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile SingularAttribute<Task, Integer> idtasks;

}