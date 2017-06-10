package com.orange.test;

import static com.orange.data.UserData.ADMIN_USER;
import static com.orange.data.UserData.FIONA;
import static com.orange.data.UserData.HANNAH;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.app.DashboardPage;
import com.orange.data.User;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class LoginTest extends AbstractTest {

	private DashboardPage onDashboardPage;

	@Features("Login into system")
	@Stories("Login as different types of users ")
	@Test(dataProvider = "testData")

	public void testUserIsAbleToLogin(User user) {
		onDashboardPage = orangeHrm.openLoginPage().loginAs(user);

		String actualGreetingMessage = onDashboardPage.getGreetingMessage();
		String expectedGreetingMessage = "Welcome " + user.getName();

		Assert.assertEquals(actualGreetingMessage, expectedGreetingMessage, "Incorrect greeting message for " + user);
	}

	@DataProvider(name = "testData")
	public static Object[][] testData() {
		return new Object[][] { { ADMIN_USER }, { FIONA }, { HANNAH } };
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		
		orangeHrm.close();
	}

	public static void main(String[] args) {

	}

}
