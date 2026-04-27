package test;

//Impor necesarios para realizar la actividad, importamos librerias para que nuestro
//codigo pueda usarlas
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    //declaramos un objeto de la clase WebDriver
    private WebDriver driver;
    //Declaremos nuestro objeto de la clase LoginPages para poder usar sus metodos
    private LoginPage paginalogin;

    //BeforeEach indica que este metodo se ejecutara SIEMPRE antes de cada test
    //sirve para preparar el entorno, configura el driver, abrir el navegador e ir a la URL
    @BeforeEach
    void setUp(){
        //Configuramos automaticamente la version correcta de ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //maximizamos la ventana para evitar problemas de visualizacion responsive
        driver.manage().window().maximize();
        //PARA ESPERA: esto lo podemos hacer gracias a Selenium, le decimos que espere hasta 5 segundos
        //busca un elemento antes de lanzar un error (NoSuchElementException)
        //Esto sirve para sustituir a los Thread.sleep
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        //Navegamos a la pagina web de pruebas
        driver.get("https://www.saucedemo.com/");
        //Inicializamos nuestra pagina de LoginPages pasandole el driver
        paginalogin = new LoginPage(driver);
    }

    //AfterEach indica que este metodo se ejecutara SIEMPRE después de cada test
    //Se usa para limpiar el entorno y cerrar el navegador web
    @AfterEach
    void tearDown(){
        //Si el driver se ha instanciado correctamente, lo cerramos
        if(driver != null){
            driver.quit();
        }
    }

    //TEST
    //Test loginCorrecto
    @Test
    public void loginCorrecto() {
        //Realizamos el login con credenciales correctas
        paginalogin.loginCompleto("standard_user","secret_sauce");
        //Comprobamos, obtenemos la URL actual tras hacer el clic
        String urlActual = driver.getCurrentUrl();
        //Verificamos que la URL contenga la palabra inventory
        //El texto final es el mensaje personalizado que salta si falla
        assertTrue(urlActual.contains("inventory"), "Error: Esta url no contiene inventory después de entrar");
    }

    //Test loginIncorrecto
    @Test
    public void loginIncorrecto() {
        //intentamos entrar con un usuario valido pero una mala contraseña
        paginalogin.loginCompleto("standard_user", "contraseñanovalida");
        //capturamos el texto del recuadro de error que aparece
        String textoError = paginalogin.mensajError();
        //Verificamos que el texto de error es exactamente el esperado
        assertTrue(textoError.contains("Epic sadface"), "Error: el mensaje de contraseña y usuario no valido no ha aparecido");

    }



}
