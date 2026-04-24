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
    public void anadirProducto() throws InterruptedException{
        paginalogin.LoginCompleto("standard_user", "secret_sauce");
        paginaInventory.anadirMochila();
        Thread.sleep(2000);
        int totalcarrito = paginaInventory.obtenerTotalCarrito();
        assertEquals(1, totalcarrito, "Error, el contador del carrito no es igual");
    }

    //Test para añadir dos producto al carrito
    @Test
    public void anadirdosProductos(){
        paginalogin.LoginCompleto("standard_user", "secret_sauce");
        paginaInventory.anadirMochila();
        paginaInventory.anadirLuz();
        int totalcarrito = paginaInventory.obtenerTotalCarrito();
        assertEquals(2, totalcarrito, "Error, el contador del carrito no es igual");
    }

    //Test para que el boton cambie
    @Test
    public void botoncambiaremove(){
        paginalogin.LoginCompleto("standard_user", "secret_sauce");
        paginaInventory.anadirMochila();
        boolean botonremoveaparece = paginaInventory.botonRemoveAparece();
        assertTrue(botonremoveaparece, "Error, el boton para eliminar no ha aparecido tras añadirlo al carrito");
    }


}
