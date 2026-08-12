# tamash-playwright-java-junit

Example usage of [`tamash-playwright`](https://central.sonatype.com/artifact/io.github.qtpsudhakarproducts/tamash-playwright) with **JUnit 5**, with and without the Page Object Model.

## Structure

- `SampleTest.java` — no page objects; locators declared directly in the test method.
- `PomTest.java` — Page Object Model; page objects wrap the self-healing `Page`.
- `pages/` — page object classes.
- `BaseTest.java` — annotated `@UseTamashPlaywright`; both test classes extend it rather than repeating the annotation themselves. JUnit 5's extension registration searches up the class hierarchy for `@ExtendWith` (which `@UseTamashPlaywright` is built on), so this propagates correctly to subclasses and still injects a self-healing `Page` into test methods (see `tamash-playwright`'s `TamashPlaywrightExtension`).

## Setup

```bash
cp .env.example .env
# fill in an AI provider key in .env (Ollama/OpenAI/Anthropic/Gemini)
mvn dependency:resolve
```

Install browsers once (via Playwright's bundled CLI):

```bash
mvn test-compile dependency:build-classpath -Dmdep.outputFile=cp.txt
java -cp "target/test-classes;target/classes;%cp.txt%" com.microsoft.playwright.CLI install chromium
```

## Run

```bash
mvn test
```

## How self-healing shows up

When a selector fails, `tamash-playwright` captures an ARIA snapshot, asks the configured AI provider for a replacement, retries the action once, and prints a line like:

```
[self-healer] Recovered using ollama:gpt-oss:120b (placeholder "Username").
```

## Note on assertions

Playwright's `assertThat()` casts to the concrete Locator implementation internally, so it needs the real (unwrapped) Locator — use `Bindings.unwrap(locator)` when asserting, as shown in both test classes.
