package com.josetarazona.app.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class DriverFactory {

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    public static AppiumDriver initializeDriver(String platformName) throws Exception {

        try (InputStreamReader reader = new InputStreamReader(
                Objects.requireNonNull(DriverFactory.class.getClassLoader()
                        .getResourceAsStream("config/capabilities.json"))
        )) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            if (!jsonObject.has(platformName.toLowerCase())) {
                throw new RuntimeException("No se encontraron capacidades para la plataforma: " + platformName);
            }

            JsonObject caps = jsonObject.getAsJsonObject(platformName.toLowerCase());

            if (platformName.equalsIgnoreCase("android")) {
                UiAutomator2Options options = new UiAutomator2Options();
                caps.entrySet().forEach(e -> options.setCapability(e.getKey(), e.getValue().getAsString()));
                return new AndroidDriver(new URL(APPIUM_SERVER_URL), options);

            } else if (platformName.equalsIgnoreCase("ios")) {
                XCUITestOptions options = new XCUITestOptions();
                caps.entrySet().forEach(e -> options.setCapability(e.getKey(), e.getValue().getAsString()));
                return new IOSDriver(new URL(APPIUM_SERVER_URL), options);
            }

            throw new IllegalArgumentException("Plataforma no soportada: " + platformName);
        }
    }
}
