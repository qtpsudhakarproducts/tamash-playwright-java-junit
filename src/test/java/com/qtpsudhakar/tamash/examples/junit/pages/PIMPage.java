package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.qtpsudhakar.tamash.examples.junit.TamashAssertions.assertThat;

public class PIMPage extends BasePage {
  private final Locator pimHeader;
  private final Locator btnAdd;

  public PIMPage(Page page) {
    super(page);
    pimHeader = page.locator("//h6[text()='PIM']").describe("PIM Header");
    btnAdd = page.locator("//button[normalize-space()='Add']").describe("Add Button");
  }

  public void verifyPIMPage() {
    assertThat(pimHeader).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));
    System.out.println("PIM Page is displayed");
  }

  public void clickAdd() {
    btnAdd.click();
    System.out.println("Clicked on Add Button");
  }
}
