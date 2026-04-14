package runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;
import static org.junit.platform.launcher.LauncherConstants.DRY_RUN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "steps"
)

@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, json:target/cucumber-reports/cucumber.json"
)

@ConfigurationParameter(
        key = "cucumber.snippet-type",
        value = "camelcase"
)

@ConfigurationParameter(
        key = DRY_RUN_PROPERTY_NAME,   // <- equivalente a dryRun
        value = "false"
)

@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,   // <- equivalente a dryRun
        value = "not @ignore"
)

@ConfigurationParameter(
        key = io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME,
        value = "steps,hooks"
)

//@ConfigurationParameter(
//      key = Constants.FILTER_TAGS_PROPERTY_NAME,
//      value = "@smoke"
//)

public class RunCucumberTest {


}
