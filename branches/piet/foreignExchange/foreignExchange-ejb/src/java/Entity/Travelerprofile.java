/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "TRAVELERPROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travelerprofile.findAll", query = "SELECT t FROM Travelerprofile t"),
    @NamedQuery(name = "Travelerprofile.findByIdtravelerprofile", query = "SELECT t FROM Travelerprofile t WHERE t.idtravelerprofile = :idtravelerprofile"),
    @NamedQuery(name = "Travelerprofile.findByStaffid", query = "SELECT t FROM Travelerprofile t WHERE t.staffid = :staffid"),
    @NamedQuery(name = "Travelerprofile.findByGivenname", query = "SELECT t FROM Travelerprofile t WHERE t.givenname = :givenname"),
    @NamedQuery(name = "Travelerprofile.findByFamilyname", query = "SELECT t FROM Travelerprofile t WHERE t.familyname = :familyname"),
    @NamedQuery(name = "Travelerprofile.findByTitle", query = "SELECT t FROM Travelerprofile t WHERE t.title = :title"),
    @NamedQuery(name = "Travelerprofile.findByDepartment", query = "SELECT t FROM Travelerprofile t WHERE t.department = :department"),
    @NamedQuery(name = "Travelerprofile.findByPosition", query = "SELECT t FROM Travelerprofile t WHERE t.position = :position"),
    @NamedQuery(name = "Travelerprofile.findByIdnumber", query = "SELECT t FROM Travelerprofile t WHERE t.idnumber = :idnumber"),
    @NamedQuery(name = "Travelerprofile.findByAttachmentid", query = "SELECT t FROM Travelerprofile t WHERE t.attachmentid = :attachmentid"),
    @NamedQuery(name = "Travelerprofile.findByDatecreated", query = "SELECT t FROM Travelerprofile t WHERE t.datecreated = :datecreated"),
    @NamedQuery(name = "Travelerprofile.findByDatemodified", query = "SELECT t FROM Travelerprofile t WHERE t.datemodified = :datemodified"),
    @NamedQuery(name = "Travelerprofile.findByTravelbooker", query = "SELECT t FROM Travelerprofile t WHERE t.travelbooker = :travelbooker"),
    @NamedQuery(name = "Travelerprofile.findByBusinessaddress", query = "SELECT t FROM Travelerprofile t WHERE t.businessaddress = :businessaddress"),
    @NamedQuery(name = "Travelerprofile.findByBusinessphone", query = "SELECT t FROM Travelerprofile t WHERE t.businessphone = :businessphone"),
    @NamedQuery(name = "Travelerprofile.findByBusinessfax", query = "SELECT t FROM Travelerprofile t WHERE t.businessfax = :businessfax"),
    @NamedQuery(name = "Travelerprofile.findByBusinessemail", query = "SELECT t FROM Travelerprofile t WHERE t.businessemail = :businessemail"),
    @NamedQuery(name = "Travelerprofile.findByHomeaddress", query = "SELECT t FROM Travelerprofile t WHERE t.homeaddress = :homeaddress"),
    @NamedQuery(name = "Travelerprofile.findByHomephone", query = "SELECT t FROM Travelerprofile t WHERE t.homephone = :homephone"),
    @NamedQuery(name = "Travelerprofile.findByHomeemail", query = "SELECT t FROM Travelerprofile t WHERE t.homeemail = :homeemail"),
    @NamedQuery(name = "Travelerprofile.findByMobilephone", query = "SELECT t FROM Travelerprofile t WHERE t.mobilephone = :mobilephone"),
    @NamedQuery(name = "Travelerprofile.findBySpousename", query = "SELECT t FROM Travelerprofile t WHERE t.spousename = :spousename"),
    @NamedQuery(name = "Travelerprofile.findBySpousecontactnumber", query = "SELECT t FROM Travelerprofile t WHERE t.spousecontactnumber = :spousecontactnumber"),
    @NamedQuery(name = "Travelerprofile.findBySpouseemail", query = "SELECT t FROM Travelerprofile t WHERE t.spouseemail = :spouseemail"),
    @NamedQuery(name = "Travelerprofile.findByDoctorsname", query = "SELECT t FROM Travelerprofile t WHERE t.doctorsname = :doctorsname"),
    @NamedQuery(name = "Travelerprofile.findByDoctorsconctactnumber", query = "SELECT t FROM Travelerprofile t WHERE t.doctorsconctactnumber = :doctorsconctactnumber"),
    @NamedQuery(name = "Travelerprofile.findByDoctorsemail", query = "SELECT t FROM Travelerprofile t WHERE t.doctorsemail = :doctorsemail"),
    @NamedQuery(name = "Travelerprofile.findByKnownmedicalconditions", query = "SELECT t FROM Travelerprofile t WHERE t.knownmedicalconditions = :knownmedicalconditions"),
    @NamedQuery(name = "Travelerprofile.findByHotelprefrences", query = "SELECT t FROM Travelerprofile t WHERE t.hotelprefrences = :hotelprefrences"),
    @NamedQuery(name = "Travelerprofile.findByFrequentguest", query = "SELECT t FROM Travelerprofile t WHERE t.frequentguest = :frequentguest"),
    @NamedQuery(name = "Travelerprofile.findByNonsmoking", query = "SELECT t FROM Travelerprofile t WHERE t.nonsmoking = :nonsmoking"),
    @NamedQuery(name = "Travelerprofile.findByCarpreferences", query = "SELECT t FROM Travelerprofile t WHERE t.carpreferences = :carpreferences"),
    @NamedQuery(name = "Travelerprofile.findByRentalcompany", query = "SELECT t FROM Travelerprofile t WHERE t.rentalcompany = :rentalcompany"),
    @NamedQuery(name = "Travelerprofile.findByManualautomatic", query = "SELECT t FROM Travelerprofile t WHERE t.manualautomatic = :manualautomatic"),
    @NamedQuery(name = "Travelerprofile.findByAircon", query = "SELECT t FROM Travelerprofile t WHERE t.aircon = :aircon"),
    @NamedQuery(name = "Travelerprofile.findByAirlinepreferences", query = "SELECT t FROM Travelerprofile t WHERE t.airlinepreferences = :airlinepreferences"),
    @NamedQuery(name = "Travelerprofile.findBySeating", query = "SELECT t FROM Travelerprofile t WHERE t.seating = :seating"),
    @NamedQuery(name = "Travelerprofile.findByClassdomestic", query = "SELECT t FROM Travelerprofile t WHERE t.classdomestic = :classdomestic"),
    @NamedQuery(name = "Travelerprofile.findByClassinternational", query = "SELECT t FROM Travelerprofile t WHERE t.classinternational = :classinternational"),
    @NamedQuery(name = "Travelerprofile.findByMealrequirements", query = "SELECT t FROM Travelerprofile t WHERE t.mealrequirements = :mealrequirements")})
public class Travelerprofile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRAVELERPROFILE")
    private Integer idtravelerprofile;
    @Size(max = 45)
    @Column(name = "STAFFID")
    private String staffid;
    @Size(max = 45)
    @Column(name = "GIVENNAME")
    private String givenname;
    @Size(max = 45)
    @Column(name = "FAMILYNAME")
    private String familyname;
    @Size(max = 45)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 45)
    @Column(name = "DEPARTMENT")
    private String department;
    @Size(max = 45)
    @Column(name = "POSITION")
    private String position;
    @Size(max = 10)
    @Column(name = "IDNUMBER")
    private String idnumber;
    @Size(max = 45)
    @Column(name = "ATTACHMENTID")
    private String attachmentid;
    @Column(name = "DATECREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "DATEMODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodified;
    @Size(max = 45)
    @Column(name = "TRAVELBOOKER")
    private String travelbooker;
    @Size(max = 255)
    @Column(name = "BUSINESSADDRESS")
    private String businessaddress;
    @Size(max = 12)
    @Column(name = "BUSINESSPHONE")
    private String businessphone;
    @Size(max = 12)
    @Column(name = "BUSINESSFAX")
    private String businessfax;
    @Size(max = 45)
    @Column(name = "BUSINESSEMAIL")
    private String businessemail;
    @Size(max = 255)
    @Column(name = "HOMEADDRESS")
    private String homeaddress;
    @Size(max = 12)
    @Column(name = "HOMEPHONE")
    private String homephone;
    @Size(max = 45)
    @Column(name = "HOMEEMAIL")
    private String homeemail;
    @Size(max = 12)
    @Column(name = "MOBILEPHONE")
    private String mobilephone;
    @Size(max = 45)
    @Column(name = "SPOUSENAME")
    private String spousename;
    @Size(max = 45)
    @Column(name = "SPOUSECONTACTNUMBER")
    private String spousecontactnumber;
    @Size(max = 45)
    @Column(name = "SPOUSEEMAIL")
    private String spouseemail;
    @Size(max = 45)
    @Column(name = "DOCTORSNAME")
    private String doctorsname;
    @Size(max = 45)
    @Column(name = "DOCTORSCONCTACTNUMBER")
    private String doctorsconctactnumber;
    @Size(max = 45)
    @Column(name = "DOCTORSEMAIL")
    private String doctorsemail;
    @Size(max = 512)
    @Column(name = "KNOWNMEDICALCONDITIONS")
    private String knownmedicalconditions;
    @Size(max = 200)
    @Column(name = "HOTELPREFRENCES")
    private String hotelprefrences;
    @Size(max = 45)
    @Column(name = "FREQUENTGUEST")
    private String frequentguest;
    @Size(max = 45)
    @Column(name = "NONSMOKING")
    private String nonsmoking;
    @Size(max = 200)
    @Column(name = "CARPREFERENCES")
    private String carpreferences;
    @Size(max = 45)
    @Column(name = "RENTALCOMPANY")
    private String rentalcompany;
    @Size(max = 45)
    @Column(name = "MANUALAUTOMATIC")
    private String manualautomatic;
    @Size(max = 45)
    @Column(name = "AIRCON")
    private String aircon;
    @Size(max = 45)
    @Column(name = "AIRLINEPREFERENCES")
    private String airlinepreferences;
    @Size(max = 45)
    @Column(name = "SEATING")
    private String seating;
    @Size(max = 45)
    @Column(name = "CLASSDOMESTIC")
    private String classdomestic;
    @Size(max = 45)
    @Column(name = "CLASSINTERNATIONAL")
    private String classinternational;
    @Size(max = 45)
    @Column(name = "MEALREQUIREMENTS")
    private String mealrequirements;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelerprofileIdtravelerprofile")
    private Collection<Rewardsprogram> rewardsprogramCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelerprofileIdtravelerprofile")
    private Collection<Application> applicationCollection;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "IDACCOUNT")
    @ManyToOne(optional = false)
    private Account accountid;
    @OneToMany(mappedBy = "travelerprofileIdtravelerprofile")
    private Collection<Attachement> attachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travlerprofileIdtravlerprofile")
    private Collection<Traveldocument> traveldocumentCollection;

    public Travelerprofile() {
    }

    public Travelerprofile(Integer idtravelerprofile) {
        this.idtravelerprofile = idtravelerprofile;
    }

    public Integer getIdtravelerprofile() {
        return idtravelerprofile;
    }

    public void setIdtravelerprofile(Integer idtravelerprofile) {
        this.idtravelerprofile = idtravelerprofile;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAttachmentid() {
        return attachmentid;
    }

    public void setAttachmentid(String attachmentid) {
        this.attachmentid = attachmentid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(Date datemodified) {
        this.datemodified = datemodified;
    }

    public String getTravelbooker() {
        return travelbooker;
    }

    public void setTravelbooker(String travelbooker) {
        this.travelbooker = travelbooker;
    }

    public String getBusinessaddress() {
        return businessaddress;
    }

    public void setBusinessaddress(String businessaddress) {
        this.businessaddress = businessaddress;
    }

    public String getBusinessphone() {
        return businessphone;
    }

    public void setBusinessphone(String businessphone) {
        this.businessphone = businessphone;
    }

    public String getBusinessfax() {
        return businessfax;
    }

    public void setBusinessfax(String businessfax) {
        this.businessfax = businessfax;
    }

    public String getBusinessemail() {
        return businessemail;
    }

    public void setBusinessemail(String businessemail) {
        this.businessemail = businessemail;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getHomeemail() {
        return homeemail;
    }

    public void setHomeemail(String homeemail) {
        this.homeemail = homeemail;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getSpousename() {
        return spousename;
    }

    public void setSpousename(String spousename) {
        this.spousename = spousename;
    }

    public String getSpousecontactnumber() {
        return spousecontactnumber;
    }

    public void setSpousecontactnumber(String spousecontactnumber) {
        this.spousecontactnumber = spousecontactnumber;
    }

    public String getSpouseemail() {
        return spouseemail;
    }

    public void setSpouseemail(String spouseemail) {
        this.spouseemail = spouseemail;
    }

    public String getDoctorsname() {
        return doctorsname;
    }

    public void setDoctorsname(String doctorsname) {
        this.doctorsname = doctorsname;
    }

    public String getDoctorsconctactnumber() {
        return doctorsconctactnumber;
    }

    public void setDoctorsconctactnumber(String doctorsconctactnumber) {
        this.doctorsconctactnumber = doctorsconctactnumber;
    }

    public String getDoctorsemail() {
        return doctorsemail;
    }

    public void setDoctorsemail(String doctorsemail) {
        this.doctorsemail = doctorsemail;
    }

    public String getKnownmedicalconditions() {
        return knownmedicalconditions;
    }

    public void setKnownmedicalconditions(String knownmedicalconditions) {
        this.knownmedicalconditions = knownmedicalconditions;
    }

    public String getHotelprefrences() {
        return hotelprefrences;
    }

    public void setHotelprefrences(String hotelprefrences) {
        this.hotelprefrences = hotelprefrences;
    }

    public String getFrequentguest() {
        return frequentguest;
    }

    public void setFrequentguest(String frequentguest) {
        this.frequentguest = frequentguest;
    }

    public String getNonsmoking() {
        return nonsmoking;
    }

    public void setNonsmoking(String nonsmoking) {
        this.nonsmoking = nonsmoking;
    }

    public String getCarpreferences() {
        return carpreferences;
    }

    public void setCarpreferences(String carpreferences) {
        this.carpreferences = carpreferences;
    }

    public String getRentalcompany() {
        return rentalcompany;
    }

    public void setRentalcompany(String rentalcompany) {
        this.rentalcompany = rentalcompany;
    }

    public String getManualautomatic() {
        return manualautomatic;
    }

    public void setManualautomatic(String manualautomatic) {
        this.manualautomatic = manualautomatic;
    }

    public String getAircon() {
        return aircon;
    }

    public void setAircon(String aircon) {
        this.aircon = aircon;
    }

    public String getAirlinepreferences() {
        return airlinepreferences;
    }

    public void setAirlinepreferences(String airlinepreferences) {
        this.airlinepreferences = airlinepreferences;
    }

    public String getSeating() {
        return seating;
    }

    public void setSeating(String seating) {
        this.seating = seating;
    }

    public String getClassdomestic() {
        return classdomestic;
    }

    public void setClassdomestic(String classdomestic) {
        this.classdomestic = classdomestic;
    }

    public String getClassinternational() {
        return classinternational;
    }

    public void setClassinternational(String classinternational) {
        this.classinternational = classinternational;
    }

    public String getMealrequirements() {
        return mealrequirements;
    }

    public void setMealrequirements(String mealrequirements) {
        this.mealrequirements = mealrequirements;
    }

    @XmlTransient
    public Collection<Rewardsprogram> getRewardsprogramCollection() {
        return rewardsprogramCollection;
    }

    public void setRewardsprogramCollection(Collection<Rewardsprogram> rewardsprogramCollection) {
        this.rewardsprogramCollection = rewardsprogramCollection;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Traveldocument> getTraveldocumentCollection() {
        return traveldocumentCollection;
    }

    public void setTraveldocumentCollection(Collection<Traveldocument> traveldocumentCollection) {
        this.traveldocumentCollection = traveldocumentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtravelerprofile != null ? idtravelerprofile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travelerprofile)) {
            return false;
        }
        Travelerprofile other = (Travelerprofile) object;
        if ((this.idtravelerprofile == null && other.idtravelerprofile != null) || (this.idtravelerprofile != null && !this.idtravelerprofile.equals(other.idtravelerprofile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Travelerprofile[ idtravelerprofile=" + idtravelerprofile + " ]";
    }
    
}
