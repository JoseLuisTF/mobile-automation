package com.josetarazona.app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    @FindBy(id = "com.letterboxd.letterboxd:id/sign_out_button") // Cambia según el locator real
    private WebElement logoutButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Sign out']")
    private WebElement signOutConfirmationButton;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    public void logout() {
        log.info("Ejecutando cierre de sesion");
        click(logoutButton);
        click(signOutConfirmationButton);
    }
}
