package citrus.pages;

import static com.codeborne.selenide.Selenide.$x;

public class ProductListPage extends BasePage {
    public ProductListPage clickOnProductByName(String productName) {

        $x("//span[contains(text(),'" + productName + "')]").click();
        return this;
    }
    public ProductListPage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }
}
