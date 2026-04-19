package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.LoginPages;

public class LoginTest {

    private WebDriver driver;
    private LoginPages paginalogin;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver + new ChromeDriver;
        driver.manage

    }



}
