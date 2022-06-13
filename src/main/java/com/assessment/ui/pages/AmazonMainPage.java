package com.assessment.ui.pages;

import org.openqa.selenium.By;

public class AmazonMainPage {

    public static By hamburgerItem = By.cssSelector("[id='nav-hamburger-menu']");
    public static By spaceWebListPopUp = By.xpath("//ul[contains(@class,'hmenu hmenu-visible')]");
    public static By options = By.cssSelector("li");
    public static By anchorOptions = By.cssSelector("a");
}
