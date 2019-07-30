package dataProviders;

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
                {"the+weatther+is+fine", "weatther", asList("weather", "wheather"), 1, 4, 4, 8, 0},
                {"exa ple" , "exa ple", asList("example", "exam ple", "exa mple", "exaple"), 1, 0, 0, 7, 0},
                {"comp8ter" , "comp8ter", asList("computer", "computed", "compyter"), 1, 0, 0, 8, 0}
        };
    }


}
