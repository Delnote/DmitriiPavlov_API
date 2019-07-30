package service;

import dto.SpellerDto;
import lombok.AllArgsConstructor;

import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@AllArgsConstructor
public class SpellerAssertions {

    private SpellerDto[] spellerDto;

    public void verifyWordsList(SpellerDto[] response) {
        if (response[0].getWord().equals("mon th")) {
            assertEquals(response[0].getS().size(), 3);
            assertTrue(response[0].getS().containsAll(asList("month", "months", "month")));
        } else if (response[0].getWord().equals("laptoop")) {
            assertEquals(response[0].getS().size(), 3);
            assertTrue(response[0].getS().containsAll(asList("laptop", "laptops", "leptop")));
        } else if (response[0].getWord().equals("dicti0nary")) {
            assertEquals(response[0].getS().size(), 3);
            assertTrue(response[0].getS().containsAll(asList("dictionary", "dictinary", "dictio0nary")));
        } else if (response[0].getWord().equals("ki chen")) {
            assertEquals(response[0].getS().size(), 4);
            assertTrue(response[0].getS().containsAll(asList("kitchen", "kichen", "ki chan", "kitchens")));
        } else if (response[0].getWord().equals("oceak")) {
            assertEquals(response[0].getS().size(), 3);
            assertTrue(response[0].getS().containsAll(asList("ocean", "ocak", "ocea")));
        }
    }

}
