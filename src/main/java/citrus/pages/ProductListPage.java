package citrus.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductListPage extends BasePage {
    SelenideElement productName = $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'Apple iPhone 11 128Gb Black (MWM02)')]");
    SelenideElement productName1 = $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'Apple iPhone 11 128Gb Green (MWM62)')]");
    SelenideElement productName2 = $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'Apple iPhone 11 64Gb Red (MWLV2)')]");

    SelenideElement productPrice2 = $x("//div[@class='product-card product-card--mini'][31]//span[@class='price-number']");
    SelenideElement productPrice1 = $x("//div[@class='product-card product-card--mini'][1]//span[@class='price-number']");
    SelenideElement productPrice3 = $x("//div[@class='product-card product-card--mini'][2]//span[@class='price-number']");

    SelenideElement productTitle = $x("//li[@class='item']//span[contains(text(),'samsung')]");
    SelenideElement productName3 = $x("//div[@class='product-card__name']");


    SelenideElement basketVidget = $x("//div[@class='el-dialog el-dialog--medium']");
    SelenideElement popUpCloseButton = $x("//i[@class='el-dialog__close el-icon el-icon-close']");


    public ProductListPage clickOnProductByName(String productName) {
        $x("//span[contains(text(),'" + productName + "')]").click();
        return this;
    }


    public ProductListPage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }

    public ProductListPage findeProductCardByName(String productName) {
        $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'" + productName + "')]");
        return this;
    }

    public ProductListPage findeProductCardByName1(String productName1) {
        $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'" + productName1 + "')]");
        return this;
    }

    public ProductListPage findeProductCardByName2(String productName2) {
        $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'" + productName2 + "')]");
        return this;
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductName1() {
        return productName1.getText();
    }

    public String getProductName2() {
        return productName2.getText();
    }


    public ProductListPage clickOnAddToBasket() {
        $x("//div[@class='product-card product-card--mini'][31]//i[@class='icon-new-citrus-cart el-tooltip item']").click();
        return this;
    }

    public ProductListPage clickOnAddToBasket1() {
        $x("//div[@class='product-card product-card--mini'][1]//i[@class='icon-new-citrus-cart el-tooltip item']").click();
        return this;
    }

    public ProductListPage clickOnAddToBasket2() {
        $x("//div[@class='product-card product-card--mini'][2]//i[@class='icon-new-citrus-cart el-tooltip item']").click();
        return this;
    }


    public String getProductPrice() {
        return productPrice2.getText();
    }

    public String getProductPrice1() {
        return productPrice1.getText();
    }

    public String getProductPrice2() {
        return productPrice3.getText();
    }


    public SelenideElement getBasket() {
        return basketVidget;
    }

    public ElementsCollection getProduct2NamesFromBasket() {
        return $$x("//a[@class='ctrs-basket-product__name']");
    }

    public SelenideElement getBasketTotalPrice2() {
        return $x("//span[@class='ctrs-main-price ctrs-basket-footer__new-price']");
    }

    public ProductListPage clickShowMoreButton() {
        $x("//a[@class='catalog-card-container more-items product-card product-card--mini']").click();
        return this;
    }

    public ProductListPage closePopUp2() {
        if (popUpCloseButton.isDisplayed()) {
            popUpCloseButton.click();
        }
        return this;
    }

    public ProductListPage closeBasketButton() {
        $$x("//button[@aria-label='Close'][@class='el-dialog__headerbtn']").get(1).click();
        return this;
    }

    public ProductListPage clickOnAddToCompare1() {
        $x("//div[@class='product-card product-card--mini'][1]//i[@class='icon-comparison2 el-tooltip item']").click();
        return this;
    }

    public ProductListPage clickOnAddToCompare2() {
        $x("//div[@class='product-card product-card--mini'][2]//i[@class='icon-comparison2 el-tooltip item']").click();
        return this;
    }

    public ProductListPage clickOnCompareButton() {
        $x("//div[@class='user-actions__compare tips-parent']").click();
        return this;
    }

    public ProductListPage addMinimumPrice() {
        $$x("//input[@class='el-input__inner']").get(0).val("7000");
        return this;
    }
    public ProductListPage addMaximumPrice() {
        $$x("//input[@class='el-input__inner']").get(1).val("15000");
        return this;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getAllProdactName() {
        return productName3.getText();
    }


//    public ProductListPage clickOnPageSamsungTitle() {
//        $x("//h1[contains(text(),'Смартфоны Samsung')]").click();
//        return this;
//    }
}
