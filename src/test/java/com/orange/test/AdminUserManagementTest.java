package com.orange.test;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orange.app.AddUserForm;
import com.orange.app.AdminUsersPage;
import com.orange.app.DashboardPage;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.orange.data.UserData.ADMIN_USER;
import static com.orange.data.NewUserData.NEW_ORDINARYUSER;

@Features("User management by admin")
@Stories("Ability to add new user by admin")
public class AdminUserManagementTest extends AbstractTest {

	private DashboardPage onDashboardPage;
	private AdminUsersPage onAdminUsersPage;
	private AddUserForm onAddUserForm;

	@BeforeClass
	public void setup() {
		onDashboardPage = orangeHrm.openLoginPage().loginAs(ADMIN_USER);
	}

	@Test
	public void testAdminOpenSystemUsersPage() {
		onAdminUsersPage = onDashboardPage.hoverAdminTab().hoverUserManagementTab().clickUsersTab();
	}

	@Test(dependsOnMethods = "testAdminOpenSystemUsersPage")
	public void testOpenAddUserForm() {
		onAddUserForm = onAdminUsersPage.clickAddButton();

	}

	@Test(dependsOnMethods = "testOpenAddUserForm")
	public void testFillInUserForm() {
		onAddUserForm.addNewOrdinaryUser(NEW_ORDINARYUSER);

		assertTrue(onAdminUsersPage.isUsersTableDisplayed(), "User is not navigated to the admin users table");
	}

	@Test(dependsOnMethods = "testFillInUserForm")
	public void testUserDeletionFromList() {
		onAdminUsersPage.deleteUserFromList().confirmUserDeletion();
		onAdminUsersPage.findNewUserInTable();
		
		assertTrue(onAdminUsersPage.verifyUserWasDeleted(), "User was not deleted from the table");

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		orangeHrm.close();
	}

}
