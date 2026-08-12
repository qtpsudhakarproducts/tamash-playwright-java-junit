package com.qtpsudhakar.tamash.examples.junit;

import com.microsoft.playwright.Page;
import com.qtpsudhakar.tamash.examples.junit.pages.AddEmployeePage;
import com.qtpsudhakar.tamash.examples.junit.pages.DashboardPage;
import com.qtpsudhakar.tamash.examples.junit.pages.LoginPage;
import com.qtpsudhakar.tamash.examples.junit.pages.PIMPage;
import com.qtpsudhakar.tamash.examples.junit.pages.PersonalDetailsPage;
import io.github.qtpsudhakarproducts.tamash.junit.UseTamashPlaywright;
import org.junit.jupiter.api.Test;

// Page Object Model example: page objects wrap the self-healing Page.
@UseTamashPlaywright
public class PomTest {

  @Test
  void createEmployeeUsingPageObjectModel(Page page) {
    LoginPage loginPage = new LoginPage(page);
    DashboardPage dashboardPage = new DashboardPage(page);
    PIMPage pimPage = new PIMPage(page);
    AddEmployeePage addEmpPage = new AddEmployeePage(page);
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(page);

    loginPage.navigateToURL("");
    loginPage.enterUserName("testadmin");
    loginPage.enterPassword("Vibetestq@123#");
    loginPage.clickLogin();

    dashboardPage.verifyDashboardPage();
    dashboardPage.clickPIM();

    pimPage.verifyPIMPage();
    pimPage.clickAdd();

    addEmpPage.enterFirstName("John");
    addEmpPage.enterLastName("Smith");
    addEmpPage.clickSave();

    personalDetailsPage.verifyPersonalDetailsPage();
  }
}
