package ActionsAndIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ChildWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        try{
            WebElement link = driver.findElement(By.cssSelector("a.blinkingText"));
            link.click();
            Set<String> windows = driver.getWindowHandles(); //[parent, child]
            Iterator<String> it = windows.iterator();
            String parentId = it.next();
            String childId = it.next();
            driver.switchTo().window(childId);
            String data = driver.findElement(By.cssSelector(".im-para.red")).getText();
            System.out.println(data);
        }finally {
            Thread.sleep(15000);
            driver.quit();
        }

    }
}
