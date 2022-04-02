package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.Mapeo;

import static userinterfaces.constans.TEXT_VALIDATION;

public class validar implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Mapeo.validation.equals(TEXT_VALIDATION);
    }
    public static validar validacion(){
        return new validar();
    }
}
