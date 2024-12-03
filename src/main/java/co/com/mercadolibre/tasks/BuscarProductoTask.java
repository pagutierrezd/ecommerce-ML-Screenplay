package co.com.mercadolibre.tasks;

import co.com.mercadolibre.exceptions.ProductoNoEncontradoException;
import co.com.mercadolibre.interactions.ScrollJavaScript;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.*;

import static co.com.mercadolibre.userInterfaces.InicioUI.TXT_BUSCADOR;
import static co.com.mercadolibre.userInterfaces.ResultadoBusquedaUI.LBL_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarProductoTask implements Task {

    private String producto;

    public BuscarProductoTask(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TXT_BUSCADOR),
                Enter.keyValues(producto).into(TXT_BUSCADOR).thenHit(Keys.ENTER),
                Check.whether(WebElementQuestion.stateOf(LBL_PRODUCTO.of(producto)), WebElementStateMatchers.isNotVisible())
                        .andIfSo(
                                WaitUntil.the(LBL_PRODUCTO.of(producto), isVisible()).forNoMoreThan(15).seconds()
                        )
        );
        if (!LBL_PRODUCTO.of(producto).resolveFor(actor).isPresent()) {
            throw new ProductoNoEncontradoException("El producto '" + producto + "' no se encontró en los resultados.");
        }
        actor.attemptsTo(
                ScrollJavaScript.to(LBL_PRODUCTO.of(producto)),
                JavaScriptClick.on(LBL_PRODUCTO.of(producto))
        );
    }

    public static BuscarProductoTask conElProducto(String producto) {
        return new BuscarProductoTask(producto);
    }
}
