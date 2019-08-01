package lowLevelTests;

import baseTest.BaseTest;
import dataProviders.DataProviders;
import dto.SpellerDto;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import service.SpellerSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;
import static service.URI.GET_CHECK_TEXT;

public class SpellerLowTests extends BaseTest {

    @Test(dataProvider = "singleWordDataToCheck", dataProviderClass = DataProviders.class)
    public void newSimpleTest(String requestText, SpellerDto[] spellerDtoDataCheck) {

        SpellerDto[] spellerDto = new SpellerSteps().checkText(requestText);

        assertEquals(spellerDto, spellerDtoDataCheck);
    }

    @Test
    public void checkRequestWordSymbol() {
        given(REQUEST_SPECIFICATION)
                .param(fileUtils.getParamKey(), "auto?us")
                .get(fileUtils.getDomain() + GET_CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("isEmpty()", is(true));
    }
}
