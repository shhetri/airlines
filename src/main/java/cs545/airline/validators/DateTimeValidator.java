package cs545.airline.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.DateFormat;
import java.util.Locale;

@FacesValidator("dateTimeValidator")
public class DateTimeValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            String[] dateTime = o.toString().split(" ");
            DateFormat.getDateInstance(DateFormat.SHORT, Locale.US).parse(dateTime[0]);
            DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US).parse(dateTime[1] + " " + dateTime[2]);
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Please enter valid date and time. eg: 6/25/15 1:45 PM");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw new ValidatorException(msg);
        }
    }
}
