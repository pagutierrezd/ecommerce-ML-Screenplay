# ecommerce-ML-Screenplay

### Descripción
- Proyecto de práctica en automatización de pruebas utilizando Selenium WebDriver y Cucumber, enfocado en la implementación
  de un escenario del feature `Agregar un producto al carrito`.

### Características del Proyecto
- Uso de BDD (Behavior-Driven Development) para escribir pruebas en un lenguaje natural (Gherkin).
- Automatización de un flujo típico de comercio electrónico.
- Implementación del Patron de pruebas automatizadas Screenplay.
- WebDriverManager para manejar drivers del navegador.

## Estructura
```
src
├── main
│   ├── java
│   │   └── co.com.mercadolibre
│   │       ├── exceptions          # Manejo de excepciones específicas del proyecto
│   │       ├── interactions        # Definición de interacciones reutilizables
│   │       ├── questions           # Clases para validar estados o datos de la interfaz
│   │       ├── tasks               # Representación de acciones que realiza el actor
│   │       ├── userInterfaces      # Localizadores de elementos (UI) y su organización
│   │       └── utils               # Clases utilitarias o funciones de soporte
│   └── resources                   # Archivos de recursos necesarios (por ahora vacío)
└── test
    ├── java
    │   └── co.com.mercadolibre
    │       ├── runners             # Configuración de los Runners de pruebas (Cucumber/Serenity)
    │       └── stepDefinitions     # Definición de pasos que conectan Gherkin con Screenplay.
    └── resources
        └── features                # Escenarios en formato Gherkin (.feature).
```
# Cómo Ejecutar el Proyecto

## 1. Requisitos Previos:

- Java JDK 11 Correto.
- Gradle instalado.
- Navegador Chrome y su respectivo driver (configurado en el proyecto).

## 2. Clonar el Repositorio:
`git clone https://github.com/pagutierrezd/ecommerce-ML-Screenplay`

## 3. Ejecutar desde el Runner:
- Navega a la clase en `src/test/java/co.com.mercadolibre/runners`.
- Haz clic derecho sobre la clase `agregarProductoRunner` y selecciona "Run".