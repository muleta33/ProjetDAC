/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 

/**
 *
 * @author margotj
 */
@FacesValidator(value = "numberOfFragrancesValidator")
public class NumberOfFragrancesValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int length = ((Long[])value).length;
        boolean valid = true;
        if (length <= 0 || length > 3)
            valid = false;
        if (!valid) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Choix de senteurs invalide", "Vous devez sélectionnez entre une et trois senteurs.");
            throw new ValidatorException(message);
        }
    }
}

