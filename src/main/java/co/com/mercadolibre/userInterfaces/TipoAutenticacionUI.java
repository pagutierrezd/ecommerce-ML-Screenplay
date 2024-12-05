package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class TipoAutenticacionUI {

    public static final Target BTN_TIPO_AUTENTICACION = Target.the("Botón de autenticación {0}")
            .locatedBy("//a[span[contains(text(), '{0}')]]");

    public TipoAutenticacionUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}
