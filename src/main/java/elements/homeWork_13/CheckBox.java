package elements.homeWork_13;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private final UIElement uiElement;
    private final WebDriver driver;

    public CheckBox(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver,by);
    }

    private void click(){ this.uiElement.click();}

    public Boolean isSelect(){return uiElement.isSelected();}

    public void mark(){
        if (!this.isSelect())
            this.click();
    }

    public void unMark(){
        if (this.isSelect())
            this.click();
    }
}
