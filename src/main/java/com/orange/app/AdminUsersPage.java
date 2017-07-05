package com.orange.app;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qagroup.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Step;
import static com.orange.data.NewUserData.NEW_ORDINARYUSER;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class AdminUsersPage extends AbstractPage {

	private WebElement btnAdd;
	private WebElement resultTable;
	private WebElement searchSystemUser_userName;
	private WebElement searchBtn;
	private WebElement btnDelete;
	private WebElement dialogDeleteBtn;

	@FindBy(css = ".odd")
	private WebElement oddListItemNumber;

	@FindBy(css = ".odd input")
	private WebElement checkbox;

	@FindBy(css = ".odd>td.left>a,.even>td.left>a")
	private List<WebElement> usernames;

	public AdminUsersPage(WebDriver driver) {
		super(driver);
	}

	@Step("Click on Add button")
	public AddUserForm clickAddButton() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		// new WebDriverWait(driver,
		// 10).until(ExpectedConditions.visibilityOf(btnAdd));
		btnAdd.click();
		return new AddUserForm(driver);
	}

	@Step("Verify that the table with users is displayed")
	public boolean isUsersTableDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return resultTable.isDisplayed();
	}

	@Step("Find new added user in the table")
	public AdminUsersPage findNewUserInTable() {
		searchSystemUser_userName.sendKeys(NEW_ORDINARYUSER.getNewUserName());
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		searchBtn.click();
		return new AdminUsersPage(driver);
	}

	@Step("Verify that the user is found")
	public boolean isOddItemNumberDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		return oddListItemNumber.isDisplayed();
	}

	@Step("Click on user checkbox to select the user")
	public AdminUsersPage clickOnUserCheckbox() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		checkbox.click();
		return new AdminUsersPage(driver);
	}

	@Step("Click on 'Delete' button")
	public AdminUsersPage clickOnDeleteButton() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		btnDelete.click();
		return new AdminUsersPage(driver);
	}

	@Step("Delete the selected user from the table list")
	public AdminUsersPage deleteUserFromList() {
		findNewUserInTable();
		isOddItemNumberDisplayed();
		clickOnUserCheckbox();
		clickOnDeleteButton();
		return new AdminUsersPage(driver);
	}

	@Step("Confirm user deletion on the popup")
	public AdminUsersPage confirmUserDeletion() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		dialogDeleteBtn.click();
		return new AdminUsersPage(driver);
	}

	@Step("Verify that user was deleted successfully")
	public boolean verifyUserWasDeleted() {
		try {
			oddListItemNumber.isDisplayed();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	@Step("Read all usernames")
	public List<String> userList() {
		return usernames.stream().map(WebElement::getText).collect(toList());
	}

}