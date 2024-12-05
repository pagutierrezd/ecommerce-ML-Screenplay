package co.com.mercadolibre.stepDefinitions;

import co.com.mercadolibre.tasks.*;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

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
                BuscarProductoTask.conElProducto(producto)
        );
    }

    @Cuando("agrega el producto al carrito")
    public void agregaElProductoAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarritoTask.conElProducto()
        );
    }

    @Cuando("elige la opcion de autenticacion {string}")
    public void eligeLaOpcionDeAutenticacion(String accion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarAutenticacionTask.conLaAccion(accion)
        );
    }

    @Entonces("se completan los datos según la {string} seleccionada")
    public void seCompletanLosDatosSegúnLaSeleccionada(String accion) {

        switch (accion) {
            case "Crear cuenta":
                OnStage.theActorInTheSpotlight().attemptsTo(
                        CrearCuentaTask.conEntradaDatos()
                );
                break;

            case "Ingresar":
                OnStage.theActorInTheSpotlight().attemptsTo(
                        IniciarSesionTask.conCredenciales()
                );
                break;
            default:
                throw new IllegalArgumentException("Opción de autenticación no válida: " + accion);
        }

    }
}