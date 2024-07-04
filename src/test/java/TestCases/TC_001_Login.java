package TestCases;

import org.testng.annotations.Test;
import PageObject.login;
import TestBase.BasePage;
import Utilities.DataProviders;

public class TC_001_Login extends BasePage {
    
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_loginddt(String email, String password) {
        logger.info("***Starting of the TC_001_Login***");
        login lg = new login(driver);

        try {
            lg.enterUsername(email);
            lg.enterPassword(password);
            lg.clickOnLoginButton();

            if (lg.isLoginSuccessful()) {
                lg.clickOnDropdown();
                lg.clickOnLogoutButton();
            } else {
                logger.info("Login failed for user: " + email);
            }
        } catch (Exception e) {
            logger.error("Error during login test: " + e.getMessage());
        }
    }
}