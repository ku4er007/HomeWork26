package citrusSteps;

import citrus.pages.HomePage;

public class HomePageStep {
    HomePage homePage = new HomePage();


    public void clickOnLinkInMenu(String text) {
        homePage.waitForPageLoad()
                .closePopUp()
                .hoverMenuLine("Смартфоны")
                .clickLinkInMenu(text );
    }

    public void searchQuery() {
        homePage.waitForPageLoad()
                .closePopUp()
                .searchQuery();
    }
}
