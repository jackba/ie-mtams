package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-14T23:52:40")
@StaticMetamodel(Carquotes.class)
public class Carquotes_ { 

    public static volatile SingularAttribute<Carquotes, Integer> idcarquotes;
    public static volatile SingularAttribute<Carquotes, String> description;
    public static volatile SingularAttribute<Carquotes, String> quotecost;
    public static volatile SingularAttribute<Carquotes, Date> datecollect;
    public static volatile SingularAttribute<Carquotes, Date> datereturn;
    public static volatile SingularAttribute<Carquotes, String> provider;
    public static volatile SingularAttribute<Carquotes, Quotes> quotesIdquotes;
    public static volatile CollectionAttribute<Carquotes, Attachement> attachementCollection;

}