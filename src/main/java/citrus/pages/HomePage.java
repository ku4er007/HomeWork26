package citrus.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{
    SelenideElement popUpCloseButton = $(".el-dialog__close");
    public HomePage hoverMenuLine(String menuText) {
        $x("//div[@class='menu--desktop__drop-list']//a[@href='/smartfony/']/span[contains(text(),'" + menuText + "')]").hover();
        return this;

    }

    public HomePage clickLinkInMenu(String linkText) {
         $x("//div[@class='menu--desktop__drop-list']//a[@href='/smartfony/brand-apple/']/span[contains(text(),'" + linkText + "')]").click();
    return this;
    }

    public HomePage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }

    public HomePage closePopUp() {
        if(popUpCloseButton.isDisplayed()){
            popUpCloseButton.click();
        }
        return this;
    }
}
