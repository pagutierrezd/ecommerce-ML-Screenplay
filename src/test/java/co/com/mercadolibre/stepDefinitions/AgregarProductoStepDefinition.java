package co.com.mercadolibre.stepDefinitions;

import co.com.mercadolibre.runners.RunnerPersonalizado;
import co.com.mercadolibre.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class AgregarProductoStepDefinition {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario se encuentra en la pagina {string}")
    public void queElUsuarioSeEncuentraEnLaPagina(String url) {
        WebDriverManager.chromedriver().setup();
        theActorCalled("human").wasAbleTo(Open.url(url));
    }

    @Cuando("busca el producto {string}")
    public void buscaElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarProductoTask.conElProducto(producto)
        );
    }

    @Cuando("agrega el producto al carrito")
    public void agregaElProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarritoTask.conElProducto()
        );
    }

    @Cuando("se le solicita iniciar sesion con su correo {string} y clave {string}")
    public void seLeSolicitaIniciarSesionConSuCorreoYClave(String correo, String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesionTask.conCredenciales(correo, clave)
        );
    }

    @Entonces("Visualiza {string} en el carrito")
    public void visualizaEnElCarrito(String string) {

    }

    @Entonces("completa el formulario de agregar domicilio")
    public void completaElFormularioDeAgregarDomicilio() {

    }
}
