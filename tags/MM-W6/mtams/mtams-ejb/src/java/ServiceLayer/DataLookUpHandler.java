/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.CityFacadeLocal;
import DataAccess.CountryFacadeLocal;
import DataAccess.CurrencyFacadeLocal;
import DataAccess.DepartmentFacadeLocal;
import DataAccess.LeavelookupFacadeLocal;
import DataAccess.PositionFacadeLocal;
import DataAccess.RegionFacadeLocal;
import DataAccess.TitleFacadeLocal;
import Entities.City;
import Entities.Country;
import Entities.Currency;
import Entities.Department;
import Entities.Leavelookup;
import Entities.Position;
import Entities.Region;
import Entities.Title;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
//import sun.util.resources.CurrencyNames_en_GB;

/**
 *
 * @author aaron
 */
@Stateless
public class DataLookUpHandler implements DataLookUpHandlerLocal {

    @EJB
    private TitleFacadeLocal daoTitle;
    @EJB
    private PositionFacadeLocal daoPosition;
    @EJB
    private LeavelookupFacadeLocal daoLeave;
    @EJB
    private DepartmentFacadeLocal daoDepartment;
    @EJB
    private CurrencyFacadeLocal daoCurrency;
    @EJB
    private CountryFacadeLocal daoCountry;
    @EJB
    private RegionFacadeLocal daoRegion;
    @EJB
    private CityFacadeLocal daoCity;
    //logger
    private static final Logger logger = Logger.getLogger(DataLookUpHandler.class.getName());

    //private Title titleReg;
    @Override
    public List<Title> allTitles() {
        return daoTitle.findAll();
//        List<Title> titlesList = new ArrayList<>();
//        titlesList.addAll(daoTitle.findAll());
//        return titlesList;
        //return daoTitle.findAll()
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<String> allTitleStr() {
        List<String> StringList = new ArrayList<String>();
        for (Title titleEl : daoTitle.findAll()) {
            StringList.add(titleEl.getTitle());
        }
        return StringList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Title getTitle(String aTitle) {
        //Title aTitleref = new Title();
        //aTitle = daoTitle.find("s");
        //aTitle = 
        for (Title titleO : daoTitle.findAll()) {
            if (titleO.getTitle().equalsIgnoreCase(aTitle)) {
                return titleO;
            }
        }
        //return daoTitle.find(aTitle);
        //return aTitle;
        return null;
    }

    @Override
    public int getTitleCount() {

        return daoTitle.count();
        //int c = daoTitle.count();
        //return 20;
        //return c;
    }

    @Override
    public List<Position> allPositions() {
        //new ArrayList<>().
        return daoPosition.findAll();
        //                List<Title> titlesList = new ArrayList<>();
//        titlesList.addAll(daoTitle.findAll());
//        return titlesList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> allPositionStr() {
        List<String> StringList = new ArrayList<String>();
        for (Position postitionEl : daoPosition.findAll()) {
            StringList.add(postitionEl.getPosition());
        }
        return StringList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPositionCount() {
        return daoPosition.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position getPosition(String aPosition) {
        for (Position PositionO : daoPosition.findAll()) {
            if (PositionO.getPosition().equalsIgnoreCase(aPosition)) {
                return PositionO;
            }
        }
        //return daoTitle.find(aTitle);
        //return aTitle;
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> allLeaveStr() {
        List<String> StringList = new ArrayList<String>();
        for (Leavelookup leaveEl : daoLeave.findAll()) {
            StringList.add(leaveEl.getLeavetype());
        }
        return StringList;
        //return daoLeave.findAll().toString();
        //
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLeaveCount() {
        return daoLeave.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Leavelookup getLeave(String aLeave) {
        for (Leavelookup LeaveO : daoLeave.findAll()) {
            if (LeaveO.getLeavetype().equalsIgnoreCase(aLeave)) {
                return LeaveO;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Leavelookup> allLeaves() {
        return daoLeave.findAll();
        //                List<Title> titlesList = new ArrayList<>();
//        titlesList.addAll(daoTitle.findAll());
//        return titlesList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> allDepartments() {
        return daoDepartment.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> allDepartmentStr() {
        List<String> StringList = new ArrayList<String>();
        for (Department DepartmentEl : daoDepartment.findAll()) {
            StringList.add(DepartmentEl.getDepartment());
        }
        return StringList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int getDepartmentCount() {
        return daoDepartment.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Department getDepartment(String aDepartment) {
        for (Department DepartmentO : daoDepartment.findAll()) {
            if (DepartmentO.getDepartment().equalsIgnoreCase(aDepartment)) {
                return DepartmentO;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Currency> allCurrency() {
        return daoCurrency.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> allCurrencyStr() {
        List<String> StringList = new ArrayList<String>();
        for (Currency CurrencyEl : daoCurrency.findAll()) {
            StringList.add(CurrencyEl.getCurrencycode3() + ", " + CurrencyEl.getCurrencyname() + ", " + CurrencyEl.getCountryname());
        }
        return StringList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrencyCount() {
        return daoCurrency.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Currency getCurrency(String aCurrency) {
        for (Currency CurrencyO : daoCurrency.findAll()) {
            if (CurrencyO.getCurrencycode3().equalsIgnoreCase(aCurrency)) {
                return CurrencyO;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Country> allCountries() {
        return daoCountry.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> allCountriesStr() {
        List<String> StringList = new ArrayList<String>();
        for (Country CountryEl : daoCountry.findAll()) {
            StringList.add(CountryEl.getCode3() + ", " + CountryEl.getName());
        }
        return StringList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCountriesCount() {
        return daoCountry.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Country getCountries(String aCountry) {
        for (Country CountryO : daoCountry.findAll()) {
            if (CountryO.getCode3().equalsIgnoreCase(aCountry)) {
                return CountryO;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List<String> allCitiesStr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCitiesCount() {
        return daoCity.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City getCities(String aCity) {
        for (City CityO : daoCity.findAll()) {
            if (CityO.getUrl().equalsIgnoreCase(aCity)) {
                return CityO;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> allRegionsStr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRegionsCount() {
        return daoRegion.count();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Region getRegions(String aRegion) {
        for (Region RegionO : daoRegion.findAll()) {
            if (RegionO.getUrl().equalsIgnoreCase(aRegion)) {
                return RegionO;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<City> getCities(Region aRegion, Country aCountry) {
        List<City> RegionsCity = new ArrayList<City>();
        
        for (City CityO : daoCity.findAll()) {
            //logger.log(Level.INFO, "1 CityO : {0}", CityO);
            if (CityO.getCode2().getCode2().equalsIgnoreCase(aCountry.getCode2())) {
                logger.log(Level.INFO, "2 CityO : {0}", CityO);
                if (CityO.getRegion().equalsIgnoreCase(aRegion.getCode())) {
                    logger.log(Level.INFO, "3 CityO : {0}", CityO);
                    RegionsCity.add(CityO);
                }
                
            }
        }
        return RegionsCity;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<City> allCities(String aRegion, Country aCountry) {
        
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City getCities(String aRegion, Country aCountry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Region> allRegions(Country aCountry) {

        List<Region> CountryRegions = new ArrayList<Region>();

        for (Region RegionO : daoRegion.findAll()) {
            
            if (RegionO.getCode2().getCode2().equalsIgnoreCase(aCountry.getCode2())) {
                CountryRegions.add(RegionO);
                logger.log(Level.INFO, "allREgions RegionO : {0}", RegionO);
            }
        }
        return CountryRegions;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Region getRegions(String aRegion, Country aCountry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
