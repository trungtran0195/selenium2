package com.logigear.pages.base;

import com.logigear.control.common.imp.Label;

public class BasePage {

    // Element
    private final Label pageTitle = new Label("//h1[@align='center']");
    private final Label optionView = new Label("//option[.='%s']");

    // Function
    public boolean checkPageTitle(String title) {
        return pageTitle.getText().equals(title);
    }

    public void selectOptionTextView(String text) {
        optionView.setDynamicValue(text);
        optionView.click();
    }
}
