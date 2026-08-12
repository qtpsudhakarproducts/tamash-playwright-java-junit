package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.github.qtpsudhakarproducts.tamash.bindings.Bindings.unwrap;

public class PersonalDetailsPage extends BasePage {
  private final Locator personalDetailsHeader;

  public PersonalDetailsPage(Page page) {
    super(page);
    personalDetailsHeader = page.locator("//h6[text()='Personal Details']").describe("Personal Details Header");
  }

  public void verifyPersonalDetailsPage() {
    assertThat(unwrap(personalDetailsHeader)).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));
    System.out.println("Personal Details Page is displayed");
  }
}
