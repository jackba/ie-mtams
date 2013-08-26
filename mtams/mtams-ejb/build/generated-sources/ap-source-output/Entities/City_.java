package Entities;

import Entities.Country;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-20T22:02:48")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, String> region;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SingularAttribute<City, Country> code2;
    public static volatile SingularAttribute<City, Double> longitude;
    public static volatile SingularAttribute<City, Integer> idcity;
    public static volatile SingularAttribute<City, Double> latitude;
    public static volatile SingularAttribute<City, String> url;

}