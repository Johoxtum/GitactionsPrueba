package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.validar;
import task.pruebaTask;
import utils.SeleniumDemo;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class pruebaStep {

    @Before
    public void setThestage()
    {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Pablo");
        SeleniumDemo.web();
    }


    @Given("Ingreso a la pagina web")
    public void ingresoALaPaginaWeb() {

        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }
    @When("Ingreso los siguientes datos solicitados")
    public void ingresoLosSiguientesDatosSolicitados() {

        theActorInTheSpotlight().attemptsTo(pruebaTask.informacion());
    }
    @Then("Veo la pantalla principal")
    public void veoLaPantallaPrincipal() {

        validar.validacion().answeredBy(theActorInTheSpotlight());

    }

}
