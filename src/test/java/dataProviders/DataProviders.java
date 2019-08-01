package dataProviders;

import dto.SpellerDto;
import org.testng.annotations.DataProvider;

import static java.util.Arrays.asList;

public class DataProviders {

    @DataProvider
    public Object[][] textTestData() {
        return new Object[][] {
                {"mon th", asList("month")},
                {"laptoop", asList("laptop")},
                {"dicti0nary", asList("dictionary")},
                {"ki chen", asList("kitchen")},
                {"oceak", asList("ocean")}
        };
    }

    @DataProvider
    public Object[][] textsTestData() {
        return new Object[][] {
                {"the+weatther+is+fine", asList("weather")},
                {"new m0bile phone ", asList("mobile")},
                {"gredt idea", asList("great")},
                {"prooper user name", asList("proper")},
                {"football chamqionship", asList("championship")}
        };
    }

    @DataProvider
    public Object[][] singleWordDataToCheck() {
        return new Object[][] {
                {"the+weatther+is+fine",
                        new SpellerDto()
                        .setCode(1)
                        .setPos(4)
                        .setCol(4)
                        .setLen(8)
                        .setWord("weatther")
                        .setS(asList("weather", "wheather"))},
                {"exa ple",
                        new SpellerDto()
                        .setCode(1)
                        .setLen(7)
                        .setWord("exa ple")
                        .setS(asList("example", "exam ple", "exa mple", "exaple"))},
                {"comp8ter",
                        new SpellerDto()
                        .setCode(1)
                        .setLen(8)
                        .setWord("comp8ter")
                        .setS(asList("computer", "computed", "compyter"))
                }
        };
    }
}
