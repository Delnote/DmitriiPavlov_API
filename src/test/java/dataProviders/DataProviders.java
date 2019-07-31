package dataProviders;

import dto.SpellerDto;
import org.testng.annotations.DataProvider;

import static java.util.Arrays.asList;

public class DataProviders {

    @DataProvider
    public Object[][] textTestData() {
        return new Object[][] {
                {"mon th", "month"},
                {"laptoop", "laptop"},
                {"dicti0nary", "dictionary"},
                {"ki chen", "kitchen"},
                {"oceak", "ocean"}
        };
    }

    @DataProvider
    public Object[][] textsTestData() {
        return new Object[][] {
                {"the+weatther+is+fine", "weather"},
                {"new m0bile phone ", ""},
                {"gredt idea", "great"},
                {"prooper user name", ""},
                {"football chamqionship", "championship"}
        };
    }

    @DataProvider
    public Object[][] singleWordDataToCheck() {
        return new Object[][] {
                {"the+weatther+is+fine", new SpellerDto(1, 4, 0, 4, 8, "weatther", asList("weather", "wheather"))},
                {"exa ple", new SpellerDto(1, 0, 0, 0, 7, "exa ple", asList("example", "exam ple", "exa mple", "exaple"))},
                {"comp8ter", new SpellerDto(1, 0, 0, 0, 8, "comp8ter", asList("computer", "computed", "compyter"))}
        };
    }


}
