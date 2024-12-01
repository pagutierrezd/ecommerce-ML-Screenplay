package co.com.mercadolibre.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class BuscarProductoTask implements Task {

    private String producto;

    public BuscarProductoTask(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static BuscarProductoTask conElProducto(String producto) {
        return new BuscarProductoTask(producto);
    }
}
