package cucumber_framework_180619;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", dryRun = false, tags="@Regression")
//dry = true, By default it is false. We need to set it true & it generates the step definition ONLY
// It is used to check the missing step definition
// Without a single/step definition we cannot run our code.
// strict = true, it is used to point out unimplemented the step definition.
// I will execute the test cases even though there is an error in any method.

public class CucumberRun {

}
