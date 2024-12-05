package co.com.mercadolibre.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.mercadolibre.userInterfaces.TipoAutenticacionUI.BTN_TIPO_AUTENTICACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarAutenticacionTask implements Task {

    private String accion;

    public SeleccionarAutenticacionTask(String accion){
        this.accion = accion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_TIPO_AUTENTICACION.of(accion), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_TIPO_AUTENTICACION.of(accion))
        );
    }

    public static SeleccionarAutenticacionTask conLaAccion(String accion) {
        return new SeleccionarAutenticacionTask(accion);
    }
}
