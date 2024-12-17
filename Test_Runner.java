package stepsDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Features", // Chemin vers vos fichiers .feature
        glue = "stepsDefinitions", // Package contenant les définitions des étapes
        monochrome = true // Ajout de monochrome pour une sortie plus lisible
)
public class Test_Runner {
}