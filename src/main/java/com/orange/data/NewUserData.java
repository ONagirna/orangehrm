package com.orange.data;

import com.github.javafaker.Faker;

public class NewUserData {
	
	public static final NewUser NEW_ADMINUSER = new NewUser ("Admin", "Will Smith", "will.smith", "Enabled", "will.smith", "will.smith");

	
	public static final NewUser NEW_ORDINARYUSER = new NewUser ("ESS", "John Smith", "johnyy.smiith", "Enabled", "johnsmith", "johnsmith");
	
	
	public static NewUser getNewFakeUser() {
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String newemployeename = firstName + lastName;
		String userName = firstName.toLowerCase() + "." + lastName.toLowerCase();
		String newpassword = faker.internet().password();
		String newpasswordconfirm = newpassword;
		return new NewUser("ESS", newemployeename, userName, "Enabled", newpassword, newpasswordconfirm);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			System.out.println(getNewFakeUser());
	}

}
