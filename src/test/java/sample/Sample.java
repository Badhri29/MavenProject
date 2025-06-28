package sample;

import org.base.testingmethods.*;

public class Sample extends BaseClassTesting{

	public static void main(String[] args) {
		
		driverLaunch("chrome", false, 5);
		urlLaunch("https://www.facebook.com");
		
		LoginPOM l = new LoginPOM();
		sendKeysUsingJS(l.getUserName(), "Badhri");
		sendKeysUsingJS(l.getPassword(), "123456");
		
		
		quit(3000);
	}
}
