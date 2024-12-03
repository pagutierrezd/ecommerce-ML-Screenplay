#language: es

Característica: Automatizar e-commerce Mercado Libre

  @AgregarCarrito

  Esquema del escenario: Agregar un producto al carrito

    Dado que el usuario se encuentra en la pagina '<url>'
    Cuando busca el producto '<producto>'
    Y agrega el producto '<producto>' al carrito
    Y se le solicita iniciar sesion con su correo '<correo>'
    Entonces Visualiza '<producto>' en el carrito
    Y completa el formulario de agregar domicilio

    Ejemplos:
      | url                              | producto                                    | correo              |
    ##@externaldata@parametros/Datos.xlsx@AgregarProducto
   |https://www.mercadolibre.com.co/   |Kindle Scribe 32gb Lapiz Premium color Gris   |paangudi3@gmail.com|
   |https://www.mercadolibre.com.co/   |Cámara Fujifilm Instax Mini 12 Color Rosa   |paangudi3@gmail.com|
