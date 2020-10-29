package citrus;

import citrus.pages.HomePage;
import citrus.pages.ProductListPage;
import citrus.pages.ProductPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CitrusBasketTest {
    HomePage homePage;
    ProductListPage productListPage;
    ProductPage productPage;

    String productName = "Apple iPhone 11 128Gb Black (MWM02)";

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
        productPage.getBasketTotalPrice().shouldHave(Condition.text(productName));


    }
}
