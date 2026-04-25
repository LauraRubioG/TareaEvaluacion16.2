<div align="center">

# 🌸 Práctica de Automatización: SauceDemo 🌸

![Java](https://img.shields.io/badge/Java-FF69B4?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-FFB6C1?style=for-the-badge&logo=selenium&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-FF1493?style=for-the-badge&logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71585?style=for-the-badge&logo=apachemaven&logoColor=white)

*Un proyecto de pruebas automatizadas aplicando el patrón Page Object Model (POM).* 🎀

</div>

---

## 💗 1. Descripción del Proyecto
Este proyecto es una práctica evaluable de automatización de pruebas de software sobre la web [SauceDemo](https://www.saucedemo.com/). El objetivo principal es simular el comportamiento de un usuario real (login, selección de productos y validación del carrito de compras) utilizando herramientas de calidad de software y asegurando que la aplicación responda como se espera mediante aserciones.

---

## 🌷 2. Tecnologías Usadas
* **Lenguaje:** Java
* **Framework de Pruebas:** JUnit 5 (Júpiter)
* **Automatización Web:** Selenium WebDriver
* **Gestión de Drivers:** WebDriverManager (Bonigarcia)
* **Patrón de Diseño:** Page Object Model (POM)

---

## 🎀 3. Estructura del Código

El proyecto está rigurosamente dividido en dos paquetes principales para separar la lógica de la página (Locators y Métodos) de la lógica de las pruebas (Aserciones), cumpliendo con el patrón POM.

### 📦 Paquete `pages` (Page Object Model)

#### 🌸 `LoginPage`
Gestiona la pantalla de inicio de sesión de la aplicación.
* **Localizadores (Locators):**
  * `userField` (By.id): Campo de texto para el usuario.
  * `passField` (By.id): Campo de texto para la contraseña.
  * `loginBtn` (By.id): Botón de acceso.
  * `errorMsg` (By.cssSelector): Contenedor del mensaje de error al introducir credenciales inválidas.
* **Métodos:**
  * `ingresarUsuario()`: Limpia el campo y escribe el nombre de usuario.
  * `ingresarPassword()`: Limpia el campo y escribe la contraseña.
  * `botonLogin()`: Hace clic en el botón de entrar.
  * `loginCompleto()`: Agrupa los tres métodos anteriores para un inicio de sesión rápido.
  * `mensajeError()`: Captura y devuelve el texto del error mostrado.

#### 🌸 `InventoryPage`
Representa la pantalla principal del inventario de productos y el carrito.
* **Localizadores (Locators):**
  * `botonaddMochila` / `botonaddLuz` (By.id): Botones para añadir productos específicos.
  * `botonremoveMochila` / `botonremoveLuz` (By.id): Botones que aparecen para eliminar los productos.
  * `botoncarrito` (By.className): El badge o contenedor que marca los productos seleccionados.
  * `tituloPagina` (By.className): El título de la cabecera para validaciones extra.
* **Métodos:**
  * `anadirMochila()` / `anadirLuz()`: Hacen clic en "Add to cart".
  * `obtenerTotalCarrito()`: Lee el número del carrito de compras.
  * `botonRemoveAparece()`: Comprueba con un booleano si el botón ha cambiado a estado "Remove".
  * `iraCarrito()`: Hace clic en el icono para entrar a la página del carrito.
  * `obtenerTituloPagina()`: Devuelve el texto del título actual.

### 📦 Paquete `test` (Casos de Prueba)

Todos los tests utilizan las anotaciones `@BeforeEach` (para inicializar el WebDriver con configuración de esperas implícitas) y `@AfterEach` (para cerrar el navegador de forma segura).

#### 💖 `LoginTest`
* `loginCorrecto`: Valida el acceso con credenciales válidas comprobando que la URL cambia a "/inventory".
* `loginIncorrecto`: Introduce una contraseña errónea y valida que aparezca el mensaje "Epic sadface".

#### 💖 `InventoryTest`
* `anadirProducto`: Añade una mochila y aserta que el contador del carrito es "1".
* `anadirdosProductos`: Añade dos productos diferentes y aserta que el contador es "2".
* `botoncambiaremove`: Añade un producto y verifica mediante `assertTrue` que el botón "Remove" se muestra en el DOM.
* `extraAccesoAlCarrito` *(Ampliación Extra)*: Añade un producto, navega hacia dentro del carrito y realiza una doble validación (verifica la palabra "cart" en la URL y el texto "Your Cart" en el título).

---

## 📸 4. Capturas de Ejecución

*(Sustituye la ruta de la imagen por tu captura real)*

> **Nota:** Todos los tests se han ejecutado correctamente pasando a color verde (Passed).

![Captura de Tests Exitosos](ruta/a/tu/captura.png) 

*(Si quieres subir varias, añade más líneas iguales con las rutas de tus otras imágenes)*

---

## 🧠 5. Apreciación y Reflexión Personal

Durante el desarrollo de esta tarea, mi principal aprendizaje ha sido la transición de crear scripts básicos a desarrollar **código profesional, escalable y mantenible**. Al principio de mi aprendizaje, tendía a resolver los problemas de sincronización de la página web utilizando pausas fijas en el código (`Thread.sleep()`), lo cual ralentizaba la ejecución de mis pruebas. Tras investigar y refactorizar el proyecto, logré implementar **esperas implícitas (`implicitlyWait`)**, entendiendo cómo Selenium gestiona el DOM y logrando tests mucho más ágiles.

Además, lidiar con la excepción `NoSuchElementException` me permitió comprender profundamente la diferencia entre el código HTML visible y el estado dinámico del DOM. Aprendí que cuando un elemento desaparece (como el contador del carrito al quedarse a 0) o no ha cargado, la prueba falla, lo que me llevó a afinar mis localizadores y el flujo de los métodos.

Por último, el uso riguroso del patrón **Page Object Model (POM)** y la aplicación de las convenciones de nombrado de Java (como `camelCase`) han dado como resultado un código mucho más limpio. Separar la lógica de interacción (Pages) de la lógica de aserción (Tests) hace que este proyecto no solo funcione bien ahora, sino que sea muy fácil de ampliar en el futuro. Ha sido una práctica muy enriquecedora para consolidar las bases del QA Automation. 🌸✨
