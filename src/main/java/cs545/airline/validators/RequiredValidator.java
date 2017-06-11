package cs545.airline.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("reqValidator")
public class RequiredValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o.toString().trim().equals("")) {
            FacesMessage msg = new FacesMessage("Please enter search value");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw new ValidatorException(msg);
        }
    }
}
