package citrusSteps;

import citrus.pages.ProductListPage;
import com.codeborne.selenide.Condition;

public class ProductListPageStep {
    ProductListPage productListPage = new ProductListPage();

    public void clickOnProduct(String productName) {
        productListPage.clickOnProductByName(productName);
    }

    public void closePopUp() {
        productListPage.clickShowMoreButton()
                .waitForPageLoad()
                .closePopUp2();
    }

    public void findeProduct(String productName) {
        productListPage.findeProductCardByName(productName);

    }

    public String addToBasket() {
        productListPage.clickOnAddToBasket();
        return productListPage.getProductName();

    }

    public void verifyBasket() {
        productListPage.getBasket().shouldBe(Condition.visible);
        productListPage.getProduct2NamesFromBasket().shouldHaveSize(1);
        productListPage.getProduct2NamesFromBasket().get(0).shouldHave(Condition.text(productName));
        productListPage.getBasketTotalPrice2().shouldHave(Condition.text(productPrice));
    }

    public String addToBasket2() {
        return productListPage.addToBasket2();
    }
}
