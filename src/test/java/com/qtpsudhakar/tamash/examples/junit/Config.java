package com.qtpsudhakar.tamash.examples.junit;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Reads example-specific config (APP_BASE_URL) from a real environment variable first, falling
 * back to .env. Kept independent of tamash-playwright's own Env class — the base URL of the
 * application under test isn't the library's concern, just this example's.
 */
public final class Config {
  private Config() {}

  private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

  public static String get(String key) {
    String fromEnv = System.getenv(key);
    return fromEnv != null ? fromEnv : DOTENV.get(key);
  }
}
