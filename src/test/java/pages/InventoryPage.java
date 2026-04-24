package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    private By botonaddMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By botonaddLuz = By.id("add-to-cart-sauce-labs-bike-light");

    private By botonremoveMochila = By.id("remove-sauce-labs-backpack");
    private By botonremoveLuz = By.id("remove-sauce-labs-bike-light");

    private By botoncarrito = By.id("shopping_cart_badge");

    //Creamos el constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    //Creamos los métodos

    //Metodo para ir a la pagina del carrito
    public void iraCarrito(){
        driver.findElement(botoncarrito).click();
    }

    //Metodo para ñadir un producto al carrito
    //En este caso creamos un metodo para cliclar el boton de la mochila
    public void anadirMochila(){
        driver.findElement(botonaddMochila).click();
    }

    //Aqui hacemos click en el boton de la bici
    public void anadirLuz(){
        driver.findElement(botonaddLuz).click();
    }

    //Aqui creamos el metodo para obtener el numero total del carrito
    public String obtenerTotalCarrito(){
        return driver.findElement();
    }

    //Metodo para ver si un texto o boton aparece en la pantañña
    public boolean botonRemoveAparece(){
        return driver.findElement(botonremoveMochila).isDisplayed();
    }

    //Aqui hacemos un metodo que nos lee el producto que esta dentro del carritp
    public String NombreProducto(){
        return driver.findElement(By.className("inventory_item_name")).getText();
    }


}
