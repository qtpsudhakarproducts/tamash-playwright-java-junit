package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Page;
import io.github.qtpsudhakarproducts.tamash.Env;

public class BasePage {
  protected static final String BASE_URL = Env.get("APP_BASE_URL") != null
      ? Env.get("APP_BASE_URL")
      : "https://qtpsudhakar-vibetestq-hrm.up.railway.app/";

  protected final Page page;

  public BasePage(Page page) {
    this.page = page;
  }

  public void navigateToURL(String path) {
    page.navigate(BASE_URL + path);
    System.out.println("Navigated to URL " + BASE_URL + path);
  }
}
