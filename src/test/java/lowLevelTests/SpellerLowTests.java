package lowLevelTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.FileUtils;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static service.URI.*;

public class SpellerLowTests {

    private Properties spellerPath = FileUtils.readSpellerPropertiesFromFile("src/test/resources/properties/speller.properties");
    private RequestSpecification REQUEST_SPECIFICATION;

    public void request() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    @Test
    public void checkRequestTextWithError() {
        request();
        given(REQUEST_SPECIFICATION)
                .param(PARAM_KEY, "the+weatther+is+fine")
                .get(spellerPath.getProperty("speller.path") + GET_CHECK_TEXTS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("code[0][0]", is(1))
                .body("pos[0][0]", is(4))
                .body("col[0][0]", is(4))
                .body("len[0][0]", is(8))
                .body("word[0]", is(asList("weatther")))
                .body("s[0][0]", is(asList("weather", "wheather")));
    }

    @Test
    public void checkRequestWordSpace() {
        request();
        given(REQUEST_SPECIFICATION)
                .param(PARAM_KEY, "exa ple")
                .get(spellerPath.getProperty("speller.path") + GET_CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("code[0]", is(1))
                .body("len[0]", is(7))
                .body("word", is(asList("exa ple")))
                .body("s[0]", hasSize(4))
                .body("s[0]", is(asList("example", "exam ple", "exa mple", "exaple")));
    }

    @Test
    public void checkRequestWordWithDigit() {
        request();
        given(REQUEST_SPECIFICATION)
                .param(PARAM_KEY, "comp8ter")
                .get(spellerPath.getProperty("speller.path") + GET_CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("code[0]", is(1))
                .body("len[0]", is(8))
                .body("word", is(asList("comp8ter")))
                .body("s[0]", hasSize(3))
                .body("s[0]", is(asList("computer", "computed", "compyter")));
    }

    @Test
    public void checkRequestWordSymbol() {
        request();
        given(REQUEST_SPECIFICATION)
                .param(PARAM_KEY, "auto?us")
                .get(spellerPath.getProperty("speller.path") + GET_CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("isEmpty()", is(true));
    }
}
