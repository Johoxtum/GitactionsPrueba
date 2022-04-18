package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import models.Database;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import task.probeTask;
import userinterfaces.Mapeo;
import userinterfaces.constans;
import utils.Datamanager;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class prueba2Step {

    @Dado("^que (.*)  ingresa a la pagina web$")
    public void queElUsuarioIngresaALaPaginaWeb(String nameActor) {

        Datamanager.initActor(nameActor);

    }
    @Cuando("Juan ingresa los datos de logeo")
    public void juanIngresaLosDatosDeLogeo() {

        Database userLoginData = OnStage.theActorInTheSpotlight().recall(constans.LOGIN_DATA_KEY);
        theActorInTheSpotlight().attemptsTo(probeTask.withData(userLoginData));

       /* Database userLoginData = OnStage.theActorInTheSpotlight().recall(constans.LOGIN_DATA_KEY);
        OnStage.withCurrentActor(
                WaitUntil.the(Mapeo.BTN, isVisible()).forNoMoreThan(10).seconds(),
                probeTask.withData(userLoginData))*/;
    }
    @Entonces("Se evidencia el dashboard de la aplicacion")
    public void seEvidenciaElDashboardDeLaAplicacion() {

    }

}
