package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioSesionUI {

    public static final Target IFRAME_LOGIN = Target.the("Iframe Inicio Sesion")
            .locatedBy("//iframe[contains(@allow, 'identity-credentials-get')]");

    public static final Target BTN_INICIAR_SESION = Target.the("Boton Iniciar Sesion Google")
            .locatedBy("(//span[text()='Iniciar sesión con Google'])[1]");

    public static final Target TXT_CORREO = Target.the("Campo Correo Electronico")
            .locatedBy("//input[@type='email' and contains(@aria-label, 'Correo electrónico')]");

    public static final Target BTN_SIGUIENTE = Target.the("Boton Siguiente")
            .locatedBy("//button[contains(@class, 'VfPpkd-LgbsSe') and .//span[text()='Siguiente']]");

    public static final Target TXT_CLAVE = Target.the("Campo Clave")
            .locatedBy("//div[@id='password']//input");

    public InicioSesionUI() { throw new UnsupportedOperationException("Utility class"); }
}
