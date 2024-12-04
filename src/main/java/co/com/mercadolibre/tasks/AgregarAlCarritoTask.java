package co.com.mercadolibre.tasks;

import co.com.mercadolibre.interactions.ScrollJavaScript;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.mercadolibre.userInterfaces.ProductoUI.BTN_AGREGAR_CARRITO;
import static co.com.mercadolibre.userInterfaces.ProductoUI.BTN_INGRESAR_CUENTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarritoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollJavaScript.to(BTN_AGREGAR_CARRITO),
                Click.on(BTN_AGREGAR_CARRITO),
                WaitUntil.the(BTN_INGRESAR_CUENTA, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_INGRESAR_CUENTA)
        );
    }

    public static AgregarAlCarritoTask conElProducto() { return new AgregarAlCarritoTask(); }
}