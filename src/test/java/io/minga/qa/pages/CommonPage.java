package io.minga.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static io.minga.keywords.WebUI.*;

public class CommonPage {
	
	private LoginPage loginPage;	
	
    
    public LoginPage getLoginPage() {
        if (loginPage == null) {
        	loginPage = new LoginPage();
        }
        return loginPage;
    } 
}
