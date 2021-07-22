package tests.HomeWork_13_tests;

import baseEntities.BaseTest;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;

public class RadioButtonTests extends BaseTest {

    @Test
    public void radioButtonTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add/1");
        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));

        radioButton.selectByIndex(1);
        Assert.assertTrue(radioButton.isSelected(1));
        Assert.assertTrue(radioButton.isSelected("Use a single repository for all cases (recommended)"),
                "Указанный элемент не выбран");
        Thread.sleep(3000);
        radioButton.selectByText("Use multiple test suites to manage cases");
        Assert.assertTrue(radioButton.isSelected(3));
        Thread.sleep(3000);

    }

}
