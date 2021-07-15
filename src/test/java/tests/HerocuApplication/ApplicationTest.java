package tests.HerocuApplication;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {
//    Alerts
//    Открыть страницу Alerts (http://the-internet.herokuapp.com/javascript_alerts)
//           1 Кликнуть по кнопке Click for JS Alert
//           2 Принять Alert
//           3 Проверить статус - принято
//           4 Кликнуть по кнопке Click for JS Confirm
//           5 Отказать в Alert-е
//           6 Проверить что статус - Отказано
//           7 Кликнуть по кнопке Click for JS Prompt
//           8 Ввести текст
//           9 Принять Alert
//           10 Проверить что статус содержит введенный текст

    @Test
    public void AlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        By button_jsAlert = By.xpath("//button[@onclick='jsAlert()']");
        By button_jsConfirm = By.xpath("//button[@onclick='jsConfirm()']");
        By button_jsPrompt = By.xpath("//button[@onclick='jsPrompt()']");
        By field_result = By.id("result");

        WebElement FieldResult = driver.findElement(field_result);

//1.
        wait.waitForVisibility(button_jsAlert).click();
//2.
        Alert alert = driver.switchTo().alert();
        alert.accept();
//3.
        Assert.assertEquals(wait.waitForVisibility(FieldResult).getText(), "You successfully clicked an alert");
//4.
        wait.waitForVisibility(button_jsConfirm).click();
//5.
        alert.dismiss();
//6.
        Assert.assertEquals(wait.waitForVisibility(FieldResult).getText(), "You clicked: Cancel");
//7.
        wait.waitForVisibility(button_jsPrompt).click();
//8.
        alert.sendKeys("Дайте мне белые крылья");
//9.
        alert.accept();
//10.
        Assert.assertEquals(wait.waitForVisibility(FieldResult).getText(), "You entered: Дайте мне белые крылья");
    }
//    iFrames
//    Открыть страницу iFames (iFrames
//Открыть страницу iFames (http://the-internet.herokuapp.com/iframe)
//Перейти в iFrame
//В поле ввода ввести некоторый текст
//Перейти в родительский фрейм и выбрать выравнивание по центру)
//         1.   Перейти в iFrame
//         2.   В поле ввода ввести некоторый текст
//         3.   Перейти в родительский фрейм и выбрать выравнивание по центру

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        By i_frame = By.id("mce_0_ifr");
        By field_iframe_input = By.xpath("//p[.='Your content goes here.']");
        By button_align_center = By.xpath("//button[@aria-label='Align center']");
//1.
        driver.switchTo().frame(driver.findElement(i_frame));
//2.
       WebElement fieldInput =  driver.findElement(field_iframe_input);
       fieldInput.clear();
       fieldInput.sendKeys("В поле ввода ввести некоторый текст");
//3.
        driver.switchTo().parentFrame();
        wait.waitForVisibility(button_align_center).click();

    }
    
}
