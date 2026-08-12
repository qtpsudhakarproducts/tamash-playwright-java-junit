package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.github.qtpsudhakarproducts.tamash.bindings.Bindings.unwrap;

public class DashboardPage extends BasePage {
  private final Locator dashboardHeader;
  private final Locator lnkPIM;

  public DashboardPage(Page page) {
    super(page);
    dashboardHeader = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard")).describe("Dashboard Header");
    lnkPIM = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PIM")).describe("PIM Link");
  }

  public void clickPIM() {
    lnkPIM.click();
    System.out.println("Clicked on PIM Link");
  }

  public void verifyDashboardPage() {
    assertThat(unwrap(dashboardHeader)).isVisible();
    System.out.println("Dashboard Page is displayed");
  }
}
