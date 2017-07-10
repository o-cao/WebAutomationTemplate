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
        Selenide.open("https://enterprise.stormpath.io/login");
    }

    public void login() {
        $("#tenantNameKey").setValue("wonderful-cannon");
        $("#email").setValue("owen.cao@sparkventures.co.nz");
        $("#password").setValue("");

        $("#loginbutton").click();
    }

    public boolean inDashBoard() {
        $(by("title", "Inbox")).shouldBe(Condition.visible);
        return $(by("title", "Inbox")).isDisplayed();
    }
}
