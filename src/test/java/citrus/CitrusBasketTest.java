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
    String firstProductName = "Ноутбук Acer Swift 1 SF114-32-P8DP Obsidian Black (NX.H1YEU.025)";
    String secondProductName = "Ноутбук Acer Swift 3 SF314-56 Blue (NX.H4EEU.010)";
    String thirdProductName = "Apple iPhone Xr 64Gb Black (MRY42)";


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
    public void add2ProductsToBasketFromComparison() {
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
        //- basket total is correct
    }

    @Test
    public void UsePriceFilter() {
        homePage.waitForPageLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenuSamsung("Samsung");
        productListPage.waitForPageLoad();
        productListPage.addMinimumPrice();
        productListPage.waitForPageLoad();
        productListPage.addMaximumPrice();
        String samsungTitle = productListPage.getProductTitle();
        productListPage.waitForPageLoad();
        //3) Verify
        //- all products contain 'samsung' in name
        //- all product prices are inside of filer range

    }

    @Test
    public void useMemorySizeFilter() {
        homePage.waitForPageLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickOnLinkInMenuXiaomi("Xiaomi");
        productListPage.waitForPageLoad();
        productListPage.clickOn4GbRam();
        productListPage.waitForPageLoad();
        productListPage.clickOn6GbRam();
        productListPage.waitForPageLoad();
        //3) Verify
        //- all products contain 'Xiaomi' in name
        //- all products on the page contain memory 4 or 6gb

    }

    @Test
    public void useBodyMaterialFilter() {
        homePage.waitForPageLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickOnLinkInMenuOpnePlus("OnePlus");
        productListPage.waitForPageLoad();
        productListPage.clickOnMetalMaterialFilter();
        //3) Verify
        //- all products contain 'Google Pixel' in name
        //- all products on the page contain Metal as body material

    }

    @Test
    public void compare2Products() {
        homePage.waitForPageLoad()
                .closePopUp()
                .hoverMenuLineNetbook("Ноутбуки, планшеты, МФУ")
                .clickOnAcer("Acer");
        productListPage.waitForPageLoad();
        productListPage.finde1ProductCardByName(firstProductName);
        String first1ProductName = productListPage.getFirstProductName();
        String first1ProductPrice = productListPage.getFirst1ProductPrice();
        productListPage.clickOnAddToCompare1Product();
        productListPage.clickOnAddToCompare1Product();

        productListPage.waitForPageLoad();


        productListPage.find2ProductCardByName(secondProductName);
        String second2ProductName = productListPage.getSecondProductName();
        String second2ProductPrice = productListPage.getSecondProductPrice();
        productListPage.clickOnAddToCompare2Product();
        productListPage.clickOnAddToCompare2Product();
        productListPage.waitForPageLoad();

        productListPage.clickOnCompareButtonInHeader();
        comparePage.waitForPageLoad();
        comparePage.checkProductInCompare().shouldHaveSize(4);
//        comparePage.getProductNameFromCompareList().get(2).shouldHave(Condition.text(first1ProductName));
//        comparePage.getProductNameFromCompareList().get(0).shouldHave(Condition.text(second2ProductName));
        comparePage.getProductPrice().get(2).shouldHave(Condition.text(first1ProductPrice));
        comparePage.getProductPrice().get(0).shouldHave(Condition.text(second2ProductPrice));

        comparePage.clickOnAddNewProductInCompare();
        comparePage.findThirdProductNameElementByName(thirdProductName);
        String thirdProductName = comparePage.getThirdProductName();
        String thirdProductPrice = comparePage.getThirdProductPrice();
        comparePage.clickOnChechBox();
        comparePage.clickOnAddButton();

        comparePage.checkProductInCompare().shouldHaveSize(6);
        comparePage.getProductPrice().get(2).shouldHave(Condition.text(first1ProductPrice));
        comparePage.getProductPrice().get(0).shouldHave(Condition.text(second2ProductPrice));
        comparePage.getProductPrice().get(4).shouldHave(Condition.text(thirdProductPrice));











    }


}
