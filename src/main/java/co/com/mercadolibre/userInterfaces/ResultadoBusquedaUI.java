package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ResultadoBusquedaUI {

    public static final Target LBL_PRODUCTO = Target
            .the("Label Producto Resultado Busqueda")
            .locatedBy("//a[text()='{0}']");

    public ResultadoBusquedaUI() {
        throw new UnsupportedOperationException("Utility class");
    }
}
