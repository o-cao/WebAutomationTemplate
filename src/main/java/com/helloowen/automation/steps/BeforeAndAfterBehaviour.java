package com.helloowen.automation.steps;

import com.helloowen.automation.CucumberConfiguration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.Properties;

@ContextConfiguration(classes = {CucumberConfiguration.class})
public class BeforeAndAfterBehaviour {

//    @Autowired
//    private UserFactory userFactory;

    @Before
    public void setUpWebDriver(Scenario scenario) throws Exception {
        setProperties();
        ChromeDriverManager.getInstance().setup();
    }

    @After
    public void tearDown(Scenario scenario) {
    }


    private void setProperties() {
        Properties props = System.getProperties();
        props.setProperty("selenide.browser", "chrome");
    }

}

