package tests;

import com.codeborne.selenide.Configuration;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import framework.browser.BrowserManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQATest {

    @Test
    public void demoQATestPlaywright() {
        try (Playwright playwright = Playwright.create()) {
                    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    Page page = browser.newPage();

                    // Открываем Google
                    page.navigate("https://www.saucedemo.com/");

                    // Вводим запрос в поиск
                    page.locator("#user-name").fill("standard_user");
                    page.locator("#password").fill("secret_sauce");
                    page.locator("#login-button").click();
                    Assert.assertTrue(page.locator("//div[contains(@class, 'inventory') and contains(@class, 'list')]").isVisible(), "Labs item page is not visible");
                    Assert.assertTrue(page.locator("(//div[contains(@class, 'inventory') and contains(@class, 'label')])[1]").isVisible(), "first item is not visible");
        }
    }

    @Test
    public void demoQATestSelenide() {
        Configuration.browserSize = "1920x1080";
        open("https://www.google.com");
        // Вводим запрос и нажимаем Enter
        $("input[name='q']").setValue("Selenide").pressEnter();

        // Проверяем, что в результатах есть сайт Selenide
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    public void demoQATestFrameWorkPlaywright() {
        try (Playwright playwright = Playwright.create()) {
            BrowserManager.initializeWebDriver(playwright);
            BrowserManager.getPage().navigate("https://www.google.com");

        }
    }

}