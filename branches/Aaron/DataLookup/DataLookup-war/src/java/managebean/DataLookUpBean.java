/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managebean;

import entities.Currency;
import entities.Department;
import entities.Leavelookup;
import entities.Position;
import entities.Title;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import service.DataLookUpHandlerLocal;
//import sun.util.resources.CurrencyNames_en_GB;

/**
 *
 * @author aaron
 */
@Named(value = "dataLookUpBean")
//@SessionScoped
@RequestScoped
public class DataLookUpBean implements Serializable {

    //testing
    //private CurrencyNames_en_GB javaCurrency;
    @EJB
    private DataLookUpHandlerLocal daoDataLookUp;
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
    private Currency aCurrencyRef;
    private Currency aCurrencySelection;
    private String currencyString;
    private List<Currency> currencyList;
    private List<String> currencyStrings;

    //private String test = "hello world";
    //private String test;
    /**
     *
     */
    @PostConstruct
    public void init() {

        //this.titleCount = 10;
        //this.test = "hello world in init";

        // Title references
        this.titleCount = daoDataLookUp.getTitleCount();

        this.aTitleRef = daoDataLookUp.getTitle("pHD");
        this.titleString = aTitleRef.getTitle();

        this.titleList = new ArrayList<>();
        titleList.addAll(daoDataLookUp.allTitles());

        this.titleStrings = new ArrayList<>();
        titleStrings.addAll(daoDataLookUp.allTitleStr());

        // Position References        
        this.positionCount = daoDataLookUp.getPositionCount();
        // non case sensitive search for 
        this.aPositionRef = daoDataLookUp.getPosition("Tutor");
        this.positionString = aPositionRef.getPosition();

        this.positionList = new ArrayList<>();
        positionList.addAll(daoDataLookUp.allPositions());

        this.positionStrings = new ArrayList<>();
        positionStrings.addAll(daoDataLookUp.allPositionStr());

        // Leave References
        this.leaveCount = daoDataLookUp.getLeaveCount();
        // non case sensitive search for 
        this.aLeaveRef = daoDataLookUp.getLeave("sick leave");
        this.leaveString = aLeaveRef.getLeavetype();

        this.leaveList = new ArrayList<>();
        leaveList.addAll(daoDataLookUp.allLeaves());

        this.leaveStrings = new ArrayList<>();
        leaveStrings.addAll(daoDataLookUp.allLeaveStr());

        // Department References
        this.departmentCount = daoDataLookUp.getDepartmentCount();
        // non case sensitive search for 
        this.aDepartmentRef = daoDataLookUp.getDepartment("finance");
        this.departmentString = aDepartmentRef.getDepartment();

        this.departmentList = new ArrayList<>();
        departmentList.addAll(daoDataLookUp.allDepartments());

        this.departmentStrings = new ArrayList<>();
        departmentStrings.addAll(daoDataLookUp.allDepartmentStr());

        // Currency References
        this.currencyCount = daoDataLookUp.getCurrencyCount();
        // non case sensitive search for 
        this.aCurrencyRef = daoDataLookUp.getCurrency("eur");
        this.currencyString = aCurrencyRef.getCurrencycode3();

        this.currencyList = new ArrayList<>();
        currencyList.addAll(daoDataLookUp.allCurrency());

        this.currencyStrings = new ArrayList<>();
        currencyStrings.addAll(daoDataLookUp.allCurrencyStr());
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

    public Currency getaCurrencyRef() {
        return aCurrencyRef;
    }

    public void setaCurrencyRef(Currency aCurrencyRef) {
        this.aCurrencyRef = aCurrencyRef;
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
     
    
    

    /**
     * Creates a new instance of DataLookUpBean
     */
    public DataLookUpBean() {
    }
}
