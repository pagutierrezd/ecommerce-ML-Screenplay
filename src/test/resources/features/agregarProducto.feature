#language: es

Característica: Automatizar e-commerce Mercado Libre

  @AgregarCarrito

  Esquema del escenario: Agregar un producto al carrito

    Dado que el usuario se encuentra en la pagina '<url>'
    Cuando busca el producto '<producto>'
    Y agrega el producto al carrito
    Y elige la opcion de autenticacion '<accion>'
    Entonces se completan los datos según la '<accion>' seleccionada

    Ejemplos:
      | url                              | producto                                    | accion       |
    ##@externaldata@parametros/Datos.xlsx@AgregarProducto
   |https://www.mercadolibre.com.co/   |Kindle Scribe 32gb Lapiz Premium color Gris   |Crear cuenta|
