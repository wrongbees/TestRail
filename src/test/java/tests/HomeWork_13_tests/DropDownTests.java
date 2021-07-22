package tests.HomeWork_13_tests;

import baseEntities.BaseTest;
import elements.homeWork_13.DropDown;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;
import java.rmi.UnexpectedException;

public class DropDownTests extends BaseTest {

    @Test
    public void dropDownTest_1() throws InterruptedException, UnexpectedException {

        By user_dropdown = By.id("navigation-menu");

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        DropDown dropDown = new DropDown(driver, user_dropdown);
        dropDown.openingDropDown();
        System.out.println(dropDown.getElementsCount());
        dropDown.printElementsText();
        dropDown.selectElement("Keyboard Shortcuts");

    }


    @Test
    public void dropDownTest_2() throws InterruptedException, UnexpectedException {
        By user_dropdown = By.id("navigation-user");

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        DropDown dropDown = new DropDown(driver, user_dropdown);
        dropDown.openingDropDown();
        System.out.println(dropDown.getElementsCount());
        dropDown.printElementsText();
        dropDown.selectElement(1);

    }

    @Test
    public void dropDownTest_3() throws InterruptedException, UnexpectedException {

        By user_dropdown = By.id("inProgressLink");

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        DropDown dropDown = new DropDown(driver, user_dropdown);
        dropDown.openingDropDown();
        System.out.println(dropDown.getElementsCount());
        dropDown.printElementsText();
        dropDown.selectElement(2);

    }

    @Test
    public void dropDownTest_4() throws InterruptedException, UnexpectedException {
        By user_dropdown = By.xpath("//*[@class='toolbar-button toolbar-button-last content-header-button " +
                "button-report dropdownLink toolbar-button-first']");

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login();

        driver.get("https://aqa06onl02.testrail.io/index.php?/projects/overview/1");

        DropDown dropDown = new DropDown(driver, user_dropdown);
        dropDown.openingDropDown();
        System.out.println(dropDown.getElementsCount());
        dropDown.printElementsText();
        dropDown.selectElement(2);

    }
}
