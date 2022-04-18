package task;

import models.Database;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;



import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.Mapeo.*;


public class probeTask implements Task {

    private final Database loginData;

    public probeTask(Database loginData) {
        this.loginData = loginData;
    }

    public static probeTask withData(Database loginData) {
        return instrumented(probeTask.class, loginData);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Enter.keyValues(loginData.getUsername()).into(USERNAME),
                Enter.keyValues(loginData.getPassword()).into(PASSWORD),
                Click.on(BTN)

        );


    }

    public static probeTask informacion() {
        return instrumented(probeTask.class);

    }
}
