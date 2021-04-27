package com.logigear.pages.base;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;
import com.logigear.data.enums.HomePageNavigate;

public class BasePage {

    // Element
    private final Label pageTitle = new Label("//h1[@align='center']");
    private final Label optionView = new Label("//option[.='%s']");
    private final Link lnkHomeOption = new Link("//span[text()='%s']");
    private final Link lnkHomeOptionHighlight = new Link("//li[@class='selected']//span[text()='%s']");


    // Function
    public boolean checkPageTitle(String title) {
        return pageTitle.getText().equals(title);
    }

    public void selectOptionTextView(String text) {
        optionView.setDynamicValue(text);
        optionView.waitForElementClickable();
        optionView.click();
    }

    public void navigateToPage(HomePageNavigate homePageNavigate) {
        lnkHomeOption.setDynamicValue(homePageNavigate.getValue());
        lnkHomeOption.click();
        lnkHomeOptionHighlight.setDynamicValue(homePageNavigate.getValue());
        lnkHomeOptionHighlight.waitForDisplay();
    }
}
