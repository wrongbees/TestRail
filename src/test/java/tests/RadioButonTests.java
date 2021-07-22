package tests;

import baseEntities.BaseTest;

import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class RadioButonTests extends BaseTest {

    @Test
    public void radioButtonTest1() throws InterruptedException {
               LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add/1");
        RadioButton radioBatton = new RadioButton(driver, By.name("suite_mode"));
        radioBatton.selectByIndex(3);

        Thread.sleep(2000);


    }
}
