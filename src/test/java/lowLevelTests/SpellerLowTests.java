package lowLevelTests;

import dataProviders.DataProviders;
import dto.SpellerDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import service.SpellerSteps;
import utils.FileUtils;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;
import static service.URI.GET_CHECK_TEXT;

public class SpellerLowTests {

    private RequestSpecification REQUEST_SPECIFICATION;
    private FileUtils fileUtils = new FileUtils();


    public void request() {
        fileUtils.readSpellerPropertiesFromFile();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    //todo перепиши этот тест но без использования низкоуровнвых проверок.
    // Используй предефайненный объект SpellerDto для проверки ожидаемого результата
    // перепиши и следующий тест
    // объедини их через DataProvider и почувствуй разницу :)
    // fixed.

    @Test(dataProvider = "singleWordDataToCheck", dataProviderClass = DataProviders.class)
    public void newSimpleTest(String requestText, SpellerDto[] spellerDtoDataCheck) {

        SpellerDto[] spellerDto = new SpellerSteps().checkText(requestText);

        assertEquals(spellerDto, spellerDtoDataCheck);
    }

    @Test
    public void checkRequestWordSymbol() {
        request();
        given(REQUEST_SPECIFICATION)
                .param(fileUtils.getParamKey(), "auto?us")
                .get(fileUtils.getDomain() + GET_CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("isEmpty()", is(true));
    }
}
