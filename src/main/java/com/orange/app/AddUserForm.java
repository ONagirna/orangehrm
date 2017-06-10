package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orange.data.NewUser;

import com.qagroup.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Step;

public class AddUserForm extends AbstractPage {
	
	private WebElement UserHeading;
	private WebElement systemUser_employeeName_empName;
	private WebElement systemUser_userName;
	private WebElement systemUser_password;
	private WebElement systemUser_confirmPassword;
	private WebElement btnSave;
	
	public AddUserForm(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(UserHeading));
	}
	
	public void enterNewEmployeeName (String newemployeename) {
		systemUser_employeeName_empName.sendKeys(newemployeename);
	}
	
	public void enterNewUserName (String newusername) {
		systemUser_userName.sendKeys(newusername);
	}
	
	public void enterNewUserPassword (String newuserpassword) {
		systemUser_password.sendKeys(newuserpassword);
	}
	
	public void confirmNewUserPassword (String newpasswordconfirm) {
		systemUser_confirmPassword.sendKeys(newpasswordconfirm);
	}
	
	public void clickOnSaveButton() {
		btnSave.click();
	}
	
	@Step("Add new ordinary user to the system")
	public AdminUsersPage addNewOrdinaryUser(NewUser newuser) {
		enterNewEmployeeName(newuser.getNewEmployeeName());
		enterNewUserName(newuser.getNewUserName());
		enterNewUserPassword(newuser.getNewUserPassword());
		confirmNewUserPassword(newuser.getNewPasswordConfirm());
		clickOnSaveButton();
		
		return new AdminUsersPage(driver);
		
	}
}
