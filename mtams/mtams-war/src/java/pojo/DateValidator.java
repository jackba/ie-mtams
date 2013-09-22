/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Badger
 * 
 * @references: www.stackoverflow.com/questions/8745731/compare-two-fields-that-use-same-class
 */
@FacesValidator("validator.dateValidator")
public class DateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || component.getAttributes().get("departDate") == null) return;

        Date toDate   = (Date) value; 
        Date fromDate = (Date) component.getAttributes().get("departDate");

        if (fromDate.after(toDate)) {
            FacesMessage message = new FacesMessage("Invalid dates submitted.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
