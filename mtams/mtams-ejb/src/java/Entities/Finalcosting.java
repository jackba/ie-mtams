/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "FINALCOSTING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finalcosting.findAll", query = "SELECT f FROM Finalcosting f"),
    @NamedQuery(name = "Finalcosting.findByIdfinalcosting", query = "SELECT f FROM Finalcosting f WHERE f.idfinalcosting = :idfinalcosting"),
    @NamedQuery(name = "Finalcosting.findByName", query = "SELECT f FROM Finalcosting f WHERE f.name = :name"),
    @NamedQuery(name = "Finalcosting.findByAdministrativeunit", query = "SELECT f FROM Finalcosting f WHERE f.administrativeunit = :administrativeunit"),
    @NamedQuery(name = "Finalcosting.findByAbsencebussiness", query = "SELECT f FROM Finalcosting f WHERE f.absencebussiness = :absencebussiness"),
    @NamedQuery(name = "Finalcosting.findByAbsenceprivate", query = "SELECT f FROM Finalcosting f WHERE f.absenceprivate = :absenceprivate"),
    @NamedQuery(name = "Finalcosting.findByCountries", query = "SELECT f FROM Finalcosting f WHERE f.countries = :countries"),
    @NamedQuery(name = "Finalcosting.findByCitys", query = "SELECT f FROM Finalcosting f WHERE f.citys = :citys"),
    @NamedQuery(name = "Finalcosting.findByCurrency", query = "SELECT f FROM Finalcosting f WHERE f.currency = :currency"),
    @NamedQuery(name = "Finalcosting.findByChecks", query = "SELECT f FROM Finalcosting f WHERE f.checks = :checks"),
    @NamedQuery(name = "Finalcosting.findByAirfarebudget", query = "SELECT f FROM Finalcosting f WHERE f.airfarebudget = :airfarebudget"),
    @NamedQuery(name = "Finalcosting.findByAirfarecost", query = "SELECT f FROM Finalcosting f WHERE f.airfarecost = :airfarecost"),
    @NamedQuery(name = "Finalcosting.findByCarrentalbudget", query = "SELECT f FROM Finalcosting f WHERE f.carrentalbudget = :carrentalbudget"),
    @NamedQuery(name = "Finalcosting.findByCarrentalcost", query = "SELECT f FROM Finalcosting f WHERE f.carrentalcost = :carrentalcost"),
    @NamedQuery(name = "Finalcosting.findByAccommodationbudget", query = "SELECT f FROM Finalcosting f WHERE f.accommodationbudget = :accommodationbudget"),
    @NamedQuery(name = "Finalcosting.findByAccommodationcost", query = "SELECT f FROM Finalcosting f WHERE f.accommodationcost = :accommodationcost"),
    @NamedQuery(name = "Finalcosting.findByAccommodatedays", query = "SELECT f FROM Finalcosting f WHERE f.accommodatedays = :accommodatedays"),
    @NamedQuery(name = "Finalcosting.findByPerdiembudget", query = "SELECT f FROM Finalcosting f WHERE f.perdiembudget = :perdiembudget"),
    @NamedQuery(name = "Finalcosting.findByPerdiemcost", query = "SELECT f FROM Finalcosting f WHERE f.perdiemcost = :perdiemcost"),
    @NamedQuery(name = "Finalcosting.findByPerdiemdays", query = "SELECT f FROM Finalcosting f WHERE f.perdiemdays = :perdiemdays"),
    @NamedQuery(name = "Finalcosting.findByConferencebudget", query = "SELECT f FROM Finalcosting f WHERE f.conferencebudget = :conferencebudget"),
    @NamedQuery(name = "Finalcosting.findByConferencecost", query = "SELECT f FROM Finalcosting f WHERE f.conferencecost = :conferencecost"),
    @NamedQuery(name = "Finalcosting.findByVisabudget", query = "SELECT f FROM Finalcosting f WHERE f.visabudget = :visabudget"),
    @NamedQuery(name = "Finalcosting.findByVisacost", query = "SELECT f FROM Finalcosting f WHERE f.visacost = :visacost"),
    @NamedQuery(name = "Finalcosting.findByOtherbudget", query = "SELECT f FROM Finalcosting f WHERE f.otherbudget = :otherbudget"),
    @NamedQuery(name = "Finalcosting.findByOthercost", query = "SELECT f FROM Finalcosting f WHERE f.othercost = :othercost"),
    @NamedQuery(name = "Finalcosting.findByOtherdiscription", query = "SELECT f FROM Finalcosting f WHERE f.otherdiscription = :otherdiscription"),
    @NamedQuery(name = "Finalcosting.findByApprovedbudget", query = "SELECT f FROM Finalcosting f WHERE f.approvedbudget = :approvedbudget"),
    @NamedQuery(name = "Finalcosting.findByApprovedcost", query = "SELECT f FROM Finalcosting f WHERE f.approvedcost = :approvedcost"),
    @NamedQuery(name = "Finalcosting.findByFromoz", query = "SELECT f FROM Finalcosting f WHERE f.fromoz = :fromoz"),
    @NamedQuery(name = "Finalcosting.findByOzname", query = "SELECT f FROM Finalcosting f WHERE f.ozname = :ozname"),
    @NamedQuery(name = "Finalcosting.findByOztel", query = "SELECT f FROM Finalcosting f WHERE f.oztel = :oztel"),
    @NamedQuery(name = "Finalcosting.findByOzemail", query = "SELECT f FROM Finalcosting f WHERE f.ozemail = :ozemail")})
public class Finalcosting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFINALCOSTING")
    private Integer idfinalcosting;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    @Size(max = 45)
    @Column(name = "ADMINISTRATIVEUNIT")
    private String administrativeunit;
    @Column(name = "ABSENCEBUSSINESS")
    private Integer absencebussiness;
    @Column(name = "ABSENCEPRIVATE")
    private Integer absenceprivate;
    @Size(max = 45)
    @Column(name = "COUNTRIES")
    private String countries;
    @Size(max = 45)
    @Column(name = "CITYS")
    private String citys;
    @Size(max = 45)
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "CHECKS")
    private Integer checks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AIRFAREBUDGET")
    private Double airfarebudget;
    @Column(name = "AIRFARECOST")
    private Double airfarecost;
    @Column(name = "CARRENTALBUDGET")
    private Double carrentalbudget;
    @Column(name = "CARRENTALCOST")
    private Double carrentalcost;
    @Column(name = "ACCOMMODATIONBUDGET")
    private Double accommodationbudget;
    @Column(name = "ACCOMMODATIONCOST")
    private Double accommodationcost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOMMODATEDAYS")
    private int accommodatedays;
    @Column(name = "PERDIEMBUDGET")
    private Double perdiembudget;
    @Column(name = "PERDIEMCOST")
    private Double perdiemcost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERDIEMDAYS")
    private int perdiemdays;
    @Column(name = "CONFERENCEBUDGET")
    private Double conferencebudget;
    @Column(name = "CONFERENCECOST")
    private Double conferencecost;
    @Column(name = "VISABUDGET")
    private Double visabudget;
    @Column(name = "VISACOST")
    private Double visacost;
    @Column(name = "OTHERBUDGET")
    private Double otherbudget;
    @Column(name = "OTHERCOST")
    private Double othercost;
    @Size(max = 200)
    @Column(name = "OTHERDISCRIPTION")
    private String otherdiscription;
    @Column(name = "APPROVEDBUDGET")
    private Double approvedbudget;
    @Column(name = "APPROVEDCOST")
    private Double approvedcost;
    @Column(name = "FROMOZ")
    private Integer fromoz;
    @Size(max = 45)
    @Column(name = "OZNAME")
    private String ozname;
    @Size(max = 45)
    @Column(name = "OZTEL")
    private String oztel;
    @Size(max = 45)
    @Column(name = "OZEMAIL")
    private String ozemail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finalcostingIdfinalcosting")
    private Collection<Application> applicationCollection;
    @JoinColumn(name = "QUOTES_IDQUOTES", referencedColumnName = "IDQUOTES")
    @ManyToOne(optional = false)
    private Quotes quotesIdquotes;
    @OneToMany(mappedBy = "finalcostingIdfinalcosting")
    private Collection<Attachement> attachementCollection;

    public Finalcosting() {
    }

    public Finalcosting(Integer idfinalcosting) {
        this.idfinalcosting = idfinalcosting;
    }

    public Finalcosting(Integer idfinalcosting, int accommodatedays, int perdiemdays) {
        this.idfinalcosting = idfinalcosting;
        this.accommodatedays = accommodatedays;
        this.perdiemdays = perdiemdays;
    }

    public Integer getIdfinalcosting() {
        return idfinalcosting;
    }

    public void setIdfinalcosting(Integer idfinalcosting) {
        this.idfinalcosting = idfinalcosting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdministrativeunit() {
        return administrativeunit;
    }

    public void setAdministrativeunit(String administrativeunit) {
        this.administrativeunit = administrativeunit;
    }

    public Integer getAbsencebussiness() {
        return absencebussiness;
    }

    public void setAbsencebussiness(Integer absencebussiness) {
        this.absencebussiness = absencebussiness;
    }

    public Integer getAbsenceprivate() {
        return absenceprivate;
    }

    public void setAbsenceprivate(Integer absenceprivate) {
        this.absenceprivate = absenceprivate;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCitys() {
        return citys;
    }

    public void setCitys(String citys) {
        this.citys = citys;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getChecks() {
        return checks;
    }

    public void setChecks(Integer checks) {
        this.checks = checks;
    }

    public Double getAirfarebudget() {
        return airfarebudget;
    }

    public void setAirfarebudget(Double airfarebudget) {
        this.airfarebudget = airfarebudget;
    }

    public Double getAirfarecost() {
        return airfarecost;
    }

    public void setAirfarecost(Double airfarecost) {
        this.airfarecost = airfarecost;
    }

    public Double getCarrentalbudget() {
        return carrentalbudget;
    }

    public void setCarrentalbudget(Double carrentalbudget) {
        this.carrentalbudget = carrentalbudget;
    }

    public Double getCarrentalcost() {
        return carrentalcost;
    }

    public void setCarrentalcost(Double carrentalcost) {
        this.carrentalcost = carrentalcost;
    }

    public Double getAccommodationbudget() {
        return accommodationbudget;
    }

    public void setAccommodationbudget(Double accommodationbudget) {
        this.accommodationbudget = accommodationbudget;
    }

    public Double getAccommodationcost() {
        return accommodationcost;
    }

    public void setAccommodationcost(Double accommodationcost) {
        this.accommodationcost = accommodationcost;
    }

    public int getAccommodatedays() {
        return accommodatedays;
    }

    public void setAccommodatedays(int accommodatedays) {
        this.accommodatedays = accommodatedays;
    }

    public Double getPerdiembudget() {
        return perdiembudget;
    }

    public void setPerdiembudget(Double perdiembudget) {
        this.perdiembudget = perdiembudget;
    }

    public Double getPerdiemcost() {
        return perdiemcost;
    }

    public void setPerdiemcost(Double perdiemcost) {
        this.perdiemcost = perdiemcost;
    }

    public int getPerdiemdays() {
        return perdiemdays;
    }

    public void setPerdiemdays(int perdiemdays) {
        this.perdiemdays = perdiemdays;
    }

    public Double getConferencebudget() {
        return conferencebudget;
    }

    public void setConferencebudget(Double conferencebudget) {
        this.conferencebudget = conferencebudget;
    }

    public Double getConferencecost() {
        return conferencecost;
    }

    public void setConferencecost(Double conferencecost) {
        this.conferencecost = conferencecost;
    }

    public Double getVisabudget() {
        return visabudget;
    }

    public void setVisabudget(Double visabudget) {
        this.visabudget = visabudget;
    }

    public Double getVisacost() {
        return visacost;
    }

    public void setVisacost(Double visacost) {
        this.visacost = visacost;
    }

    public Double getOtherbudget() {
        return otherbudget;
    }

    public void setOtherbudget(Double otherbudget) {
        this.otherbudget = otherbudget;
    }

    public Double getOthercost() {
        return othercost;
    }

    public void setOthercost(Double othercost) {
        this.othercost = othercost;
    }

    public String getOtherdiscription() {
        return otherdiscription;
    }

    public void setOtherdiscription(String otherdiscription) {
        this.otherdiscription = otherdiscription;
    }

    public Double getApprovedbudget() {
        return approvedbudget;
    }

    public void setApprovedbudget(Double approvedbudget) {
        this.approvedbudget = approvedbudget;
    }

    public Double getApprovedcost() {
        return approvedcost;
    }

    public void setApprovedcost(Double approvedcost) {
        this.approvedcost = approvedcost;
    }

    public Integer getFromoz() {
        return fromoz;
    }

    public void setFromoz(Integer fromoz) {
        this.fromoz = fromoz;
    }

    public String getOzname() {
        return ozname;
    }

    public void setOzname(String ozname) {
        this.ozname = ozname;
    }

    public String getOztel() {
        return oztel;
    }

    public void setOztel(String oztel) {
        this.oztel = oztel;
    }

    public String getOzemail() {
        return ozemail;
    }

    public void setOzemail(String ozemail) {
        this.ozemail = ozemail;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    public Quotes getQuotesIdquotes() {
        return quotesIdquotes;
    }

    public void setQuotesIdquotes(Quotes quotesIdquotes) {
        this.quotesIdquotes = quotesIdquotes;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinalcosting != null ? idfinalcosting.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finalcosting)) {
            return false;
        }
        Finalcosting other = (Finalcosting) object;
        if ((this.idfinalcosting == null && other.idfinalcosting != null) || (this.idfinalcosting != null && !this.idfinalcosting.equals(other.idfinalcosting))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Finalcosting[ idfinalcosting=" + idfinalcosting + " ]";
    }
    
}
