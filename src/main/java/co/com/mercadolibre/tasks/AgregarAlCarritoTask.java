package co.com.mercadolibre.tasks;

import co.com.mercadolibre.interactions.ScrollJavaScript;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.mercadolibre.userInterfaces.ProductoUI.BTN_AGREGAR_CARRITO;

public class AgregarAlCarritoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollJavaScript.to(BTN_AGREGAR_CARRITO),
                Click.on(BTN_AGREGAR_CARRITO)
        );
    }

    public static AgregarAlCarritoTask conElProducto() { return new AgregarAlCarritoTask(); }
}