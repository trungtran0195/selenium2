package com.logigear.pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Link;
import com.logigear.control.common.imp.TextBox;
import com.logigear.pages.base.BasePage;

public class LoginPage extends BasePage {

    // Element
    private final Link registerLink = new Link("//a[.='registration page']");
    private final TextBox usernameInput = new TextBox("//input[@id='username']");
    private final TextBox passwordInput = new TextBox("//input[@id='password']");
    private final Button loginBtn = new Button("//input[@value='login']");

    // Function
    public void gotoRegisterPage() {
        registerLink.click();
    }

    public void login(String username, String password) {
        usernameInput.scrollToView();
        usernameInput.enter(username);
        passwordInput.scrollToView();
        passwordInput.enter(password);
        loginBtn.scrollToView();
        loginBtn.click();
    }
}