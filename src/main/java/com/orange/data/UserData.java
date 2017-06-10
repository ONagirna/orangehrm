package com.orange.data;

import com.github.javafaker.Faker;

public class UserData {
	
	public static final User ADMIN_USER = new User("Admin", "admin", "Admin");

	public static final User CUSTOMER_USER = new User("Customer", "customer", "Customer");

	public static final User FIONA = new User("fiona.grace", "fiona.grace", "Fiona");

	public static final User HANNAH = new User("hannah.flores", "hannah.flores", "Hannah");

	public static User getFakeUser() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String userName = firstName.toLowerCase() + "." + lastName.toLowerCase();
		return new User(userName, faker.internet().password(), firstName);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			System.out.println(getFakeUser());
	}

}
