package functionalTests;

import dataProviders.DataProviders;
import dto.SpellerDto;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SpellerTest {

    @Test(dataProvider = "textTestData", dataProviderClass = DataProviders.class)
    void checkText(String testText, List<String> textToCheck) {

        SpellerDto[] spellerText = new SpellerSteps().checkText(testText);
        new SpellerAssertions(spellerText).verifyWordsList(textToCheck);
    }

    @Test(dataProvider = "textsTestData", dataProviderClass = DataProviders.class)
    void checkTexts(String testTexts, List<String> textToCheck) {

        SpellerDto[][] spellerText = new SpellerSteps().checkTexts(testTexts);

        assertTrue(spellerText[0][0].getS().retainAll(textToCheck));
    }
}
