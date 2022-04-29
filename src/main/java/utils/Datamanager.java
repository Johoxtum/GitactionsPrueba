package utils;

import lombok.AllArgsConstructor;
import models.Database;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import userinterfaces.constans;

import java.util.Arrays;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class Datamanager {

    enum Users {
        JUAN("Juan","Login exitoso"){
            @Override
            public Database loginData() {

                return new Database("standard_user","secret_sauce");
            }},
        CAMILO("Camilo","Login fallido"){
            @Override
            public Database loginData() {

                return new Database("Camilo","1234");
            }

        };


        public final String userName;
        public final String description;

        private Users(String userName, String description) {
            this.userName = userName;
            this.description = description;
        }
        public abstract Database loginData();

        public static Users fromUserName(String actorName) {
            return Arrays.stream(values())
                    .filter(users -> users.userName.equals(actorName))
                    .findFirst()
                    .orElse(CAMILO);
        }
    }

    public static void initActor(String actorName){
        Users user = Users.fromUserName(actorName);
        OnStage.theActorCalled(actorName)
                .describedAs(user.description)
                .remember(constans.LOGIN_DATA_KEY, user.loginData());
        Driver.web();
        //theActorInTheSpotlight().wasAbleTo(Open.url("https://www.saucedemo.com/"));
        theActorCalled(actorName).whoCan(BrowseTheWeb.with(Driver.inThePage("https://www.saucedemo.com/")));

    }

}
