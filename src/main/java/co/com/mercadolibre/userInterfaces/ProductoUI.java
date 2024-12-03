package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductoUI {

    public static final Target BTN_AGREGAR_CARRITO = Target.the("Boton Agregar Producto Al Carrito")
            .locatedBy("//button[contains(@formaction,'add-to-cart')]");

    public static final Target BTN_INGRESAR_CUENTA = Target.the("Boton Ingresar A Cuenta")
            .locatedBy("//a[contains(@class,'login-link')]/span[text()='Ingresar']");

    public ProductoUI() { throw new UnsupportedOperationException("Utility class"); }
}
