package com.works.framework.core;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Asserts {
    public static void AssertTrue(WebElement webElement, String string){
        String result = Commands.GetText(webElement);
        Assert.assertTrue(result.contains(string));
    }

    public static void AssertTrue(String string1, String string2){
        Assert.assertTrue(string1.contains(string2));
    }


    public static void AssertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }
}
