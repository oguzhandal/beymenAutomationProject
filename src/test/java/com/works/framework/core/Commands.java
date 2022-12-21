package com.works.framework.core;

import org.openqa.selenium.WebElement;

public class Commands {

    public static void Click(WebElement webElement){
        webElement.click();
    }

    public static void SendKeys(WebElement webElement, String string){
        webElement.sendKeys(string);
    }

    public static String GetText(WebElement webElement) {
        return  webElement.getText();
    }
    public static void Delay(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
