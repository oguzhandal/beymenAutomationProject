package com.works.beymen.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(TestWatcher.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeClass
    public static void start() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().get("https://www.beymen.com/");
        getDriver().manage().window().maximize();
    }

    @AfterClass
    public static void end() throws InterruptedException {
        getDriver().quit();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }


}
