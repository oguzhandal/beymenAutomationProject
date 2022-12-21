package com.works.beymen.pages;


import com.works.framework.core.Commands;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BasketPage {
    @FindBy(xpath = "//strong[@Class='m-basket__productInfoCategory']")
    public WebElement productTitle;
    @FindBy(xpath = "//span[@Class='m-productPrice__salePrice']")
    public WebElement productPrice;
    @FindBy(xpath = "//select[@id='quantitySelect0-key-0']")
    public WebElement selectedProductCount;
    @FindBy(xpath = "//strong[@class='m-empty__messageTitle'][1]")
    public WebElement emptyElement;
    @FindBy(css = "#removeCartItemBtn0-key-0")
    public WebElement deleteBtn;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getTitlePriceAndAssertTextFile() {
        String title = productTitle.getText();
        String price = productPrice.getText();

        ArrayList<String> array = readFile();
        Assert.assertEquals(title, array.get(0).toUpperCase().replaceAll("İ", "I"));
        Assert.assertEquals(price, array.get(1).toUpperCase());

    }
    public void validateProductChanging(String expectedValue) {
        String actualValue = productPrice.getText();
        if (actualValue.equals(expectedValue)){
            Assert.fail("Prices are equals!");
        }
    }

    public void countAndValidateSelectedProduct() {
        Commands.Click(selectedProductCount);
        Commands.Delay(1);
        Select select = new Select(selectedProductCount);
        select.selectByIndex(1);
        Commands.Click(selectedProductCount);
    }

    public void deleteProduct() {
        deleteBtn.click();
    }

    public void validateEmptyBasket(String expectedResult) {
        String actualResult = emptyElement.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    public ArrayList<String> readFile() {
        try {
            FileReader fr = new FileReader("productBaymen.txt");
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> array = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                array.add(line);
            }

            br.close();
            fr.close();
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
