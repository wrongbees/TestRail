package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableRow {
    private UIElement uiElement;
    private WebDriver driver;
    private List<Cell> cellList = new ArrayList<>();

    public TableRow(WebDriver driver, By by){
        this.driver = driver;
        this.uiElement = new UIElement(driver,by);

        for(WebElement element: this.uiElement.findElements(By.tagName("td"))){
            cellList.add(new Cell(driver,element));
        }
    }

    public TableRow(WebDriver driver, WebElement webElement){
        this.driver = driver;
        this.uiElement = new UIElement(driver,webElement);

        for(WebElement element: this.uiElement.findElements(By.tagName("td"))){
            cellList.add(new Cell(driver,element));
        }
    }

    public int getCellsCount(){
        return cellList.size();
    }

    /***
     *
     * @param columnIndex индекс от 0
     * @return
     */
    public Cell getCellByIndex(int columnIndex){
        return cellList.get(columnIndex);
    }
}
