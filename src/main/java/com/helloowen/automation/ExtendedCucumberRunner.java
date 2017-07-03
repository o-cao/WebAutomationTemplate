package com.helloowen.automation;

import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ExtendedCucumberRunner extends Cucumber {
    public ExtendedCucumberRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
        generateReport();
    }

    private void generateReport() {
        List<String> jsonReports = new LinkedList<>();
        String json = "target/cucumber.json";
        jsonReports.add(json);
        File reportDirectory = new File("target");
        String buildProject = "Web Automation Template";

        Reportable report = new ReportBuilder(jsonReports, new Configuration(reportDirectory, buildProject)).generateReports();

        //fail build if got any failed scenarios
        if (report.getFailedScenarios() > 0) {
            System.exit(1);
        }
    }
}
