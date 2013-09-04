/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author Marco Remane
 */
@ManagedBean
@RequestScoped
public class MenuBean {

    private MenuModel model;

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
        model = new DefaultMenuModel();

        //Home + Profile
        MenuItem item = new MenuItem();
        item.setValue("Home");
        item.setIcon("ui-icon-home");
        item.setUrl("#");

        model.addMenuItem(item);


        item = new MenuItem();
        item.setValue("Profile");
        item.setIcon("ui-icon-person");
        item.setUrl(this.getURL());

        model.addMenuItem(item);

        
        //Submenu  
        Submenu submenu = new Submenu();
        submenu.setLabel("Applications");
        submenu.setIcon("ui-icon-note");

        item = new MenuItem();
        item.setValue("Start New Application");
        item.setUrl("#");
        submenu.getChildren().add(item);

        item = new MenuItem();
        item.setValue("Manage Applications");
        item.setUrl("#");
        submenu.getChildren().add(item);

        model.addSubmenu(submenu);
    }

    public String getURL() {
        FacesContext context = FacesContext.getCurrentInstance();
        String request = context.getExternalContext().getRequestContextPath();
        System.out.println("PATH:" + request);
        return request;
    }
    

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Data saved");
    }

    public void update() {
        addMessage("Data updated");
    }

    public void delete() {
        addMessage("Data deleted");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
