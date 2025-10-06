package com.josetarazona.app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(className = "android.widget.ImageButton")
    private WebElement settingsButton;

    public ProfilePage(AppiumDriver driver) {
        super(driver);
    }

    public SettingsPage goToSettingsPage() {
        log.info("Navegando a Ajustes");
        click(settingsButton);
        return new SettingsPage(driver);
    }
}
