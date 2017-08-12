package com.helloowen.automation.steps;

import com.helloowen.automation.domain.UserFactory;
import com.helloowen.automation.pageobjects.DashboardPage;
import com.helloowen.automation.pageobjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private final LoginPage loginPage;

    private final DashboardPage dashboardPage;

    public LoginSteps(LoginPage loginPage, DashboardPage dashboardPage) {
        this.loginPage = loginPage;
        this.dashboardPage = dashboardPage;
    }

    @Given("^I am on login page$")
    public void iOpenGmailLoginPage() throws Throwable {
        loginPage.openLoginPage();
    }

    @Given("^I login and on dashboard page$")
    public void iLoginAndOnDashboardPage() throws Throwable {
        iOpenGmailLoginPage();
        iLoginInWithMyGoogleAccount();
    }

    @When("^I login in with my Google account$")
    public void iLoginInWithMyGoogleAccount() throws Throwable {
        loginPage.login(UserFactory.getUser("customer"));
    }

    @Then("^I am on dashboard page$")
    public void iCanSeeInbox() throws Throwable {
        assertThat(dashboardPage.inDashBoard()).isEqualTo(true);
    }

}
