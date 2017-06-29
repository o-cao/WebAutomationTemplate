package com.helloowen.automation.steps;

import com.helloowen.automation.CucumberConfiguration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@ContextConfiguration(classes = CucumberConfiguration.class)
@SpringBootTest(webEnvironment = NONE)
public class BeforeAndAfterBehaviour {

//    @Autowired
//    private UserFactory userFactory;

    @Before
    public void setUpWebDriver(Scenario scenario) throws Exception {
        ChromeDriverManager.getInstance().setup();
    }

    @After
    public void tearDown(Scenario scenario) {
    }

}

