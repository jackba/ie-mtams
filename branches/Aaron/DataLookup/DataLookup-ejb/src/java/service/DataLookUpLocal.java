/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Department;
import entities.Leavelookup;
import entities.Position;
import entities.Title;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface DataLookUpLocal {

    // Title methods
    public List<Title> allTitles();

    public List<String> allTitleStr();

    public int getTitleCount();

    public Title getTitle(String aTitle);
    
    // Position methods
    public List<Position> allPositions();

    public List<String> allPositionStr();

    public int getPositionCount();

    public Position getPosition(String aPosition);
    
    // LeaveLookup methods
    public List<Leavelookup> allLeaves();

    public List<String> allLeaveStr();

    public int getLeaveCount();

    public Leavelookup getLeave(String aLeave);
    
    // Department methods
    public List<Department> allDepartments();

    public List<String> allDepartmentStr();

    public int getDepartmentCount();

    public Department getDepartment(String aDepartment);

  
}
