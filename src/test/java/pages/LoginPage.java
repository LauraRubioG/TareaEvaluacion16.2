package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Es la pieza fundamental de Selenium. Actua como puente de cominucación
    //entre nuestro script de programación y el navegador web
    private WebDriver driver;

    //-----LOCALIZADORES-----
    //"Guarda en la variable userField la instruccion de buscar un elemento cuyo
    // atributo id sea exactamente user-name" Siempre hay que comprobar el id del
    //html que estemos haciendo, porque hay que poner el nombre excato
    //By se usa para buscar, en este caso By.id() que es mucho mas concreto, auqnue se puede usar apra otras etiquetas
    //localizador para el usuario
    private By userField = By.id("user-name");
    //localizados para la contraseña
    private By passField = By.id("password");
    //localizador para el boton de acceso
    private By loginBtn = By.id("login-button");

    //cssSelector es mas potente ya que permite ser muy específico
    private By errorMsg = By.cssSelector("[data-test='error']");

    //---CONSTRUCTOR DE LA CLASE---
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //---METODOS--
    //metodo para ingresar el usurio
    public void ingresarUsuario(String usuario){
        //primero usamos el metodo clear para borrar lo que haya previamente escrito
        driver.findElement(userField).clear();
        //sendkeys simula las pulsaciones del teclado para escribir el testo
        driver.findElement(userField).sendKeys(usuario);
    }
    //metodo para ingresar la contrasena
    public void ingresarPassword(String password){
        driver.findElement(passField).clear();
        driver.findElement(passField).sendKeys(password);
    }
    //metodo que pulsa el boton de acceso
    public void botonLogin(){
        //usamos click para hacer la opcion de pulsar
        driver.findElement(loginBtn).click();
    }

    //metodo que hace el login entero
    public void loginCompleto(String usuario, String password){
        //reutilizamos los metodos anteriores para mantener el codigo limpio
        ingresarUsuario(usuario);
        ingresarPassword(password);
        botonLogin();
    }

    //metodo para el mensaje de error
    public String mensajError(){
        //devuelve el string del mensaje de error
        return driver.findElement(errorMsg).getText();
    }

}
