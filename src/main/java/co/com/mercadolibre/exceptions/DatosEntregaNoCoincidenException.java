package co.com.mercadolibre.exceptions;

public class DatosEntregaNoCoincidenException extends RuntimeException{
    public DatosEntregaNoCoincidenException(String message) {
        super(message);
    }
}
