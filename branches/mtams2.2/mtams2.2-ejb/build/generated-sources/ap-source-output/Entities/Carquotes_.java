package Entities;

import Entities.Attachement;
import Entities.Quotes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-02T16:13:42")
@StaticMetamodel(Carquotes.class)
public class Carquotes_ { 

    public static volatile SingularAttribute<Carquotes, String> discritption;
    public static volatile SingularAttribute<Carquotes, Integer> idcarquotes;
    public static volatile SingularAttribute<Carquotes, String> quotecost;
    public static volatile SingularAttribute<Carquotes, Date> datecollect;
    public static volatile SingularAttribute<Carquotes, Date> datereturn;
    public static volatile SingularAttribute<Carquotes, String> provider;
    public static volatile SingularAttribute<Carquotes, Quotes> quotesIdquotes;
    public static volatile CollectionAttribute<Carquotes, Attachement> attachementCollection;

}