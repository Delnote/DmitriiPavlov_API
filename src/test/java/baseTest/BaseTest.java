package baseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import utils.FileUtils;

public class BaseTest {


    protected RequestSpecification REQUEST_SPECIFICATION;
    protected FileUtils fileUtils = new FileUtils();

    @BeforeMethod
    public void setUp() {
        if (fileUtils.getProp() == null) {
            fileUtils.readSpellerPropertiesFromFile();
        }

        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

}
