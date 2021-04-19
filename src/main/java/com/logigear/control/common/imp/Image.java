package com.logigear.control.common.imp;

import com.logigear.control.base.imp.BaseControl;
import com.logigear.control.base.imp.Clickable;
import com.logigear.control.common.IImage;
import org.openqa.selenium.By;

public class Image extends Clickable implements IImage {

	public Image(By locator) {
		super(locator);
	}

	public Image(String locator) {
		super(locator);
	}

	public Image(String locator, Object... value) {
		super(locator, value);
	}

	public Image(BaseControl parent, String locator) {
		super(parent, locator);
	}

	public Image(BaseControl parent, By locator) {
		super(parent, locator);
	}

	public Image(BaseControl parent, String locator, Object... value) {
		super(parent, locator, value);
	}
	
	@Override
	public String getSource() {
		return getElement().getAttribute("src");
	}

	@Override
	public String getAlt() {
		return getElement().getAttribute("alt");
	}

}
