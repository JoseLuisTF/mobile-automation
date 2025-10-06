package com.josetarazona.app.tests;

import com.josetarazona.app.base.BaseTest;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void validarInicioApp() {
        assert driver != null : "El driver NO se inicializó correctamente";
    }
}
