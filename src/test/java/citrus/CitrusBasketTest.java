package citrus;

import citrus.pages.ComparePage;
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
    ComparePage comparePage;
    String productName = "Apple iPhone 11 128Gb Black";
    String productName1 = "Apple iPhone 11 128Gb Green (MWM62)";
    String productName2 = "Apple iPhone 11 64Gb Red (MWLV2)";


    @BeforeClass
    public void startUp() {
        Configuration.baseUrl = "https://www.citrus.ua/";
        open("");
        homePage = new HomePage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        comparePage = new ComparePage();
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

    @Test
    public void Add2ProductsToBasket() {
        homePage.waitForPageLoad()
                .closePopUp()
                .searchQuery2();
        productListPage
                .waitForPageLoad()
                .closePopUp2();

        productListPage.findeProductCardByName1(productName1);
        String productName1 = productListPage.getProductName1();
        productListPage.clickOnAddToBasket1();
        String productPrice1 = productListPage.getProductPrice1();
        productListPage.closeBasketButton();

        productListPage.findeProductCardByName2(productName2);
        String productName2 = productListPage.getProductName2();
        productListPage.clickOnAddToBasket2();
        String productPrice2 = productListPage.getProductPrice2();



        productListPage.getBasket().shouldBe(Condition.visible);
        productListPage.getProduct2NamesFromBasket().shouldHaveSize(2);
        productListPage.getProduct2NamesFromBasket().get(0).shouldHave(Condition.text(productName1));
        productListPage.getProduct2NamesFromBasket().get(1).shouldHave(Condition.text(productName2));

//        productListPage.getBasketTotalPrice2().shouldHave(Condition.text(productPrice1 + productPrice2));
//        productListPage.getBasketTotalPrice2().shouldHave(Condition.text(productPrice2));
        //need chaeck total price
    }
    @Test
    public void add2ProductsToBasketFromComparison(){
        homePage.waitForPageLoad()
                .closePopUp()
                .searchQuery2();
        productListPage
                .waitForPageLoad()
                .closePopUp2();

        productListPage.findeProductCardByName1(productName1);
        String productName1 = productListPage.getProductName1();
        productListPage.clickOnAddToCompare1();
        String productPrice1 = productListPage.getProductPrice1();

        productListPage.findeProductCardByName2(productName2);
        String productName2 = productListPage.getProductName2();
        productListPage.clickOnAddToCompare2();
        String productPrice2 = productListPage.getProductPrice2();
        productListPage.clickOnCompareButton();

        comparePage.clickAddToBasketButtonFirstProduct();
        comparePage.closeBasketButton1();


        comparePage.clickAddToBasketButtonSecondProduct();
        comparePage.closeBasketButton1();

        comparePage.clickOnBasketInHeader()
                .waitForPageLoad();
        comparePage.getBasket().shouldBe(Condition.visible);
        comparePage.getProductNames2FromBasket().shouldHaveSize(2);
        comparePage.getProductNames2FromBasket().get(0).shouldHave(Condition.text(productName1));
        comparePage.getProductNames2FromBasket().get(1).shouldHave(Condition.text(productName2));
//need check total price
    }



}
