package com.works.beymen.tests;

import com.works.beymen.core.BaseTest;
import com.works.beymen.pages.BasketPage;
import com.works.beymen.pages.HomePage;
import com.works.beymen.pages.ProductDetailPage;
import com.works.beymen.pages.ProductPage;
import com.works.framework.core.Commands;
import com.works.framework.core.ExcelOperations;
import org.junit.Test;

public class CartPageTest extends BaseTest {

    ProductDetailPage productDetailPage;
    HomePage homePage;
    ProductPage productPage;
    BasketPage basketPage;
    ExcelOperations excelOperations = new ExcelOperations();

    @Test
    public void senaryo_1() {
        productDetailPage = new ProductDetailPage(getDriver());
        homePage = new HomePage(getDriver());
        productPage = new ProductPage(getDriver());
        basketPage = new BasketPage(getDriver());

        Commands.Delay(2);
        homePage.acceptCookie();
        homePage.closePopup();
        String path = "src/test/Resources/searchBox.xlsx";
        String urun1 = excelOperations.getData(path, 1, 1, 1);
        String urun2 = excelOperations.getData(path, 1, 1, 2);

        homePage.searchProduct(urun1);
        Commands.Delay(2);
        homePage.searchProduct(urun2);
        homePage.searchButton();
        Commands.Delay(2);
        Commands.Delay(3);
        productPage.getMainTitlePriceAndWriteTextFile(10);
        productPage.selectProduct(10);

        productDetailPage.selectSize();
        productDetailPage.addToBasket();
        productDetailPage.validateBasketSize();
        productDetailPage.goToBasket();

        Commands.Delay(4);
        basketPage.getTitlePriceAndAssertTextFile();
        Commands.Delay(2);
        String price = basketPage.productPrice.getText();
        basketPage.countAndValidateSelectedProduct();
        Commands.Delay(2);
        basketPage.validateProductChanging(price);
        basketPage.deleteProduct();
        Commands.Delay(2);
        basketPage.validateEmptyBasket("SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");

    }
}
