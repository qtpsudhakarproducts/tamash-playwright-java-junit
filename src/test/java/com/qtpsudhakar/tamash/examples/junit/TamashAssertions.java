package com.qtpsudhakar.tamash.examples.junit;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import static io.github.qtpsudhakarproducts.tamash.bindings.Bindings.unwrap;

/**
 * Wraps Playwright's own assertThat() so every call site — test methods and page objects alike
 * — can assert directly on a self-healing Locator without knowing about unwrap(). Centralizing
 * it here means the cast-to-concrete-class requirement (see Bindings.unwrap's Javadoc) is
 * handled once, not repeated at every call site.
 */
public final class TamashAssertions {
  private TamashAssertions() {}

  public static LocatorAssertions assertThat(Locator locator) {
    return PlaywrightAssertions.assertThat(unwrap(locator));
  }
}
