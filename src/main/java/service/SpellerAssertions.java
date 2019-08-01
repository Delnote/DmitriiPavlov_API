package service;

import dto.SpellerDto;
import lombok.AllArgsConstructor;

import java.util.List;

import static org.testng.Assert.assertTrue;

@AllArgsConstructor
public class SpellerAssertions {

    private SpellerDto[] spellerDto;

    public void verifyWordsList(List<String> expextedWordList) {
        assertTrue(spellerDto[0].getS().containsAll(expextedWordList));
    }
}
