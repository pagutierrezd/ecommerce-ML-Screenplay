package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioUI {

    public static final Target TXT_BUSCADOR = Target
            .the("Campo Busqueda Inicial")
            .locatedBy("//input[@class='nav-search-input']");

    //alternativa si se quiere generar la busqueda con la opción botón de búsqueda (icono de la lupa)
    public static final Target BTN_BUSCAR = Target.the("Boton Busqueda")
            .locatedBy("//button[@class='nav-search-btn']");

    public InicioUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}
