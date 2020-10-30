package citrus;

import citrus.pages.HomePage;
import citrus.pages.ProductListPage;
import citrus.pages.ProductPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CitrusBasketTest {
    HomePage homePage;
    ProductListPage productListPage;
    ProductPage productPage;

    String productName = "Apple iPhone 11 128Gb Black";



    @BeforeClass
    public void startUp() {
        Configuration.baseUrl = "https://www.citrus.ua/";
        open("");
        homePage = new HomePage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
    }

    @Test
    public void addProductToBasket() {
        homePage.waitForPageLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu("Apple");
        productListPage.clickOnProductByName(productName);
        String productPrice = productPage.getProductPrice();
        productPage.clickByButton();

        productPage.getBasket().shouldBe(Condition.visible);
        productPage.getProductNamesFromBasket().shouldHaveSize(1);
        productPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
        productPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
    }

    @Test
    public void addProductToBasketUsingSearch() {
        homePage.waitForPageLoad()
                .closePopUp()
                .searchQuery();

        productListPage.clickShowMoreButton()
                .waitForPageLoad()
                .closePopUp2();
        productListPage.findeProductCardByName(productName);
        String productName = productListPage.getProductName();
        productListPage.clickOnAddToBasket();
        String productPrice = productListPage.getProductPrice();

        productListPage.getBasket().shouldBe(Condition.visible);
        productListPage.getProduct2NamesFromBasket().shouldHaveSize(1);
        productListPage.getProduct2NamesFromBasket().get(0).shouldHave(Condition.text(productName));
        productListPage.getBasketTotalPrice2().shouldHave(Condition.text(productPrice));

    }

}
