package Entities;

import Entities.Citylookup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Countrylookup.class)
public class Countrylookup_ { 

    public static volatile CollectionAttribute<Countrylookup, Citylookup> citylookupCollection;
    public static volatile SingularAttribute<Countrylookup, Integer> idcountrylookup;
    public static volatile SingularAttribute<Countrylookup, String> country;

}