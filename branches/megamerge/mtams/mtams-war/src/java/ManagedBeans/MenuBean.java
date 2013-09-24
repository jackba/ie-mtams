/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author Marco Remane
 */
@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {

    @Inject
    private SessionBean user;
    @Inject
    private SessionBean handler;
    private MenuModel model;
    private SuperAdminBean superbean;

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
        model = new DefaultMenuModel();

        //Home + Profile
        MenuItem item = new MenuItem();
        item.setValue("Home");
        item.setIcon("ui-icon-home");
        if ((returnRole("11")) || (returnRole("12"))) {
            item.setUrl(this.getURL("userHome"));
        }
        if (returnRole("21")) {
            item.setUrl(this.getURL("accountAll"));
        }

        if (returnRole("22")) {
            item.setUrl(this.getURL("superHome"));
        }
        model.addMenuItem(item);

        //set profile for applicant and authorizer only
        if (returnRole("11") || returnRole("12")) {
            item = new MenuItem();
            item.setValue("Profile");
            item.setIcon("ui-icon-person");
            item.setUrl(this.getURL("travelProfileView"));

            model.addMenuItem(item);
        }

        //Applications 
        if (returnRole("11")) {
            Submenu appMenu = new Submenu();
            appMenu.setLabel("Applications");
            appMenu.setIcon("ui-icon-note");

            item = new MenuItem();
            item.setValue("Start New Application");
            item.setUrl(this.getURL("applicationCreate"));
            appMenu.getChildren().add(item);

            model.addSubmenu(appMenu);
        }
        //Authorization

        if (returnRole("12")) {                //AUTHORIZER
            Submenu authMenu = new Submenu();
            authMenu.setLabel("Authorizations");
            authMenu.setIcon("ui-icon-circle-check");

            item = new MenuItem();
            item.setValue("Manage Authorizations");
            item.setUrl(this.getURL("authorizerHome"));
            authMenu.getChildren().add(item);
            model.addSubmenu(authMenu);
        }

        if (returnRole("22")) {
            Submenu superMenu = new Submenu();
            superMenu.setLabel("Actions");
            superMenu.setIcon("ui-icon-wrench");

            item = new MenuItem();
            item.setValue("Create Admin");
            item.setUrl(this.getURL("createAdmin"));
            superMenu.getChildren().add(item);
            model.addSubmenu(superMenu);

            item = new MenuItem();
            item.setValue("Edit Admin");
            item.setUrl(this.getURL("editAdminSelect"));
            superMenu.getChildren().add(item);
            model.addSubmenu(superMenu);

            item = new MenuItem();
            item.setValue("Create Role");
            item.setUrl(this.getURL("createRole"));
            superMenu.getChildren().add(item);
            model.addSubmenu(superMenu);

            item = new MenuItem();
            item.setValue("Deactivate Account");
            item.setUrl(this.getURL("deactivateAccount"));
            superMenu.getChildren().add(item);
            model.addSubmenu(superMenu);
            
            item = new MenuItem();
            item.setValue("Reactivate Account");
            item.setUrl(this.getURL("reactivateAccount"));
            superMenu.getChildren().add(item);
            model.addSubmenu(superMenu);

            item = new MenuItem();
            item.setValue("Department Handler");
            item.setUrl(this.getURL("departmentHandler"));
            superMenu.getChildren().add(item);
            model.addSubmenu(superMenu);
        }

    }

    public String getURL(String url) {
        FacesContext context = FacesContext.getCurrentInstance();
        String request = context.getExternalContext().getRequestServletPath();
        System.out.println("PATH:" + request);
        return request + "/" + url + ".xhtml";
    }

    private boolean returnRole(String role) {
        return ((Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userRole")).toString().contains(role) ? true : false;
    }

    public MenuModel getModel() {
        return model;
    }
}
