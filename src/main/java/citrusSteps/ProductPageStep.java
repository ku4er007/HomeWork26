package citrusSteps;

import citrus.pages.ProductPage;
import com.codeborne.selenide.Condition;

public class ProductPageStep {
    ProductPage productPage = new ProductPage();

    public String addProductToBasket() {
        productPage.clickByButton();
        return productPage.getProductPrice();
    }

    public void verifyBasketContent(String productName, String productPrice) {
        productPage.getBasket().shouldBe(Condition.visible);
        productPage.getProductNamesFromBasket().shouldHaveSize(1);
        productPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
        productPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
    }
}
