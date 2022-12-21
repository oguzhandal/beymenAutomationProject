package com.works.beymen.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetailPage {
    @FindBy(xpath = "//div[(@Class='m-variation')]/span[not(@Class='m-variation__item -disabled')]")
    public WebElement productSize;
    @FindBy(css = "#addBasket")
    public WebElement addToBasketButton;
    @FindBy(css = "o-header__userInfo--count")
    public WebElement basketSize;
    @FindBy(xpath = "//div[@Class='o-header__userInfo']/a[3]")
    public WebElement goToBasket;

    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectSize() {
        productSize.click();
    }

    public void addToBasket() {
        addToBasketButton.click();
    }

    public void validateBasketSize() {
        //Commands.WaitUntilVisible(basketSize);
    }

    public void goToBasket() {
        //Commands.Delay(10);
        goToBasket.click();
    }
}
