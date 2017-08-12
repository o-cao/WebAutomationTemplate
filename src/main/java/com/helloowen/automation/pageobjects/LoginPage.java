package com.helloowen.automation.pageobjects;

import com.codeborne.selenide.Selenide;
import com.helloowen.automation.ConfigurationService;
import com.helloowen.automation.domain.User;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final ConfigurationService configurationService;

    public LoginPage(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    public void openLoginPage() {
        Selenide.open(configurationService.getValue("gmailUrl"));
    }

    public void login(User user) {
        $(by("type", "email")).setValue(user.getEmail());
        $(byText("Next")).click();
        $(by("type", "password")).setValue(user.getPassword());
        $(byText("Next")).click();
    }

}
