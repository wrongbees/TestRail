package tests.HerocuApplication;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class Herocu_Lesson12_Test extends BaseTest {
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
//   iFrame - дополнительно
//   1. Открыть Onliner.by
//   2. В строке поиска ввести какое-то значение для поиска (например "Тостер")
//   3. Дождаться появление iFrame
//   4. Переключиться в iFrame
//   5. Взять название первого элемента из списка
//   6. Удалить поисковое значение и ввести полученное на шаге 5
//   7. Закрыть окно поиска
//   8. Проверить что искомый предмет отображается на экране

    @Test
    public void iFrameOnlinerTest() throws InterruptedException {
        //1
        driver.get("https://www.onliner.by/");

        By field_search = By.xpath("//input[@class='fast-search__input']");
        By field_search_in_iframe = By.xpath("//input[@class='search__input']");
        By modal_iframe = By.xpath("//iframe[@class='modal-iframe']");
        By field_search_close = By.xpath("//span[@class='search__close']");
        By product_page_title = By.xpath("//div[@class ='catalog-masthead']/h1");

        WebElement searchField = driver.findElement(field_search);

        //2
        searchField.sendKeys("лыжи");
        //3
        WebElement iframe = wait.waitForVisibility(modal_iframe);
        //4
        driver.switchTo().frame(iframe);
        //5
        wait.waitForVisibility(By.xpath("//div[@class='product__title']/a"));
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product__title']/a"));
        //6
        WebElement iFrameFieldSearch = driver.findElement(field_search_in_iframe);
        iFrameFieldSearch.clear();
        String productName = productList.get(0).getText();
        iFrameFieldSearch.sendKeys(productName);
        productList.get(0).click();
        //7
        driver.switchTo().defaultContent();
        //8
        Assert.assertEquals(wait.waitForVisibility(product_page_title).getText(),productName);
    }

//    JavaScriptExecutor
//   1. Открыть страницу onliner.by
//   2. Реализовать скролирование в самый низ страницы через JS
    @Test
    public void JSExecutorScrollingTest() throws InterruptedException {

        By rules_return = By.xpath("//a[contains(text(),'Правила возврата')]");
       //1
        driver.get("https://www.onliner.by/");
        //2
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");


    }

}
