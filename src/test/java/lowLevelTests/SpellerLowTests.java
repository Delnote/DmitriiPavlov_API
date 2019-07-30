package lowLevelTests;

import dataProviders.DataProviders;
import dto.SpellerDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
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
    FileUtils fileUtils = new FileUtils();


    public void request() {
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
    public void newSimpleTest(String requestText, String word, List<String> s, int code, int pos, int col, int len, int row) {

        SpellerDto[] spellerDto = new SpellerSteps().checkText(requestText);

        SpellerDto[] newSpellerDto = {new SpellerDto()};
        newSpellerDto[0].setWord(word);
        newSpellerDto[0].setS(s);
        newSpellerDto[0].setCode(code);
        newSpellerDto[0].setPos(pos);
        newSpellerDto[0].setRow(row);
        newSpellerDto[0].setCol(col);
        newSpellerDto[0].setLen(len);

        assertEquals(spellerDto, newSpellerDto);
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
