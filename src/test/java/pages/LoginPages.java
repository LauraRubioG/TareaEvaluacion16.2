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
    private By errorMsg = By.cssSelector("h3[data-test='error']");





}
