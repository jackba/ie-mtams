package Entities;

import Entities.Citylookup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-08-03T20:41:29")
@StaticMetamodel(Countrylookup.class)
public class Countrylookup_ { 

    public static volatile ListAttribute<Countrylookup, Citylookup> citylookupList;
    public static volatile SingularAttribute<Countrylookup, String> continent;
    public static volatile SingularAttribute<Countrylookup, Integer> idcountrylookup;
    public static volatile SingularAttribute<Countrylookup, String> country;

}