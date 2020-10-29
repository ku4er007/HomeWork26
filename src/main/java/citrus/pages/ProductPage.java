package citrus.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage {
    SelenideElement productPrice = $x("//div[@class='price']/span/span");
    SelenideElement byButton = $x("//button[@class='btn orange full'][@type='button']");
    SelenideElement basketVidget = $x("//div[@class='el-dialog el-dialog--medium']");

    public String getProductPrice() {
        return productPrice.getText();
    }

    public ProductPage clickByButton() {
        byButton.shouldBe(Condition.enabled).click();
        return this;
    }

    public SelenideElement getBasket() {
        return basketVidget;
    }

    public ElementsCollection getProductNamesFromBasket() {
        return $$x("//a[@class='ex-active active ctrs-basket-product__name']");

    }

    public SelenideElement getBasketTotalPrice() {
        return $x("//span[@class='ctrs-main-price ctrs-basket-footer__new-price']");
    }
    public ProductPage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }
}
