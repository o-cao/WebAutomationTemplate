package com.helloowen.automation.steps;

import com.helloowen.automation.pageobjects.DashboardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ComposeSteps {

    private final DashboardPage dashboardPage;

    public ComposeSteps(DashboardPage dashboardPage) {
        this.dashboardPage = dashboardPage;
    }

    @When("^I compose a new email$")
    public void iComposeANewEmail() throws Throwable {
        dashboardPage.clickComposeButton();
        dashboardPage.inputRecipients("owen.cao@hotmail.com");
        dashboardPage.inputSubject("Hello Test");
        dashboardPage.inputContent("Hi there, this is the auto test");
        dashboardPage.submitEmail();
    }

    @Then("^I can see successful message$")
    public void iCanSeeSuccessfulMessage() throws Throwable {
        assertThat(dashboardPage.getNotification()).isEqualTo("Your message has been sent. View message");
    }
}
