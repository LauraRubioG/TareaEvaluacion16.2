package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {
    //Es la pieza fundamental de Selenium. Actua como puente de cominucación
    //entre nuestro script de programación y el navegador web
    private WebDriver driver;

    //"Guarda en la variable userField la instruccion de buscar un elemento cuyo
    // atributo id sea exactamente user-name" Siempre hay que comprobar el id del
    //html que estemos haciendo, porque hay que poner el nombre excato
    //By se usa para buscar, en este caso By.id() que es mucho mas concreto, auqnue se puede usar apra otras etiquetas
    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");

    //cssSelector es mas potente ya que permite ser muy específico
    private By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPages(WebDriver driver){
        this.driver = driver;
    }
    //metodo para ingresar el usurio
    public void ingresarUsuario(String usuario){
        //primero usamos el metodo clear para borrar lo que haya previamente escrito
        driver.findElement(userField).clear();
        driver.findElement(userField).sendKeys(usuario);
    }
    //metodo para ingresar la contrasena
    public void ingresarPassword(String password){
        driver.findElement(passField).clear();
        driver.findElement(passField).sendKeys(password);
    }
    //metodo que pulsa el boton de acceso
    public void botonLogin(){
        driver.findElement(loginBtn).click();
    }

    //metodo que hace el login entero
    public void loginCompleto(String usuario, String password){
        ingresarUsuario(usuario);
        ingresarPassword(password);
        botonLogin();
    }

    //metodo para el mensaje de error
    public String mensajError(){
        return driver.findElement(errorMsg).getText();
    }





}
