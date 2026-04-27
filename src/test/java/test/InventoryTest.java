package test;
//importacion de la libreria
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {

    private WebDriver driver;
    //declaremos los objetos de ambas clases para poder usar sus metodos
    private InventoryPage paginaInventory;
    private LoginPage paginalogin;

    //Volvemos a crear el BeforeEach como hemos visto antes
    //usando las mimas acciones que hemos visto en la pagina de LonginTest
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");

        paginalogin = new LoginPage(driver);
        paginaInventory = new InventoryPage(driver);
    }

    //Volvemos a usar el AfterEach para limpiar el entorno despues de cada test
    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    //---TEST--

    //Test para verificar que al añadir un solo producto, el contador del carrito se
    //actualiza a 1
    @Test
    public void anadirProducto() {
        //Iniciamos sesion
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        //añadimos la mochila al carrito
        paginaInventory.anadirMochila();
        //comprobamos, leemos el total y verificamos que sea exactamente 1
        String totalcarrito = paginaInventory.obtenerTotalCarrito();
        assertEquals("1", totalcarrito, "Error, el contador del carrito no es igual");
    }

    //Test para verificar que al añadir varios productos, el contador los suma correctamente
    @Test
    public void anadirdosProductos() {
        //Iniciamos sesion
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        //añadimos los dos productos distintos
        paginaInventory.anadirMochila();
        paginaInventory.anadirLuz();
        //comprobamos, leemos el total y verificamos que sea exactamente 2
        String totalcarrito = paginaInventory.obtenerTotalCarrito();
        assertEquals("2", totalcarrito, "Error, el contador del carrito no es igual");
    }

    //Test para que el boton cambie
    @Test
    public void botoncambiaremove() {
        //inicioamos sesion
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        //añadimos un producto
        paginaInventory.anadirMochila();
        //comprobamos, consultamos a la pagina si el boton de eliminar es ahora visible
        boolean botonremoveaparece = paginaInventory.botonRemoveAparece();
        assertTrue(botonremoveaparece, "Error, el boton para eliminar no ha aparecido tras añadirlo al carrito");
    }

    //Test del Metodo Adicional: Test Comprobamos el titulo de la pagina
    @Test
    public void extraAccesoAlCarrito(){
        //Iniciamos sesion
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        //Añadimos un producto
        paginaInventory.anadirMochila();
        //Hacemos clic en el icono del carrito usando el metodo que hemos creado extra
        paginaInventory.iraCarrito();
        //Comprobamos primero y verificamos que la URL ha cambiado a la del carrito
        String urlActual = driver.getCurrentUrl();
        assertTrue(urlActual.contains("cart"), "Error: la URL no contiene la palabra cart depues de clic");
        //Comprobamos segundo y verificamos que el titulo de la pantalla es el correcto
        String tituloPantalla = paginaInventory.obtenerTituloPagina();
        assertEquals("Your Cart", tituloPantalla, "Error: el titulo del carrito no coincide");
    }


}
