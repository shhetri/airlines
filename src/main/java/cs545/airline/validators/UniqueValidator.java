package cs545.airline.validators;

import cs545.airline.dao.AirlineDao;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.NoResultException;

@FacesValidator("uniqueValidator")
public class UniqueValidator implements Validator {
    private AirlineDao airlineDao = new AirlineDao();

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            airlineDao.findOneByName(o.toString());
            FacesMessage msg = new FacesMessage("Airline name should be unique");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw new ValidatorException(msg);
        } catch (NoResultException ignored) {
        }
    }
}
