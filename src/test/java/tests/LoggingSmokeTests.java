package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;
/*
*************************************************************************
запукается с помощью param.xml
*************************************************************************
 */
public class LoggingSmokeTests extends BaseTest {

    @Parameters({"login-value", "psw-value"})
    @Test
    public void apositiveLogInTest(String login, String password) throws InterruptedException {
         new LoginStep(driver,login, password);

        Assert.assertTrue(new DashboardPage(driver, true)
                .getDashboardNavigation().isDisplayed());

    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeLogInTest1(@Optional("Bla_Bla") String login, @Optional("Bla") String password) throws InterruptedException {
        new LoginStep(driver,login, password);

        Assert.assertTrue(new DashboardPage(driver, true)
                .getDashboardNavigation().isDisplayed());

    }

    @Parameters({"login-value", "psw-value"})
    @Test(expectedExceptions = AssertionError.class)
    public void negativeLogInTest2( String login, String password) throws InterruptedException {
        login ="Bla-Bla";
        new LoginStep(driver,login, password);

        Assert.assertTrue(new DashboardPage(driver, true)
                .getDashboardNavigation().isDisplayed());

    }

    @Parameters({"login-value", "psw-value"})
    @Test(expectedExceptions = AssertionError.class)
    public void negativeLogInTest3( String login, String password) throws InterruptedException {
        password = "Bla-Bla";
        new LoginStep(driver,login, password);

        Assert.assertTrue(new DashboardPage(driver, true)
                .getDashboardNavigation().isDisplayed());

    }
}
