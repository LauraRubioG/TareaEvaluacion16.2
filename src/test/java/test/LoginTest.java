package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private LoginPages paginalogin;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        paginalogin = new LoginPages(driver);
    }
    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    //TEST
    //Test loginCorrecto
    @Test
    public void loginCorrecto() throws InterruptedException{
        paginalogin.LoginCompleto("standard_user","secret_sauce");
        Thread.sleep(2000);
        String urlActual = driver.getCurrentUrl();
        assertTrue(urlActual.contains("inventory"), "Error: Esta url no contiene inventory después de entrar");
    }

    //Test loginIncorrecto
    @Test
    public void loginIncorrecto() throws InterruptedException{
        paginalogin.LoginCompleto("standard_user", "contraseñanovalida");
        Thread.sleep(2000);
        String textoError = paginalogin.mensajError();
        assertTrue(textoError.contains("ha habido un error, el usuario y la contraseña no coinciden"),
                "Error: el mensaje de contraseña y usuario no valido no ha aparecido");

    }



}
