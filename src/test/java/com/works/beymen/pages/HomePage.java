package com.works.beymen.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptCookieBtn;
    @FindBy(xpath = "//button[@Class='o-modal__closeButton bwi-close']")
    public WebElement popupClose;
    @FindBy(xpath = "//input[@Class='default-input o-header__search--input']")
    public WebElement searchBox;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookie() {
        // if (acceptCookieBtn.isDisplayed()) {
        acceptCookieBtn.click();
        //}
    }

    public void closePopup() {
        if (popupClose.isDisplayed()) {
            popupClose.click();
        }
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        searchBox.sendKeys(productName);
    }

    public void searchButton() {
        searchBox.sendKeys(Keys.ENTER);
    }
}



