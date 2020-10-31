package citrus.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    SelenideElement popUpCloseButton = $(".el-dialog__close");

    public HomePage hoverMenuLine(String menuText) {
        $x("//div[@class='menu--desktop__drop-list show']//a[@href='/smartfony/']/span[contains(text(),'" + menuText + "')]").hover();
        return this;
    }

    public HomePage hoverMenuLineNetbook(String menuTextNetbook) {
        $x("//div[@class='menu--desktop__drop-list show']//a[@href='/planshety-noutbuki-i-kompyutery/']/span[contains(text(),'" + menuTextNetbook + "')]").hover();
        return this;
    }

    public HomePage hoverMenuLineSamsung(String menuTextSamsung) {
        $x("//div[@class='menu--desktop__drop-list show']//a[@href='/smartfony/brand-samsung/']/span[contains(text(),'" + menuTextSamsung + "')]");
        return this;
    }

    public HomePage clickLinkInMenu(String linkText) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-apple/']/span[contains(text(),'" + linkText + "')]").click();
        return this;
    }

    public HomePage clickLinkInMenuSamsung(String linkText) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-samsung/']/span[contains(text(),'" + linkText + "')]").click();
        return this;
    }

    public HomePage clickOnLinkInMenuXiaomi(String linkText1) {
        $x("//div[@class='menu-aim__item-submenu']//a[@href='/smartfony/brand-xiaomi/']/span[contains(text(),'" + linkText1 + "')]").click();
        return this;
    }

    public HomePage clickOnLinkInMenuOpnePlus(String onePlus) {
        $x("//a[@href='/smartfony/brand-oneplus/']//span[contains(text(),'" + onePlus + "')]").click();
        return this;
    }

    public HomePage clickOnAcer(String Acer) {
        $$x("//div[@class='menu-aim__item-submenu']//a[@href='/noutbuki-i-ultrabuki/brand-acer/']/span[contains(text(),'" + Acer + "')]").get(0).click();
        return this;
    }

    public HomePage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }

    public HomePage closePopUp() {
        if (popUpCloseButton.isDisplayed()) {
            popUpCloseButton.click();
        }
        return this;
    }

    public HomePage searchQuery() {
        $x("//input[@id='search-input']").val("Apple iPhone 11").sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage searchQuery2() {
        $x("//input[@id='search-input']").val("Apple iPhone").sendKeys(Keys.ENTER);
        return this;
    }

}
