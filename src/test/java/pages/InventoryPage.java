package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class InventoryPage {
    //WebDriver permite la interaccion con el navegador
    private WebDriver driver;

    //---LOCALIZADORES---
    //botones para añadir productos al carrito
    private By botonaddMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By botonaddLuz = By.id("add-to-cart-sauce-labs-bike-light");
    //botones para eliminar productos del carrito
    private By botonremoveMochila = By.id("remove-sauce-labs-backpack");
    private By botonremoveLuz = By.id("remove-sauce-labs-bike-light");
    //localizador del badge, que muestra la cantidad de productos en el carrito
    private By botoncarrito = By.className("shopping_cart_badge");
    //localizador del titulo de la cabecera de la pagina
    private By tituloPagina = By.className("title");

    //Creamos el constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    //---METODOS---

    //Metodo para ir a la pagina del carrito
    public void iraCarrito(){
        //hace clic sobre el icono del carrito de la compra en la esquina superior
        driver.findElement(botoncarrito).click();
    }

    //Metodo para añadir un producto al carrito
    //En este caso creamos un metodo para cliclar el boton de la mochila
    public void anadirMochila(){
        driver.findElement(botonaddMochila).click();
    }

    //Metodo para añadir un segundo producto
    //Aqui hacemos click en el boton de la bici
    public void anadirLuz(){
        driver.findElement(botonaddLuz).click();
    }

    //Aqui creamos el metodo para obtener el numero total del carrito
    public String obtenerTotalCarrito(){
        return driver.findElement(botoncarrito).getText();
    }

    //Metodo para ver si un texto o boton aparece en la pantaña
    //verifica si el boton rojo de remove sale en pantaña cuando lo añadimos al carrito
    public boolean botonRemoveAparece(){
        return driver.findElement(botonremoveMochila).isDisplayed();
    }

    //Metodo Adicional: Metodo para obtener el titulo de la pantalla actual

    public String obtenerTituloPagina(){
        return driver.findElement(tituloPagina).getText();
    }


}
