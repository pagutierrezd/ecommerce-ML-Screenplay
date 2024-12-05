package co.com.mercadolibre.tasks;

import co.com.mercadolibre.exceptions.DatosEntregaNoCoincidenException;
import co.com.mercadolibre.exceptions.ProductoNoEncontradoException;
import co.com.mercadolibre.utils.DatosExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.mercadolibre.userInterfaces.CrearCuentaUI.*;
import static co.com.mercadolibre.userInterfaces.ResultadoBusquedaUI.LBL_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCuentaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        ArrayList<Map<String, String>> dataExcel;

        String correo = "";
        String nombre = "";
        String apellido = "";
        String telefono = "";
        String nombreCompleto = "";

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/DatosAutenticacion.xlsx", "Autenticacion");
            correo = dataExcel.get(0).get("correo");
            nombre = dataExcel.get(0).get("nombre");
            apellido = dataExcel.get(0).get("apellido");
            telefono = dataExcel.get(0).get("telefono");

            nombreCompleto = nombre + " " + apellido;

        } catch (IOException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Check.whether(WebElementQuestion.stateOf(LBL_CREAR_CUENTA), WebElementStateMatchers.isNotPresent())
                        .andIfSo(
                                WaitUntil.the(LBL_CREAR_CUENTA, isVisible()).forNoMoreThan(5).seconds()
                        ),

                Click.on(BTN_AGREGAR_CORREO),
                Click.on(TXT_CORREO),
                Enter.keyValues(correo).into(TXT_CORREO).thenHit(Keys.ENTER),
                WaitUntil.the(CHK_ACEPTAR_TERMINOS, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(CHK_ACEPTAR_TERMINOS),
                WaitUntil.the(BTN_CONTINUAR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CONTINUAR),

                Click.on(BTN_ELEGIR_NOMBRE),
                WaitUntil.the(TXT_USUARIO_NOMBRE, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(TXT_USUARIO_NOMBRE),
                Enter.keyValues(nombre).into(TXT_USUARIO_NOMBRE).thenHit(Keys.ENTER),
                Click.on(TXT_USUARIO_APELLIDO),
                Enter.keyValues(apellido).into(TXT_USUARIO_APELLIDO).thenHit(Keys.ENTER),
                Click.on(BTN_CONTINUAR)
        );
        /**
         if (!LBL_CORREO_CONFIRMADO.of(correo).resolveFor(actor).isPresent()) {
         throw new DatosEntregaNoCoincidenException(
         "El correo '" + correo + "' en crear cuenta no coincide con el ingresado anteriormente.");
         }

         if (!LBL_NOMBRE_CONFIRMADO.of(nombreCompleto).resolveFor(actor).isPresent()) {
         throw new DatosEntregaNoCoincidenException(
         "El nombre completo '" + nombreCompleto + "' en crear cuenta no coincide con el ingresado anteriormente.");
         }*/

        actor.attemptsTo(
                Click.on(BTN_VALIDAR_TELEFONO),
                WaitUntil.the(TXT_TELEFONO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(TXT_TELEFONO),
                Enter.keyValues(telefono).into(TXT_TELEFONO)
        );
    }

    public static CrearCuentaTask conEntradaDatos() {
        return new CrearCuentaTask();
    }

}
