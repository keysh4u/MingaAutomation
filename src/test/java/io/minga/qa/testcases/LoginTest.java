package io.minga.qa.testcases;

import org.testng.annotations.Test;

import io.minga.constants.FrameworkConstants;
import io.minga.helpers.ExcelHelpers;

import io.minga.common.BaseTest;

public class LoginTest extends BaseTest {
		
    @Test(priority = 1)
    public void TC_LoginFailWithEmailDoesNotExist() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_BASIC_LOGIN, "Login");
        getLoginPage().loginFailWithEmailDoesNotExist(excel.getCellData(1, "email"), excel.getCellData(1, "password"));
    }

    @Test(priority = 2)
    public void TC_LoginFailWithIncorrectPassword() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_BASIC_LOGIN, "Login");
        getLoginPage().loginFailWithIncorrectPassword(excel.getCellData(2, "email"), excel.getCellData(2, "password"));
    }

    @Test(priority = 3)
    public void TC_LoginSuccessWithAdminAccount() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_BASIC_LOGIN, "Login");
        getLoginPage().loginSuccessWithAdminAccount(excel.getCellData(3, "email"), excel.getCellData(3, "password"));
    }
    
}
