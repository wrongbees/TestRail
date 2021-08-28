package tests.HomeWork_13_tests;

import baseEntities.BaseTest;
import elements.homeWork_13.CheckBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;

public class CheckBoxTests extends BaseTest {

    @Test
    public void checkBoxTest_1() throws InterruptedException {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add/1");

        By check_box = By.id("show_announcement");
        CheckBox checkBox = new CheckBox(driver,check_box);

        checkBox.mark();
        Assert.assertTrue(checkBox.isSelected());

        checkBox.unMark();
        Assert.assertFalse(checkBox.isSelected());

        checkBox.mark();
        checkBox.mark();
        Assert.assertTrue(checkBox.isSelected());

        checkBox.unMark();
        checkBox.unMark();
        Assert.assertFalse(checkBox.isSelected());
    }
}
