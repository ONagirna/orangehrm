package com.orange.test;

import com.orange.app.OrangeHRM;
import com.qagroup.tools.App;
import com.qagroup.tools.AppTest;

public class AbstractTest implements AppTest {
	
	protected OrangeHRM orangeHrm = new OrangeHRM();

	@Override
	public App getTestedApp() {
		return this.orangeHrm;
	}

}
