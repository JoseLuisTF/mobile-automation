package com.josetarazona.app.pages;

import com.josetarazona.app.util.ModalHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private final ModalHandler modalHandler;

    @FindBy(id = "com.letterboxd.letterboxd:id/nav_profile")
    private WebElement profileButtonNav;

    public HomePage(AppiumDriver driver) {
        super(driver);
        modalHandler = new ModalHandler(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void handleModalsIfPresent() {
        log.info("Cerrando los modales");
        modalHandler.acceptAndroidNotificationPermissionIfPresent();
        modalHandler.dismissAppPopupIfPresent();
    }

    public boolean isLoggedIn() {
        log.info("Validando visibilidad del boton de Perfil");
        return isDisplayed(profileButtonNav);
    }

    public ProfilePage goToProfilePage(){
        log.info("Navegando a Perfil");
        click(profileButtonNav);
        return new ProfilePage(driver);
    }

}
