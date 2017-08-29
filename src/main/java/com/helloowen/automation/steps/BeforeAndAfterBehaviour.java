package com.helloowen.automation.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.Properties;

public class BeforeAndAfterBehaviour {

    @Before
    public void setUpWebDriver() throws Exception {
        setProperties();
        ChromeDriverManager.getInstance().setup();
        System.out.println("================setupWebDriver================");
    }

    @After
    public void tearDown() {
        Selenide.close();
    }

    private void setProperties() {
        Properties props = System.getProperties();
        props.setProperty("selenide.browser", "chrome");
    }

}

