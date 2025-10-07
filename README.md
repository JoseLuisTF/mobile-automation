
# Framework de Automatizacion Mobile

Framework de automatizacion mobile multiplataforma orientado a mantenibilidad, escalabilidad y reutilizacion de codigo, usando Java, Appium y TestNG, patron de diseño Page Object Model, con integracion SLF4J para manejo de logs y flujo modular adaptable a Android/iOS.

# Arquitectura General


## Esquema del Proyecto

```bash
mobile-automation/
│
├── pom.xml
├── testng.xml
├── .gitignore
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/josetarazona/app/config/
    │           └── DriverFactory.java
    │
    └── test/
        ├── java/
        │   └── com/josetarazona/app/
        │       ├── base/
        │       │   └── BaseTest.java
        │       │
        │       ├── models/
        │       │   └── Credentials.java
        │       │
        │       ├── pages/
        │       │   ├── BasePage.java
        │       │   ├── HomePage.java
        │       │   ├── LandingPage.java
        │       │   ├── LoginPage.java
        │       │   ├── ProfilePage.java
        │       │   └── SettingsPage.java
        │       │
        │       ├── tests/
        │       │   └── SmokeTest.java
        │       │
        │       └── util/
        │           ├── GestureUtils.java
        │           └── ModalHandler.java
        │
        └── resources/
            └── config/
                ├── capabilities.json
                └── user-data.properties

```


## Diagrama por Capas

Cada capa refleja una responsabilidad clara y un sentido de dependencias:

- **Capa de Tests:** Orquesta los flujos de tests completos y asserts.

- **Capa de Page Objects:** Representa pantallas, encapsula lógica de UI y navegación.

- **Capa de Utilidades/Config:** Helpers, utilities y configuración de drivers/capabilities.

- **Capa de Datos Externos:** Archivos de datos, propiedades, capacidades usadas por las demás capas.

![Logo](https://i.imgur.com/UqmH2zK.png)
## Patrones de Diseño

- **Page Object Model (POM):** Cada pantalla de la app tiene una clase asociada que encapsula sus elementos y acciones. Esto favorece la reutilización y el mantenimiento, permitiendo que los tests interactúen con la UI de forma clara y desacoplada.

- **Factory Pattern:** Utilizado para la generación de drivers y configuración dinámica según la plataforma (Android/iOS), permitiendo un solo punto de entrada para instanciación y adaptabilidad en nuevas plataformas.

- **Builder Pattern:** Aplicado en la construcción de capabilities y configuraciones complejas en clases como ```CapabilityManager```, facilitando la agregación de propiedades en formato fluido y seguro.

- **Singleton Pattern:** Se implementa en la gestión de configuración global (```PropertyManager```), asegurando que las propiedades/valores requeridos se mantengan centralizados y consistentes durante toda la ejecución.

## Soporte Multi-plataforma

### Capabilities desde archivo JSON

El framework utiliza un archivo JSON para centralizar y parametrizar las capabilities de Android e iOS. Esto permite seleccionar la plataforma a ejecutar dinámicamente desde el XML de TestNG, manteniendo un solo punto de configuración para ambos entornos.

#### Ejemplo de JSON

```JSON
{
  "android": {
    "platformName": "Android",
    "appium:automationName": "UiAutomator2",
    "appium:deviceName": "JoseLuis",
    "appium:appPackage": "com.letterboxd.letterboxd",
    "appium:appActivity": "com.letterboxd.letterboxd.MainActivity",
    "noReset": false
  },
  "ios": {
    "platformName": "iOS",
    "appium:automationName": "XCUITest",
    "appium:deviceName": "iPhone 14",
    "appium:udid": "000",
    "appium:bundleId": "com.letterboxd.letterboxd"
  }
}
```

#### Configuracion de TestNG

```XML
<suite name="Mobile Tests">
  <parameter name="platform" value="android"/>
  ...
</suite>
```

## Estrategia para manejo de logs y reportes

- El framework utiliza SLF4J configurado con Logback para emitir logs a diferentes niveles: info y debug, tanto en clases Page Object como en los tests.

- Los logs permiten trazabilidad del flujo de automatización y facilitan detectar fallos y cuellos de botella.

- Los reportes de pruebas se generan automáticamente usando TestNG
## Escalabilidad y mantenibilidad

- El uso de Page Object Model y helpers modulares permite agregar nuevas pantallas, flujos o funcionalidades sin romper la estructura existente.

- La configuración de capabilities y datos de prueba externos en archivos (json/properties) está separada del código, pudiendo adaptarse a nuevos ambientes/dispositivos fácilmente.

- Clases y métodos siguen el principio SOLID, manteniendo responsabilidades únicas y fácil testeo unitario.

- La arquitectura por capas y la organización clara del proyecto facilitan el trabajo colaborativo, el onboarding de nuevos miembros y la integración con pipelines de CI.
## Organización de dependencias

- Las dependencias se gestionan a través de Maven en el archivo pom.xml, garantizando versiones fijas y fácil actualización.

#### Versiones de las dependencias

```XML
        <appium.version>10.0.0</appium.version>
        <selenium.version>4.35.0</selenium.version>
        <testng.version>7.10.2</testng.version>
        <slf4j.version>2.0.12</slf4j.version>
        <webdriver.manager.version>6.3.2</webdriver.manager.version>
```
## Ejecucion de Test

La ejecución de tests puede hacerse por línea de comandos o directamente desde el XML de TestNG

```bash
mvn clean test
```
    
## Demo

#### Aplicacion utilizada [Letterboxd](https://play.google.com/store/apps/details?id=com.letterboxd.letterboxd&hl=en)


![Demo](https://i.imgur.com/A4YO77l.gif)

[Demo](https://i.imgur.com/A4YO77l.gif)

#### Logs de Ejecucion

![Logs](https://i.imgur.com/gH9jmSM.png)

