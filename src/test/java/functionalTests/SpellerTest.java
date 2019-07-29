package functionalTests;

import static org.testng.Assert.assertTrue;

import dataProviders.DataProviders;
import dto.SpellerDto;
import org.testng.annotations.Test;
import service.SpellerSteps;

import java.util.Arrays;

public class SpellerTest {

    // todo доавь, пожалуйста, свою самописные проверки. Такую, например, как  new SpellerAssertions(response).verifyWordsList("дама", "Дима", "дома")
    @Test(dataProvider = "textTestData", dataProviderClass = DataProviders.class)
    void checkText(String testText, String textToCheck) {

        SpellerDto[] spellerText = new SpellerSteps().checkText(testText);


        assertTrue(spellerText[0].getS().contains(textToCheck));
    }

    @Test(dataProvider = "textsTestData", dataProviderClass = DataProviders.class)
    void checkTexts(String testTexts, String textToCheck) {

        SpellerDto[][] spellerText = new SpellerSteps().checkTexts(testTexts);

        assertTrue(spellerText[0][0].getS().retainAll(Arrays.asList(textToCheck)));
    }
}
