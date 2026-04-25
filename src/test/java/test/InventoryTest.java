package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {

    private WebDriver driver;
    private InventoryPage paginaInventory;
    private LoginPages paginalogin;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");

        paginalogin = new LoginPages(driver);
        paginaInventory = new InventoryPage(driver);
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    //Test

    //Test para añadir un producto al carrito
    @Test
    public void anadirProducto() {
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        paginaInventory.anadirMochila();

        String totalcarrito = paginaInventory.obtenerTotalCarrito();
        assertEquals("1", totalcarrito, "Error, el contador del carrito no es igual");
    }

    //Test para añadir dos producto al carrito
    @Test
    public void anadirdosProductos() {
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        paginaInventory.anadirMochila();
        paginaInventory.anadirLuz();

        String totalcarrito = paginaInventory.obtenerTotalCarrito();
        assertEquals("2", totalcarrito, "Error, el contador del carrito no es igual");
    }

    //Test para que el boton cambie
    @Test
    public void botoncambiaremove() {
        paginalogin.loginCompleto("standard_user", "secret_sauce");
        paginaInventory.anadirMochila();

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
