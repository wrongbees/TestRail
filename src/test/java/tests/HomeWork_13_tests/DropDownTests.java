package tests.HomeWork_13_tests;

import baseEntities.BaseTest;
import elements.homeWork_13.DropDown;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class DropDownTests extends BaseTest {

    @Test
    public void dropDownTest_1() throws InterruptedException {
        //By user_dropdown = By.id("navigation-user");
        By user_dropdown = By.id("navigation-menu");

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        DropDown dropDown = new DropDown(driver, user_dropdown);
        dropDown.openingDropDown();
        System.out.println(dropDown.getElementsCount());
        dropDown.printElementsText();
        dropDown.selectElement(2);
        Thread.sleep(2000);

    }
}
