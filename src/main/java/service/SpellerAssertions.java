package service;

import dto.SpellerDto;
import lombok.AllArgsConstructor;

import static org.testng.Assert.assertTrue;

@AllArgsConstructor
public class SpellerAssertions {

    private SpellerDto[] spellerDto;

    public void verifyWordsList(String expextedWordList) {
        assertTrue(spellerDto[0].getS().contains(expextedWordList));
    }

}
