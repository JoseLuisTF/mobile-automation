package com.josetarazona.app.pages;


import com.josetarazona.app.util.GestureUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {


    protected AppiumDriver driver;
    protected GestureUtils gestures;
    protected WebDriverWait wait;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        gestures = new GestureUtils(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void click(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            waitUntilVisible(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void swipeLeftTimes(int times) {
        log.info("Ejecutando {} swipes hacia la izquierda", times);
        for (int i = 0; i < times; i++) {
            gestures.swipeLeft();
        }
    }

    protected void logInfo(String message) {
        log.info(message);
    }

    protected void logError(String message, Throwable t) {
        log.error(message, t);
    }

}
