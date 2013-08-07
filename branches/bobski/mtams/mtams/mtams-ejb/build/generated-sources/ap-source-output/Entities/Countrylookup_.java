package Entities;

import Entities.Citylookup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-07T17:31:48")
@StaticMetamodel(Countrylookup.class)
public class Countrylookup_ { 

    public static volatile ListAttribute<Countrylookup, Citylookup> citylookupList;
    public static volatile SingularAttribute<Countrylookup, String> continent;
    public static volatile SingularAttribute<Countrylookup, Integer> idcountrylookup;
    public static volatile SingularAttribute<Countrylookup, String> country;

}