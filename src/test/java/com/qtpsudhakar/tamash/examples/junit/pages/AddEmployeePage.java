package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddEmployeePage extends BasePage {
  private final Locator txtFirstName;
  private final Locator txtLastName;
  private final Locator btnSave;

  public AddEmployeePage(Page page) {
    super(page);
    txtFirstName = page.getByPlaceholder("First Name").describe("First Name Textbox");
    // Intentionally broken placeholder ("Last Name1") to demonstrate self-healing recovery.
    txtLastName = page.getByPlaceholder("Last Name1").describe("Last Name Textbox");
    btnSave = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).describe("Save Button");
  }

  public void enterFirstName(String firstName) {
    txtFirstName.fill(firstName);
    System.out.println("Entered First Name " + firstName);
  }

  public void enterLastName(String lastName) {
    txtLastName.fill(lastName);
    System.out.println("Entered Last Name " + lastName);
  }

  public void clickSave() {
    btnSave.click();
    System.out.println("Clicked on Save Button");
  }
}
