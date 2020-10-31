package citrus.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ComparePage extends BasePage {
    SelenideElement basketVidget2 = $x("//div[@class='el-dialog el-dialog--medium']");
    SelenideElement productName1 = $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'Apple iPhone 11 128Gb Green (MWM62)')]");
    SelenideElement productName2 = $x("//div[@class='catalog-item product-card__']//h5[contains(text(),'Apple iPhone 11 64Gb Red (MWLV2)')]");
    SelenideElement thirdProductName = $$x("//div[@class='compare-product']").get(0);
    SelenideElement thirdProductPrice = $$x("//span[@class='price-new']/span").get(0);

    public ComparePage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }

    public ComparePage closeBasketButton1() {
        $$x("//button[@class='el-dialog__headerbtn']//i").get(1).click();
        return this;
    }


    public ComparePage clickOnBasketInHeader() {
        $x("//div[@class='user-actions__cart h-icons__icon ctrs-basket-mini-icon']").click();
        return this;
    }

    public ComparePage clickAddToBasketButtonFirstProduct() {
        $$x("//div[@class='base-column']//i[@class='icon-new-citrus-cart el-tooltip item']").get(1).click();
        return this;
    }

    public ComparePage clickAddToBasketButtonSecondProduct() {
        $$x("//div[@class='swiper-item swiper-slide swiper-slide-active']//i[@class='icon-new-citrus-cart el-tooltip item']").get(1).click();
        return this;
    }

    public SelenideElement getBasket() {
        return basketVidget2;
    }

    public ElementsCollection getProductNames2FromBasket() {
        return $$x("//a[@class='ctrs-basket-product__name']");
    }

    public ElementsCollection getProductNameFromCompareList() {
        return $$x("//div[@class='title-itm']");
    }

    public ElementsCollection getProductPrice() {
        return $$x("//div[@class='price-itm']//div[@class='price-block']");

    }

    public ElementsCollection checkProductInCompare() {
        return $$x("//div[@class='cart-block']//div[@class='catalog-item']");
    }

    public ComparePage clickOnAddNewProductInCompare() {
        $x("//span[@class='img-container flex-column']").click();
        return this;
    }

    public ComparePage findThirdProductNameElementByName(String thirdProductName) {
        $$x("//label[@class='el-checkbox']");
        return this;
    }

    public String getThirdProductName() {
        return thirdProductName.getText();
    }

    public String getThirdProductPrice() {
        return thirdProductPrice.getText();

    }

    public ComparePage clickOnChechBox() {
        $$x("//label[@class='el-checkbox']//span[@class='el-checkbox__inner']").get(0).click();
        return this;
    }

    public ComparePage clickOnAddButton() {
        $x("//button[@class='el-button el-button--primary']").click();
        return this;
    }
}
