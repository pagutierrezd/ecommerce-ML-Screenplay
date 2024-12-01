package co.com.mercadolibre.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.*;

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
        theActorCalled("robot").wasAbleTo(Open.url(url));
    }

    @Cuando("busca el producto {string}")
    public void buscaElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                //BuscarProductoTask.conElProducto(producto)
        );
    }

    @Cuando("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String string) {

    }

    @Cuando("se le solicita iniciar sesion con su correo {string} y clave")
    public void seLeSolicitaIniciarSesionConSuCorreoYClave(String string) {

    }

    @Entonces("Visualiza {string} en el carrito")
    public void visualizaEnElCarrito(String string) {

    }

    @Entonces("completa el formulario de agregar domicilio")
    public void completaElFormularioDeAgregarDomicilio() {

    }
}
