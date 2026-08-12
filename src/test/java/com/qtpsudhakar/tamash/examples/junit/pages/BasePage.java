package com.qtpsudhakar.tamash.examples.junit.pages;

import com.microsoft.playwright.Page;
import com.qtpsudhakar.tamash.examples.junit.Config;

public class BasePage {
  protected static final String BASE_URL = Config.get("APP_BASE_URL") != null
      ? Config.get("APP_BASE_URL")
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
