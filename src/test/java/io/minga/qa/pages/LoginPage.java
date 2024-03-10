package io.minga.qa.pages;

import static io.minga.keywords.WebUI.waitForPageLoaded;
import static io.minga.keywords.WebUI.clearText;
import static io.minga.keywords.WebUI.setText;
import static io.minga.keywords.WebUI.clearText;
import static io.minga.keywords.WebUI.clickElement;
import static io.minga.keywords.WebUI.openWebsite;
import static io.minga.keywords.WebUI.setText;
import static io.minga.keywords.WebUI.sleep;
import static io.minga.keywords.WebUI.verifyElementVisible;
import static io.minga.keywords.WebUI.waitForElementVisible;
import static io.minga.keywords.WebUI.waitForPageLoaded;
import static io.minga.keywords.WebUI.*;
import static io.minga.keywords.WebUI.openWebsite;

import org.openqa.selenium.By;

import io.minga.constants.FrameworkConstants;

public class LoginPage extends CommonPage{
	
    public By buttonCountry = By.xpath("//div[@title='CAN']");
    public By buttonNext = By.xpath("//button[text()='Next']");
  
    public By buttonExpand = By.xpath("//mat-panel-title[text()=' Login with username and password ']");
    public By invalidCredentials = By.xpath("//mg-message-box-content[text()=' Your email address or password is incorrect. Please try again. ']");
    public By inputEmail = By.xpath("//input[@name='email']");
    public By inputPassword = By.xpath("//input[@type='password']");
    
    public By linkLogout = By.xpath("//span[text()='Logout']");
    private By messageAccDoesNotExist = By.xpath("//span[@data-notify='message']");  
    
    public void loginFailWithEmailDoesNotExist(String email, String password) {
        openLoginPage();
        //sleep(2);
        clickElement(buttonCountry);
        clickElement(buttonNext);        
        waitForPageLoaded();

        clickElement(buttonExpand);        
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonNext);
        verifyElementVisible(invalidCredentials, "First Check.");
    }
    
    public void loginFailWithIncorrectPassword(String email, String password) {
        openLoginPage();
        waitForPageLoaded();
        clickElement(buttonCountry);
        clickElement(buttonNext);        
        waitForPageLoaded();

        clickElement(buttonExpand);        
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonNext);
        verifyElementVisible(invalidCredentials, "First Check.");
    }

    public void loginSuccessWithAdminAccount(String email, String password) {
        openLoginPage();
        //sleep(2);
        clickElement(buttonCountry);
        clickElement(buttonNext);        
        waitForPageLoaded();
        
        clickElement(buttonExpand);
        clearText(inputEmail);
        clearText(inputPassword);
        setText(inputEmail, email);
        setText(inputPassword, password);
        clickElement(buttonNext);
        waitForPageLoaded();
        
        clickElement(linkLogout);
    }
    
    public void openLoginPage() {
        openWebsite(FrameworkConstants.URL_MINGA_CAN_USER);
        waitForPageLoaded();
    }
}
