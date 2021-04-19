package com.logigear.control.common.imp;

import com.logigear.control.base.imp.BaseControl;
import com.logigear.control.base.imp.Clickable;
import com.logigear.control.common.IComboBox;
import com.logigear.driver.manager.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ComboBox extends Clickable implements IComboBox {

	private Logger logger = Logger.getLogger(Element.class);

	public ComboBox(By locator) {
		super(locator);
	}

	public ComboBox(String locator) {
		super(locator);
	}

	public ComboBox(String locator, Object... value) {
		super(locator, value);
	}
	
	public ComboBox(BaseControl parent, String locator) {
		super(parent, locator);
	}

	public ComboBox(BaseControl parent, By locator) {
		super(parent, locator);
	}

	public ComboBox(BaseControl parent, String locator, Object... value) {
		super(parent, locator, value);
	}

	@Override
	public void select(String text) {
		Select select = new Select(getElement());
		select.selectByVisibleText(text);

	}

	@Override
	public void select(int index) {
		Select select = new Select(getElement());
		select.selectByIndex(index);

	}

	@Override
	public String getSelected() {
		Select select = new Select(getElement());
		return select.getFirstSelectedOption().getText();
	}

	@Override
	public List<String> getOptions() {
		List<String> ops = new ArrayList<String>();
		Select select = new Select(getElement());
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			ops.add(option.getText());
		}
		return ops;
	}

	@Override
	public void waitForSelectedOptionToBePresent(String option, int timeOutInSecond) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), timeOutInSecond);
			wait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					Boolean isSelected = (Boolean) Driver.execJavaScript(String
							.format("var ele = arguments[0];return ele.options[ele.selectedIndex].text=='%s';", option),
							getElement());
					return isSelected;
				}
			});
		} catch (Exception e) {
			logger.error(String.format("waitForSelectedOptionToBePresent: Has error with control '%s': %s",
					getLocator().toString(), e.getMessage()));
		}
	}
}
