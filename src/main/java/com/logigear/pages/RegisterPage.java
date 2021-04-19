package com.logigear.pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import com.logigear.pages.base.BasePage;

public class RegisterPage extends BasePage {

    // Element
    private final TextBox emailInput = new TextBox("//input[@id='email']");
    private final TextBox passwordInput = new TextBox("//input[@id='password']");
    private final TextBox confirmPasswordInput = new TextBox("//input[@id='confirmPassword']");
    private final TextBox idInput = new TextBox("//input[@id='pid']");
    private final Button registerBtn = new Button("//input[@value='Register']");
    private final Label errorMessage = new Label("//p[@class='message error']");

    // Function
    public void registerNewAccount(String email, String password, String id) {
        emailInput.scrollToView();
        emailInput.setText(email);
        passwordInput.scrollToView();
        passwordInput.setText(password);
        confirmPasswordInput.scrollToView();
        confirmPasswordInput.setText(password);
        idInput.scrollToView();
        idInput.setText(id);
        registerBtn.scrollToView();
        registerBtn.click();
    }

    public boolean checkRegisterErrorMessage(String message) {
        return errorMessage.getText().trim().equals(message);
    }
}
