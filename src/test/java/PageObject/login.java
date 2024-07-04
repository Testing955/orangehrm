package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login extends BaseClass {
    
    public login(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernamefield;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordfield;

    @FindBy(xpath = "//button[contains(@class, 'orangehrm-login-button') and @type='submit']")
    WebElement loginbutton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement dropdown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logout;

    public void enterUsername(String emails) {
       // getWait().until(ExpectedConditions.visibilityOf(usernamefield)).sendKeys(emails);
    	usernamefield.sendKeys(emails);
    }

    public void enterPassword(String pwds) {
       // getWait().until(ExpectedConditions.visibilityOf(passwordfield)).sendKeys(pwds);
    	passwordfield.sendKeys(pwds);
    }

    public void clickOnLoginButton() {
        //getWait().until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
    	loginbutton.click();
    }

    public void clickOnDropdown() {
        getWait().until(ExpectedConditions.elementToBeClickable(dropdown)).click();
        
    }

    public void clickOnLogoutButton() {
        //getWait().until(ExpectedConditions.elementToBeClickable(logout)).click();
    	logout.click();
    }

    public boolean isLoginSuccessful() {
        try {
            getWait().until(ExpectedConditions.visibilityOf(dropdown));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
