package com.helloowen.automation.steps;

import com.codeborne.selenide.Selenide;
import com.helloowen.automation.pageobjects.GmailPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class GmailSteps {

    @Autowired
    private GmailPage gmailPage;

    @Given("^I open Gmail login page$")
    public void iOpenGmailLoginPage() throws Throwable {
        gmailPage.openGmailHomePage();
    }

    @When("^I login in with my Google account$")
    public void iLoginInWithMyGoogleAccount() throws Throwable {
        gmailPage.login();
        Thread.sleep(10*1000);
    }

    @Then("^I can see inbox$")
    public void iCanSeeInbox() throws Throwable {
        assertThat(gmailPage.inDashBoard()).isEqualTo(true);
    }

    @When("^I go to page$")
    public void iGoToPage() throws Throwable {
        File file = new File (this.getClass().getClassLoader().getResource("hreflist.txt").getFile());
        LineIterator it = FileUtils.lineIterator(file);

        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                Selenide.open(line.split(" = ")[0]);
                Thread.sleep(5*1000);
                if (Selenide.getElement(By.tagName("pre")).getText().contains("The requested resource does not exist.")){
                    System.out.println(line.split(" = ")[1]);
                }
            }
        } finally {
            it.close();
        }
    }
}
