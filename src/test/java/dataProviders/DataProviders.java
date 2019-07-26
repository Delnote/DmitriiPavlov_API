package dataProviders;

import org.testng.annotations.DataProvider;

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


}
