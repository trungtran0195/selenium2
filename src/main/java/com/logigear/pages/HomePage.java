package com.logigear.pages;

import com.logigear.control.common.imp.Link;
import com.logigear.data.enums.HomePageNavigate;
import com.logigear.pages.base.BasePage;

public class HomePage extends BasePage {

    // Element
    private final Link lnkHomeOption = new Link("//span[text()='%s']");
    private final Link lnkHomeOptionHighlight = new Link("//li[@class='selected']//span[text()='%s']");

    // Function
    public void navigateToPage(HomePageNavigate homePageNavigate) {
        lnkHomeOption.setDynamicValue(homePageNavigate.getValue());
        lnkHomeOption.click();
        lnkHomeOptionHighlight.setDynamicValue(homePageNavigate.getValue());
        lnkHomeOptionHighlight.waitForDisplay();
    }
}
