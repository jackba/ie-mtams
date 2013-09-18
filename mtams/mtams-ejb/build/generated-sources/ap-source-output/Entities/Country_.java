package Entities;

import Entities.City;
import Entities.Currency;
import Entities.Region;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-20T22:02:48")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile CollectionAttribute<Country, Region> regionCollection;
    public static volatile SingularAttribute<Country, String> name;
    public static volatile SingularAttribute<Country, String> code2;
    public static volatile CollectionAttribute<Country, Currency> currencyCollection;
    public static volatile SingularAttribute<Country, Double> longitude;
    public static volatile SingularAttribute<Country, String> code3;
    public static volatile SingularAttribute<Country, Double> latitude;
    public static volatile SingularAttribute<Country, Integer> regions;
    public static volatile SingularAttribute<Country, String> url;
    public static volatile CollectionAttribute<Country, City> cityCollection;

}