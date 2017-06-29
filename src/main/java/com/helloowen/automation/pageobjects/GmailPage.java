package com.helloowen.automation.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Component
public class GmailPage {

    public void openGmailHomePage() {
        Selenide.open("https://www.google.com/gmail/about/");
    }

    public void login() {
        $(by("type", "email")).setValue("automation.test.template@gmail.com");
        $(byText("Next")).click();
        $(by("type", "password")).setValue("Automation123");
        $(byText("Next")).click();
    }

    public void clickLoginButton() {
        $(".gmail-nav__nav-link__sign-in").click();
    }

    public boolean inDashBoard() {
        $(by("title", "Inbox")).shouldBe(Condition.visible);
        return $(by("title", "Inbox")).isDisplayed();
    }
}
