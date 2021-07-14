package tests.TheInternetApplication;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ApplicationTests extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        By hot_spot = By.id("hot-spot");

        Actions actions = new Actions(driver);
        actions
                .moveToElement(wait.waitForToBeClickable(hot_spot))
                .contextClick()
                .build()
                .perform();
    }

    @Test
    public void DynamicControlsTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        By checkbox_by = By.xpath("//*[@type = 'checkbox']");
        By button_remove_by = By.xpath("//button[@onclick='swapCheckbox()']");
        By message_by = By.id("message");
        By input_field = By.xpath("//input");
        By button_enable = By.xpath("//button[@onclick ='swapInput()']");
        By messege_its_anabled = By.id("message");

        WebElement checkbox = wait.waitForVisibility(checkbox_by);
        checkbox.click();

        wait.waitForVisibility(button_remove_by).click();
        wait.waitForVisibility(message_by);
        wait.waitForInvisibility(checkbox);
        wait.waitForToBeNotClickable(input_field);
        wait.waitForVisibility(button_enable).click();
        wait.waitForVisibility(messege_its_anabled);
        wait.waitForToBeClickable(input_field);
    }

        @Test
        public void fileUploaderTest() {
            driver.get("http://the-internet.herokuapp.com/upload");
            String fileName = "pooh.jpg";

            File file = new File(getClass().getClassLoader().getResource("images/"+fileName).getFile());
            String path = file.getPath();

            By button_file_upload_by = By.id("file-upload");
            By button_submit_upload_by = By.id("file-submit");
            By field_uploaded_files_by = By.id("uploaded-files");

            WebElement buttonFileUpload = driver.findElement(button_file_upload_by);
            buttonFileUpload.sendKeys(path);

            driver.findElement(button_submit_upload_by).submit();

            String uploadedFileName = wait.waitForVisibility(field_uploaded_files_by).getText();
            Assert.assertEquals(uploadedFileName, fileName, "Invalid file loaded");

        }

    @Test
    public void fileDownloaderTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        File folder = new File(properties.getDownloadDir());

        By text_txt = By.xpath("//*[@href='download/test.txt']");

        WebElement element = wait.waitForVisibility(text_txt);
        element.click();
        Thread.sleep(4000);
        boolean isPresent = false;
        for(File file: folder.listFiles()){
            if(file.getName().equals(element.getText())){
                isPresent = true;
            }
        }
        Thread.sleep(4000);
        Assert.assertTrue(isPresent);

}
}
