package com.josetarazona.app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "com.letterboxd.letterboxd:id/username")
    private WebElement userInput;

    @FindBy(id = "com.letterboxd.letterboxd:id/password")
    private WebElement passwordInput;

    @FindBy(id = "com.letterboxd.letterboxd:id/go_button")
    private WebElement goButton;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage loginAs(String username, String password) {
        log.info("Ejecutando login con credenciales cargadas");
        sendKeys(userInput, username);
        sendKeys(passwordInput, password);
        log.info("Ejecutando click en boton de login");
        click(goButton);
        return new HomePage(driver);
    }

}
