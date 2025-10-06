package com.josetarazona.app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(id = "com.letterboxd.letterboxd:id/tour_button_sign_in")
    private WebElement loginButton;

    public LandingPage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage clickLogin() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public LoginPage goToLoginPage() {
        logInfo("Navegando hacia el login");
        swipeLeftTimes(6);
        logInfo("Esperando visibilidad de boton login");
        waitUntilVisible(loginButton);
        logInfo("Ejecutando click en boton de login");
        click(loginButton);
        return new LoginPage(driver);
    }

}
