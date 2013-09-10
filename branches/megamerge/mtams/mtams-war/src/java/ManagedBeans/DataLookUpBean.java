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
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.enterprise.context.RequestScoped;
import ServiceLayer.DataLookUpHandlerLocal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
//import sun.util.resources.CurrencyNames_en_GB;

/**
 *
 * @author aaron
 */
@Named(value = "dataLookUpBean")
@SessionScoped
//@RequestScoped
public class DataLookUpBean implements Serializable {

    //testing
    //private CurrencyNames_en_GB javaCurrency;
    @EJB
    private DataLookUpHandlerLocal daoDataLookUp;
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());
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
    private Currency aCurrencySelection;
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
    private Country aCountrySelection;
    private Region aRegionySelection;
    private City aCitySelection;

    //private String test = "hello world";
    //private String test;
    /**
     *
     */
    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "initialize");

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

        logger.log(Level.INFO, "aCurrencySelection : {0}", aCurrencySelection);
        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        if (aCurrencySelection != null) {
            this.setSelectedCurrencyString(("".equals(this.getSelectedCurrencyString())) ? this.CurSel() : this.getSelectedCurrencyString());
        } else {
            this.selectedCurrencyString = "set";
        }
        //this.setSelectedCurrencyString((this.selectedCurrencyString == null) ? "test" : this.CurSel());
        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        //logger.log(Level.INFO, "aCurrencySelection.toString : {0}", aCurrencySelection.toString());


        this.currencyList = new ArrayList<Currency>();
        currencyList.addAll(daoDataLookUp.allCurrency());

        this.currencyStrings = new ArrayList<String>();
        currencyStrings.addAll(daoDataLookUp.allCurrencyStr());

        this.countryCount = daoDataLookUp.getCountriesCount();
        this.regionCount = daoDataLookUp.getRegionsCount();
        this.cityCount= daoDataLookUp.getCitiesCount();

        this.countryList = new ArrayList<Country>();
        this.regionList = new ArrayList<Region>();
        this.cityList = new ArrayList<City>();

        // need to stop headers being set till dialogs are built and ajax requests
        // can be handled
        FacesContext
                .getCurrentInstance().getExternalContext().getSession(true);
        logger.log(Level.INFO, "initialize end");
    }

    public String CurSel() {
//        logger.log(Level.INFO, "CurSel");
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        selectedCurrencyString = aCurrencySelection.getCurrencycode3() + ", " + aCurrencySelection.getCountryname() + ", " + aCurrencySelection.getCurrencyname();
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        return selectedCurrencyString;
    }

    public String CRCSel() {
        return "CRC test";
    }

    public List<String> getTitleStrings() {
        return titleStrings;
    }

    public void setTitleStrings(List<String> titleStrings) {
        this.titleStrings = titleStrings;
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

    public DataLookUpHandlerLocal getDaoDataLookUp() {
        return daoDataLookUp;
    }

    public void setDaoDataLookUp(DataLookUpHandlerLocal daoDataLookUp) {
        this.daoDataLookUp = daoDataLookUp;
    }

    public int getTitleCount() {
        //return titleCount;
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

    public String getHello() {
        return "Hello World";
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

    public Department getAdepartmentRef() {
        return aDepartmentRef;
    }

    public void setAdepartmentRef(Department adepartmentRef) {
        this.aDepartmentRef = adepartmentRef;
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

    public Department getaDepartmentRef() {
        return aDepartmentRef;
    }

    public void setaDepartmentRef(Department aDepartmentRef) {
        this.aDepartmentRef = aDepartmentRef;
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

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public List<String> getCurrencyStrings() {
        return currencyStrings;
    }

    public void setCurrencyStrings(List<String> currencyStrings) {
        this.currencyStrings = currencyStrings;
    }

    public Currency getaCurrencySelection() {
        return aCurrencySelection;
    }

    public void setaCurrencySelection(Currency aCurrencySelection) {
        this.aCurrencySelection = aCurrencySelection;
    }

    public List<Currency> getCurrencyFilteredList() {
        return currencyFilteredList;
    }

    public void setCurrencyFilteredList(List<Currency> currencyFilteredList) {
        this.currencyFilteredList = currencyFilteredList;
    }

    public String getSelectedCurrencyString() {
        return selectedCurrencyString;
    }

    public void setSelectedCurrencyString(String SelcurrencyString) {
        this.selectedCurrencyString = SelcurrencyString;
    }

    /**
     * Creates a new instance of DataLookUpBean
     */
    public DataLookUpBean() {
    }
}
