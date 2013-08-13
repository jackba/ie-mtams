package Entities;

import Entities.CitylookupPK;
import Entities.Countrylookup;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-12T21:17:10")
@StaticMetamodel(Citylookup.class)
public class Citylookup_ { 

    public static volatile SingularAttribute<Citylookup, CitylookupPK> citylookupPK;
    public static volatile SingularAttribute<Citylookup, String> region;
    public static volatile SingularAttribute<Citylookup, Countrylookup> countrylookup;
    public static volatile SingularAttribute<Citylookup, String> city;

}