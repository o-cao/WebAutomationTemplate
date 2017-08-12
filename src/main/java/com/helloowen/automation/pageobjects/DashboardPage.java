package com.helloowen.automation.pageobjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public boolean inDashBoard() {
        $(by("href", "https://mail.google.com/mail/u/0/#inbox"))
                .waitUntil(Condition.appear, 10 * 1000);
        return true;
    }

    public void clickComposeButton() {
        $(byText("COMPOSE")).waitUntil(Condition.appear, 10 * 1000);
        $(byText("COMPOSE")).click();
    }

    public void inputRecipients(String recipients) {
        $(by("name", "to")).sendKeys(recipients);
    }

    public void inputSubject(String subject) {
        $(by("placeholder", "Subject")).sendKeys(subject);
    }

    public void inputContent(String content) {
        $(".AD .nH .editable").sendKeys(content);
    }

    public void submitEmail() {
        $(byText("Send")).click();
    }

    public String getNotification() {
        $(by("role", "alert")).shouldBe(Condition.appear);
        return $(by("role", "alert")).getText();
    }

}
