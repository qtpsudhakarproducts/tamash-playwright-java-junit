package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {
  private final Locator txtUserName;
  private final Locator txtPassword;
  private final Locator btnLogin;

  public LoginPage(Page page) {
    super(page);
    // Intentionally broken placeholder ("Username1") to demonstrate self-healing recovery.
    txtUserName = page.getByPlaceholder("Username1").describe("Username Textbox");
    txtPassword = page.getByPlaceholder("Password").describe("Password Textbox");
    btnLogin = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).describe("Login Button");
  }

  public void enterUserName(String username) {
    txtUserName.fill(username);
    System.out.println("Entered username " + username);
  }

  public void enterPassword(String password) {
    txtPassword.fill(password);
    System.out.println("Entered password " + password);
  }

  public void clickLogin() {
    btnLogin.click();
    System.out.println("Clicked on Login Button");
  }
}
