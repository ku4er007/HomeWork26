package citrus.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductListPage extends BasePage {
    SelenideElement productName = $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'Apple iPhone 11 128Gb Black (MWM02)')]");
    SelenideElement productPrice2 = $x("//div[@class='product-card product-card--mini'][31]//span[@class='price-number']");
    SelenideElement basketVidget = $x("//div[@class='el-dialog el-dialog--medium']");
    SelenideElement popUpCloseButton= $x("//i[@class='el-dialog__close el-icon el-icon-close']");


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

    public String getProductName() {
        return productName.getText();
    }

    public ProductListPage clickOnAddToBasket() {
        $x("//div[@class='product-card product-card--mini'][31]//i[@class='icon-new-citrus-cart el-tooltip item']").click();
        return this;
    }

    public String getProductPrice() {
        return productPrice2.getText();
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
    public ProductListPage closePopUp2(){
        if(popUpCloseButton.isDisplayed()){
            popUpCloseButton.click();
        }
        return this;
    }
}
