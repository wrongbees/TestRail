package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForAddTestCase")
    public static Object[][] dataForAddTestCase(){
        return new Object[][]{
                {"Lesson10_Privet_06onl","Title","Preconditions","Steps","ExpectedResult"}
        };
    }

    @DataProvider(name = "dataForEditTestCase")
    public static Object[][] dataForEditTestCase(){
        return new Object[][]{
                {"Lesson10_Privet_06onl","Title","Союз","Нерушимый","Республик","Свободных"}
        };
    }

    @DataProvider(name = "dataForDeleteTestCase")
    public static Object[][] dataForDeleteTestCase(){
        return new Object[][]{
                {"Lesson10_Privet_06onl","Союз"}
        };
    }
}
