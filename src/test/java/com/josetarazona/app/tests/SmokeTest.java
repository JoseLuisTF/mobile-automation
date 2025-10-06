package com.josetarazona.app.tests;

import com.josetarazona.app.base.BaseTest;
import com.josetarazona.app.models.Credentials;
import com.josetarazona.app.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void testLoginFlow() {
        LandingPage landingPage = new LandingPage(driver);

        // Paso 1 - Abrir la aplicacion
        LoginPage loginPage = landingPage.goToLoginPage();

        // Paso 2 - Hacer login con credenciales validas
        Credentials credentials = Credentials.fromProperties();
        HomePage homePage = loginPage.loginAs(credentials.getUsername(), credentials.getPassword());

        // Paso 3 - Validar que la pantalla principal ha cargado correctamente
        homePage.handleModalsIfPresent();
        Assert.assertTrue(homePage.isLoggedIn(), "El usuario no aparece como logueado luego del login.");

        // Paso 4 - Cerrar sesion
        ProfilePage profilePage = homePage.goToProfilePage();
        SettingsPage settingsPage = profilePage.goToSettingsPage();
        settingsPage.logout();
        Assert.assertFalse(homePage.isLoggedIn(), "El usuario sigue logueado tras cerrar sesión.");


    }
}
