package co.com.mercadolibre.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CrearCuentaUI {

    public static final Target LBL_CREAR_CUENTA = Target.the("label Crear Cuenta")
            .locatedBy("//h1[text()='Completa los datos para crear tu cuenta']");

    public static final Target BTN_AGREGAR_CORREO = Target.the("Boton Para Agregar Correo")
            .locatedBy("//span[text()='Agregar']");

    public static final Target TXT_CORREO = Target.the("Correo Nueva Cuenta")
            .locatedBy("//input[@id='enter-email-input']");

    public static final Target CHK_ACEPTAR_TERMINOS = Target.the("Chekout Aceptar Terminos Y Condiciones")
            .locatedBy("//input[@id='policies']");

    public static final Target BTN_CONTINUAR = Target.the("Boton Continuar Correo Nueva Cuenta")
            .locatedBy("//span[text()='Continuar']");

    public static final Target BTN_ELEGIR_NOMBRE = Target.the("Boton Elegir Nombre")
            .locatedBy("//button[@id='hub-item-button']");

    public static final Target TXT_USUARIO_NOMBRE = Target.the("Nombre Usuario Nueva Cuenta")
            .locatedBy("//input[@id='firstName']");

    public static final Target TXT_USUARIO_APELLIDO = Target.the("Apellido Usuario Nueva Cuenta")
            .locatedBy("//input[@id='lastName']");

    public static final Target LBL_CORREO_CONFIRMADO = Target.the("Label Correo Confirmado")
            .locatedBy("//li[contains(@id,'declared_email')] //span[text()= '{0}']");

    public static final Target LBL_NOMBRE_CONFIRMADO = Target.the("Label con el nombre Confirmado")
            .locatedBy("//li[contains(@id,'kyc_unified')] //span[text()= '{0}']");

    public static final Target BTN_VALIDAR_TELEFONO = Target.the("Boton Validar Telefono")
            .locatedBy("//span[text()='Validar']");

    public static final Target TXT_TELEFONO = Target.the("Telefono Usuario Nueva Cuenta")
            .locatedBy("//input[@id=':R1ot1:']");

    public CrearCuentaUI() { throw new UnsupportedOperationException("Utility class"); }
}
