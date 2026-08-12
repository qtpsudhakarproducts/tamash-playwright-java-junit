package com.qtpsudhakar.tamash.examples.junit;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.qtpsudhakar.tamash.examples.junit.TamashAssertions.assertThat;

// Non-POM example: locators are declared directly inside the test method.
public class SampleTest extends BaseTest {

  @Test
  void loginUsingCssSelectors(Page page) {
    page.navigate("https://qtpsudhakar-vibetestq-hrm.up.railway.app/");

    // Intentionally broken selector ("username1") to demonstrate self-healing recovery.
    Locator username = page.locator("input[name=\"username1\"]").describe("User Name Textbox");
    username.fill("testadmin");

    Locator password = page.locator("input[placeholder=\"Password\"]").describe("Password Textbox");
    password.fill("Vibetestq@123#");

    Locator loginButton = page.locator("button[type=\"submit\"]").describe("Login Button");
    loginButton.click();

    assertThat(page.locator("h6")).hasText("Dashboard");
  }
}
