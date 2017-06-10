package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orange.data.User;
import com.qagroup.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends AbstractPage {
	private WebElement txtUsername;

	private WebElement txtPassword;

	private WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Step("Fill Username Field with value <{0}>")
	public void fillUsernameField(String username) {
		txtUsername.sendKeys(username);
	}

	@Step("Fill Password Field with value <{0}>")
	public void fillPasswordField(String password) {
		txtPassword.sendKeys(password);
	}

	@Step
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	@Step("Login as <{0}>")
	public DashboardPage loginAs(User user) {
		fillUsernameField(user.getUsername());
		fillPasswordField(user.getPassword());
		clickLoginButton();
		return new DashboardPage(driver);
	}

}
