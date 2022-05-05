package task;

import lombok.AllArgsConstructor;
import models.Database;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.Mapeo.*;

@AllArgsConstructor
public class probeTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Enter.keyValues("standard_user").into(USERNAME),
                Enter.keyValues("secret_sauce").into(PASSWORD),
                Click.on(BTN)

        );


    }

    public static probeTask informacion() {
        return instrumented(probeTask.class);

    }
}
