package cs545.airline.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            DateFormat.getDateInstance(DateFormat.SHORT, Locale.US).parse(o.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Please enter valid date");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw new ValidatorException(msg);
        }
    }
}
