package com.helloowen.automation.steps;

import com.helloowen.automation.pageobjects.GmailPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class GmailSteps {

    @Autowired
    private GmailPage gmailPage;

    @Given("^I open Gmail login page$")
    public void iOpenGmailLoginPage() throws Throwable {
        gmailPage.openGmailHomePage();
        gmailPage.clickLoginButton();
    }

    @When("^I login in with my Google account$")
    public void iLoginInWithMyGoogleAccount() throws Throwable {
        gmailPage.login();
    }

    @Then("^I can see inbox$")
    public void iCanSeeInbox() throws Throwable {
        assertThat(gmailPage.inDashBoard()).isEqualTo(true);
    }
}
