package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioUI {

    public static final Target TXT_BUSCADOR = Target
            .the("Buscador Inicio")
            .locatedBy("//input[@class='nav-search-input']");

    public InicioUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}
