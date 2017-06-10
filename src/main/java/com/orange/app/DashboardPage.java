package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qagroup.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class DashboardPage extends AbstractPage {

	private WebElement welcome;
	private WebElement menu_admin_viewAdminModule;
	private WebElement menu_admin_UserManagement;
	private WebElement menu_admin_viewSystemUsers;
	private Actions action;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@Step("Read Greeting message")
	@Attachment("Message")
	public String getGreetingMessage() {
		return welcome.getText();
	}

	@Step("Hover the 'Admin' tab")
	public DashboardPage hoverAdminTab() {
		action = new Actions(driver);
		action.moveToElement(menu_admin_viewAdminModule).perform();
		return new DashboardPage(driver);
	}
	@Step("Hover the 'User Management' tab")
	public DashboardPage hoverUserManagementTab() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		action = new Actions(driver);
		action.moveToElement(menu_admin_UserManagement).click().perform();
		return new DashboardPage(driver);
	}
	@Step("Click on the 'Users' subtab")
	public AdminUsersPage clickUsersTab() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		menu_admin_viewSystemUsers.click();
		return new AdminUsersPage(driver);
	}

}
