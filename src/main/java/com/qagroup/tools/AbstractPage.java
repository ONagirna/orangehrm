package com.qagroup.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class AbstractPage {

	protected WebDriver driver;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Read current URL")
	@Attachment("URL")
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
