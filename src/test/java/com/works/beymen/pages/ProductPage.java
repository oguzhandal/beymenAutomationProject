package com.works.beymen.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductPage {
    @FindBy(css = "o-header__search--btn bmi-search")
    public WebElement BtnAra;
    @FindBy(xpath = "//div[@id='productList']/div[contains(@class,'productList__itemWrapper')]")
    public List<WebElement> productList;
    @FindBy(xpath = "//span[@Class='m-productCard__title']")
    public List<WebElement> productMainTitle;
    @FindBy(css = ".m-productCard__newPrice")
    public List<WebElement> productMainPrice;
    @FindBy(xpath = "//div[@id='productListSorts']")
    public WebElement filter;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getMainTitlePriceAndWriteTextFile(int index) {
        String title = productMainTitle.get(index).getText();
        String price = productMainPrice.get(index).getText();
        writerFile(title + "\n" + price);
    }

    public void selectProduct(int index) {
        productList.get(index).click();
    }


    public void writerFile(String str) {
        try {
            FileWriter myWriter = new FileWriter("productBaymen.txt");
            myWriter.write(str);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
