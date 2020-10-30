package citrus.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ComparePage extends BasePage {

    public ComparePage waitForPageLoad() {
        super.waitForPageLoad();
        return this;
    }

//
//    public ComparePage findeProductCardByName1(String productName1) {
//        $x("//a[@href='/smartfony/iphone-11-64gb-red-apple-653220.html'][contains(text(),'Apple iPhone 11 64Gb Red (MWLV2)')]");
////        $x("//div[@class='base-column']//i[@class='icon-new-citrus-cart el-tooltip item']");
//        return this;
//    }

    public ComparePage closeBasketButton1() {
        $$x("//button[@class='el-dialog__headerbtn']//i").get(1).click();
//        $x("//button[@aria-label='Close'][@class='el-dialog__headerbtn']").click();
        return this;
    }
//
//    public ComparePage findeProductCardByName2(String productName2) {
//        $$x("//div[@class='swiper-item swiper-slide swiper-slide-active']//i[@class='icon-new-citrus-cart el-tooltip item']").get(0).click();
//        return this;
//    }

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
}
