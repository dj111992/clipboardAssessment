import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.assessment.ui.actions.BaseActions;
import com.assessment.ui.actions.Waits;
import com.assessment.ui.pages.SamsungTelevisionsPage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static com.assessment.ui.pages.AmazonMainPage.hamburgerItem;
import static com.assessment.ui.pages.AmazonMainPage.spaceWebListPopUp;
import static com.assessment.ui.pages.AmazonTelevisionsPage.dropdownFilter;
import static com.assessment.ui.pages.AmazonTelevisionsPage.secondElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();
    Logger logger = Logger.getLogger("Test SandBox");

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        driver.quit();
    }

    @Test
    void assertSamsungPageOpeningInChildWindow() {
        BaseActions baseActions = new BaseActions();
        Waits waits = new Waits();

        driver.get(HOME_PAGE_URL);

        waits.waitForSometime(driver, 2000);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        baseActions.clickButton(driver, hamburgerItem);
        baseActions.MAIN_PAGE_WEB_POP.accept("TV, Appliances, Electronics", driver);
        waits.waitForElementVisibility(driver, spaceWebListPopUp);
        baseActions.MAIN_PAGE_WEB_POP.accept("Televisions", driver);

        waits.waitForSometime(driver, 2000);
        assertEquals("Buy the latest LED TVs, 4K TVs and Android TVs online at Best Prices in India-Amazon.in | Shop by size, price, features and more", driver.getTitle());
        baseActions.ITEM_PAGE_WEB_POP.accept("Samsung", driver);
        baseActions.clickButton(driver, dropdownFilter);
        BaseActions.FILTER_DROPDOWN.accept("Price: High to Low", driver);
        baseActions.clickButton(driver, secondElement);

        baseActions.windowHandles(driver);

        waits.waitForElementVisibility(driver, SamsungTelevisionsPage.aboutSection);
        logger.info(driver.findElement(SamsungTelevisionsPage.aboutSection).getText());
        driver.quit();
    }

}
