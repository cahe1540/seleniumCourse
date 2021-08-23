package ActionsAndIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        try{
            WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
            driver.switchTo().frame(frame);
            WebElement draggable = driver.findElement(By.id("draggable"));
            System.out.println(draggable.getText());
            driver.switchTo().defaultContent();
        }finally{
            driver.close();
        }
    }
}
