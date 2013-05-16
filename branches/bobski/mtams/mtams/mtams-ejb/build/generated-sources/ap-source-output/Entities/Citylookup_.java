package Entities;

import Entities.CitylookupPK;
import Entities.Countrylookup;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-16T11:13:59")
@StaticMetamodel(Citylookup.class)
public class Citylookup_ { 

    public static volatile SingularAttribute<Citylookup, CitylookupPK> citylookupPK;
    public static volatile SingularAttribute<Citylookup, String> region;
    public static volatile SingularAttribute<Citylookup, Countrylookup> countrylookup;
    public static volatile SingularAttribute<Citylookup, String> city;

}