package com.assessment.ui.pages;

import org.openqa.selenium.By;

public class AmazonTelevisionsPage {

    public static By leftPaneItems = By.cssSelector("[class='a-section a-spacing-none']");
    public static By dropdownFilter = By.cssSelector("[class='a-dropdown-prompt']");
    public static By filterOptions = By.cssSelector("[class='a-nostyle a-list-link']");
    public static By secondElement = By.xpath("//div[contains(@class,'widgetId=search-results_2')]");
}
