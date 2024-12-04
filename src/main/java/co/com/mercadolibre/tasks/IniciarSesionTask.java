package co.com.mercadolibre.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.Set;

import static co.com.mercadolibre.userInterfaces.InicioSesionUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesionTask implements Task {

    private final String correo;
    private final String clave;

    public IniciarSesionTask(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Guarda el handle de la ventana principal
        String mainWindow = Serenity.getWebdriverManager().getCurrentDriver().getWindowHandle();

        actor.attemptsTo(
                Switch.toFrame(IFRAME_LOGIN.resolveFor(actor)),
                Click.on(BTN_INICIAR_SESION),
                Switch.toParentFrame()
        );

        // Cambiar el foco a la nueva ventana emergente de Google
        Set<String> windowHandles = Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindow)) {
                Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(handle);
                break;
            }
        }

        actor.attemptsTo(
                WaitUntil.the(TXT_CORREO, isVisible()).forNoMoreThan(25).seconds(),
                JavaScriptClick.on(TXT_CORREO),
                Enter.keyValues(correo).into(TXT_CORREO).thenHit(Keys.ENTER),
                Click.on(BTN_SIGUIENTE),

                WaitUntil.the(TXT_CLAVE, isVisible()).forNoMoreThan(25).seconds(),
                JavaScriptClick.on(TXT_CLAVE),
                Enter.keyValues(clave).into(TXT_CLAVE).thenHit(Keys.ENTER),
                Click.on(BTN_SIGUIENTE)
        );

        // Regresar al foco de la ventana principal
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(mainWindow);
    }

    public static IniciarSesionTask conCredenciales(String correo, String clave) {
        return new IniciarSesionTask(correo, clave);
    }
}
