package org.reto.runners;


import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import utils.BeforeSuite;
import utils.DataToFeature;
import utils.RunnerPersonalizado;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features/realizarRegistro.feature",
        tags = "@RealizarRegistroEmpleados",
        glue = "org.reto.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

@RunWith(RunnerPersonalizado.class)


public class RegistroEmpleados {

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/realizarRegistro.feature");
    }

}
