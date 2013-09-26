/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.City;
import Entities.Country;
import Entities.Currency;
import Entities.Department;
import Entities.Leavelookup;
import Entities.Position;
import Entities.Region;
import Entities.Title;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import ServiceLayer.DataLookUpHandlerLocal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author aaron
 */
@Named(value = "dataLookUpBean")
//@ConversationScoped
@SessionScoped
//@ViewScoped
//@RequestScoped
public class DataLookUpBean implements Serializable {

    //testing
    //private CurrencyNames_en_GB javaCurrency;
    @EJB
    private DataLookUpHandlerLocal daoDataLookUp;
    private static final Logger logger = Logger.getLogger(DataLookUpBean.class.getName());
    //private TitleFacadeLocal doaTitle;
    // Title lookup vars
    private int titleCount;
    private Title aTitleRef;
    private String titleString;
    private List<Title> titleList;
    private List<String> titleStrings;
    //position lookup vars
    private int positionCount;
    private Position aPositionRef;
    private String positionString;
    private List<Position> positionList;
    private List<String> positionStrings;
    // Leave lookup vars
    private int leaveCount;
    private Leavelookup aLeaveRef;
    private String leaveString;
    private List<Leavelookup> leaveList;
    private List<String> leaveStrings;
    // Department lookup vars
    private int departmentCount;
    private Department aDepartmentRef;
    private String departmentString;
    private List<Department> departmentList;
    private List<String> departmentStrings;
    // Currency lookup vars
    private int currencyCount;
    //private Currency aCurrencyRef;
    private Currency CurSelect;
    //private Currency CurrencySelection;
    private String currencyString;
    private String selectedCurrencyString;
    private List<Currency> currencyList;
    private List<Currency> currencyFilteredList;
    private List<String> currencyStrings;
    //Country Region City
    private int countryCount;
    private int regionCount;
    private int cityCount;
    private List<Country> countryList;
    private List<Region> regionList;
    private List<City> cityList;
    private List<Country> countryFilteredList;
    private List<Region> regionFilteredList;
    private List<City> cityFilteredList;
    private Country CountrySelectionRef;
    private Country countryRef;
    private Region RegionySelectionRef;
    private City CitySelectionRef;
    private String countryString;
    private String regionyString;
    private String cityString;
    // passing a listner into as a parameter
    private String listner;

    //private String test = "hello world";
    //private String test;
    /**
     *
     */
    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "initialize");

        this.listner = "#{dataLookUpBean.CurSel()}";
        logger.log(Level.INFO, "this.getListner() : {0}", this.getListner());

        //this.titleCount = 10;
        //this.test = "hello world in init";

        // Title references
        this.titleCount = daoDataLookUp.getTitleCount();

        this.aTitleRef = daoDataLookUp.getTitle("pHD");
        this.titleString = aTitleRef.getTitle();

        this.titleList = new ArrayList<Title>();
        titleList.addAll(daoDataLookUp.allTitles());

        this.titleStrings = new ArrayList<String>();
        titleStrings.addAll(daoDataLookUp.allTitleStr());

        // Position References        
        this.positionCount = daoDataLookUp.getPositionCount();
        // non case sensitive search for 
        this.aPositionRef = daoDataLookUp.getPosition("Tutor");
        this.positionString = aPositionRef.getPosition();

        this.positionList = new ArrayList<Position>();
        positionList.addAll(daoDataLookUp.allPositions());

        this.positionStrings = new ArrayList<String>();
        positionStrings.addAll(daoDataLookUp.allPositionStr());

        // Leave References
        this.leaveCount = daoDataLookUp.getLeaveCount();
        // non case sensitive search for 
        this.aLeaveRef = daoDataLookUp.getLeave("sick leave");
        this.leaveString = aLeaveRef.getLeavetype();

        this.leaveList = new ArrayList<Leavelookup>();
        leaveList.addAll(daoDataLookUp.allLeaves());

        this.leaveStrings = new ArrayList<String>();
        leaveStrings.addAll(daoDataLookUp.allLeaveStr());

        // Department References
        this.departmentCount = daoDataLookUp.getDepartmentCount();
        // non case sensitive search for 
        this.aDepartmentRef = daoDataLookUp.getDepartment("finance");
        this.departmentString = aDepartmentRef.getDepartment();

        this.departmentList = new ArrayList<Department>();
        departmentList.addAll(daoDataLookUp.allDepartments());

        this.departmentStrings = new ArrayList<String>();
        departmentStrings.addAll(daoDataLookUp.allDepartmentStr());

        // Currency References
        this.currencyCount = daoDataLookUp.getCurrencyCount();
        // non case sensitive search for 
//        this.aCurrencyRef = daoDataLookUp.getCurrency("eur");
//        this.currencyString = aCurrencyRef.getCurrencycode3();
        this.setSelectedCurrencyString((null == this.getSelectedCurrencyString()) ? "" : this.getSelectedCurrencyString());

//        logger.log(Level.INFO, "CurSelect = null : {0}", CurSelect != null);
//        logger.log(Level.INFO, "CurSelect : {0}", CurSelect);
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        if (CurSelect != null) {
//            logger.log(Level.INFO, "CurSelect : {0}", true);
            this.setSelectedCurrencyString(("".equals(this.getSelectedCurrencyString())) ? this.CurSel() : this.getSelectedCurrencyString());
        } else {
//            logger.log(Level.INFO, "CurSelect : {0}", false);
//            logger.log(Level.INFO, "equals(this.getSelectedCurrencyString() : {0}", "".equals(this.getSelectedCurrencyString()))    ;
//            logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
            this.setSelectedCurrencyString("".equals(this.getSelectedCurrencyString()) ? "" : this.getSelectedCurrencyString());
        }
        //this.setSelectedCurrencyString((this.selectedCurrencyString == null) ? "test" : this.CurSel());
        logger.log(Level.INFO, "CurSelect : {0}", CurSelect);
        //logger.log(Level.INFO, "CurrencySelection.toString : {0}", CurrencySelection.toString());


        this.currencyList = new ArrayList<Currency>();
        currencyList.addAll(daoDataLookUp.allCurrency());

        this.currencyStrings = new ArrayList<String>();
        currencyStrings.addAll(daoDataLookUp.allCurrencyStr());

        this.countryCount = daoDataLookUp.getCountriesCount();
        logger.log(Level.INFO, "countryCount : {0}", countryCount);
        this.regionCount = daoDataLookUp.getRegionsCount();
        this.cityCount = daoDataLookUp.getCitiesCount();

        this.countryList = new ArrayList<Country>();
        countryList.addAll(daoDataLookUp.allCountries());
        logger.log(Level.INFO, "countryList : {0}", countryList);
        logger.log(Level.INFO, "countryList.get(1) : {0}", countryList.get(1));
        this.regionList = new ArrayList<Region>();
        this.cityList = new ArrayList<City>();

        //this.setCountryString(CountrySelectionRef.getName());
        //logger.log(Level.INFO, "CountrySelectionRef.getName() : {0}", CountrySelectionRef.getName());
//        aRegionySelection;
//        aCitySelection;

        // need to stop headers being set till dialogs are built and ajax requests
        // can be handled
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        logger.log(Level.INFO, "initialize end");
    }

    public String CurSel() {
        logger.log(Level.INFO, "CurSel");
        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        logger.log(Level.INFO, "this.getListner() : {0}", this.getListner());
//        selectedCurrencyString = CurSelect.getCurrencycode3() + ", " + CurSelect.getCountryname() + ", " + CurSelect.getCurrencyname();

        selectedCurrencyString = CurSelect.getCurrencycode3();
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        return selectedCurrencyString;
    }

    public String CRCSel() {
        logger.log(Level.INFO, "CountrySelectionRef : {0}", this.getCountrySelectionRef());
        //this.setCountryString(CountrySelectionRef.getName());
        logger.log(Level.INFO, "CountryString : {0}", this.getCountryString());
        logger.log(Level.INFO, "1 getRegionySelectionRef : {0}", getRegionySelectionRef());
        if (this.getCountrySelectionRef() != null) {
            if (getRegionList().isEmpty()) {
                setRegionList(daoDataLookUp.allRegions(this.getCountrySelectionRef()));
                logger.log(Level.INFO, "getRegionList : {0}", this.getRegionList());
                // that it is not the same country
                // don't need to rebuild the regions list if we allready have it
            } else if (!(getRegionList().get(0).getCode2().getCode2().equalsIgnoreCase(this.getCountrySelectionRef().getCode2()))) {
                setRegionList(daoDataLookUp.allRegions(this.getCountrySelectionRef()));
                logger.log(Level.INFO, "getRegionList : {0}", this.getRegionList());
            }
            logger.log(Level.INFO, "2 getRegionySelectionRef : {0}", getRegionySelectionRef());
            if (this.getRegionySelectionRef() != null) {
                logger.log(Level.INFO, "3 getRegionySelectionRef : {0}", getRegionySelectionRef());
                this.setRegionyString(this.getRegionySelectionRef().getName());
            }

        }

        return "CRC test";
    }

    public String CoutrySel() {
        logger.log(Level.INFO, "CountrySelectionRef : {0}", this.getCountrySelectionRef());
        this.setCountryString(CountrySelectionRef.getName());
        this.setRegionySelectionRef(null);
        this.setRegionyString("");
        logger.log(Level.INFO, "CountryString : {0}", this.getCountryString());
        setRegionList(daoDataLookUp.allRegions(this.getCountrySelectionRef()));
        logger.log(Level.INFO, "getRegionList : {0}", this.getRegionList());


        logger.log(Level.INFO, "this.setRegionyString(); : {0}", this.getRegionyString());

        return "RegSel test";

    }

    public String RegSel() {

        if (this.getCountrySelectionRef() != null) {

//            this.setRegionyString(this.getRegionySelectionRef().getName());
            if (this.getRegionySelectionRef() != null) {
                logger.log(Level.INFO, "3 getRegionySelectionRef : {0}", getRegionySelectionRef());
                this.setRegionyString(this.getRegionySelectionRef().getName());
                logger.log(Level.INFO, " getRegionyString : {0}", getRegionyString());
                setCityList(daoDataLookUp.getCities(RegionySelectionRef, CountrySelectionRef));
            }
        }

        return "RegSel test";

    }

    public String CitySel() {
        this.setCityString(this.getCitySelectionRef().getName());
        return "CitySel test";

    }

    public String test() {
        return "IT worked";
    }
    

    /**
     * Creates a new instance of DataLookUpBean
     */
    public DataLookUpBean() {
    }

    /**
     * *
     *
     * AUTO GENERATED Methods | VVV
     *
     */
    public DataLookUpHandlerLocal getDaoDataLookUp() {
        return daoDataLookUp;
    }

    public void setDaoDataLookUp(DataLookUpHandlerLocal daoDataLookUp) {
        this.daoDataLookUp = daoDataLookUp;
    }

    public int getTitleCount() {
        return titleCount;
    }

    public void setTitleCount(int titleCount) {
        this.titleCount = titleCount;
    }

    public Title getaTitleRef() {
        return aTitleRef;
    }

    public void setaTitleRef(Title aTitleRef) {
        this.aTitleRef = aTitleRef;
    }

    public String getTitleString() {
        return titleString;
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    public List<String> getTitleStrings() {
        return titleStrings;
    }

    public void setTitleStrings(List<String> titleStrings) {
        this.titleStrings = titleStrings;
    }

    public int getPositionCount() {
        return positionCount;
    }

    public void setPositionCount(int positionCount) {
        this.positionCount = positionCount;
    }

    public Position getaPositionRef() {
        return aPositionRef;
    }

    public void setaPositionRef(Position aPositionRef) {
        this.aPositionRef = aPositionRef;
    }

    public String getPositionString() {
        return positionString;
    }

    public void setPositionString(String positionString) {
        this.positionString = positionString;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<String> getPositionStrings() {
        return positionStrings;
    }

    public void setPositionStrings(List<String> positionStrings) {
        this.positionStrings = positionStrings;
    }

    public int getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(int leaveCount) {
        this.leaveCount = leaveCount;
    }

    public Leavelookup getaLeaveRef() {
        return aLeaveRef;
    }

    public void setaLeaveRef(Leavelookup aLeaveRef) {
        this.aLeaveRef = aLeaveRef;
    }

    public String getLeaveString() {
        return leaveString;
    }

    public void setLeaveString(String leaveString) {
        this.leaveString = leaveString;
    }

    public List<Leavelookup> getLeaveList() {
        return leaveList;
    }

    public void setLeaveList(List<Leavelookup> leaveList) {
        this.leaveList = leaveList;
    }

    public List<String> getLeaveStrings() {
        return leaveStrings;
    }

    public void setLeaveStrings(List<String> leaveStrings) {
        this.leaveStrings = leaveStrings;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

    public Department getaDepartmentRef() {
        return aDepartmentRef;
    }

    public void setaDepartmentRef(Department aDepartmentRef) {
        this.aDepartmentRef = aDepartmentRef;
    }

    public String getDepartmentString() {
        return departmentString;
    }

    public void setDepartmentString(String departmentString) {
        this.departmentString = departmentString;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<String> getDepartmentStrings() {
        return departmentStrings;
    }

    public void setDepartmentStrings(List<String> departmentStrings) {
        this.departmentStrings = departmentStrings;
    }

    public int getCurrencyCount() {
        return currencyCount;
    }

    public void setCurrencyCount(int currencyCount) {
        this.currencyCount = currencyCount;
    }

    public String getCurrencyString() {
        return currencyString;
    }

    public void setCurrencyString(String currencyString) {
        this.currencyString = currencyString;
    }

    public String getSelectedCurrencyString() {
        return selectedCurrencyString;
    }

    public void setSelectedCurrencyString(String selectedCurrencyString) {
        this.selectedCurrencyString = selectedCurrencyString;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public List<Currency> getCurrencyFilteredList() {
        return currencyFilteredList;
    }

    public void setCurrencyFilteredList(List<Currency> currencyFilteredList) {
        this.currencyFilteredList = currencyFilteredList;
    }

    public List<String> getCurrencyStrings() {
        return currencyStrings;
    }

    public void setCurrencyStrings(List<String> currencyStrings) {
        this.currencyStrings = currencyStrings;
    }

    public int getCountryCount() {
        return countryCount;
    }

    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }

    public int getRegionCount() {
        return regionCount;
    }

    public void setRegionCount(int regionCount) {
        this.regionCount = regionCount;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<Country> getCountryFilteredList() {
        return countryFilteredList;
    }

    public void setCountryFilteredList(List<Country> countryFilteredList) {
        this.countryFilteredList = countryFilteredList;
    }

    public List<Region> getRegionFilteredList() {
        return regionFilteredList;
    }

    public void setRegionFilteredList(List<Region> regionFilteredList) {
        this.regionFilteredList = regionFilteredList;
    }

    public List<City> getCityFilteredList() {
        return cityFilteredList;
    }

    public void setCityFilteredList(List<City> cityFilteredList) {
        this.cityFilteredList = cityFilteredList;
    }

    public Country getCountryRef() {
        return countryRef;
    }

    public void setCountryRef(Country countryRef) {
        this.countryRef = countryRef;
    }

    public Country getCountrySelectionRef() {
        return CountrySelectionRef;
    }

    public void setCountrySelectionRef(Country CountrySelectionRef) {
        this.CountrySelectionRef = CountrySelectionRef;
    }

    public Region getRegionySelectionRef() {
        return RegionySelectionRef;
    }

    public void setRegionySelectionRef(Region RegionySelectionRef) {
        this.RegionySelectionRef = RegionySelectionRef;
    }

    public City getCitySelectionRef() {
        return CitySelectionRef;
    }

    public void setCitySelectionRef(City CitySelectionRef) {
        this.CitySelectionRef = CitySelectionRef;
    }

    public String getCountryString() {
        return countryString;
    }

    public void setCountryString(String countryString) {
        this.countryString = countryString;
    }

    public String getRegionyString() {
        return regionyString;
    }

    public void setRegionyString(String regionyString) {
        this.regionyString = regionyString;
    }

    public String getCityString() {
        return cityString;
    }

    public void setCityString(String cityString) {
        this.cityString = cityString;
    }

    public Currency getCurSelect() {
        return CurSelect;
    }

    public void setCurSelect(Currency CurSelect) {
        this.CurSelect = CurSelect;
    }

    public String getListner() {
        return listner;
    }

    public void setListner(String listner) {
        this.listner = listner;
    }
}
