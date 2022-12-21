package com.works.framework.core;

import org.openqa.selenium.WebElement;

public class Conditions {
    public static boolean isDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }
}
