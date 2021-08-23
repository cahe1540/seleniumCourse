package ActionsAndIframes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.Locale;

public class AjaxMouseInteractions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");

        Actions action = new Actions(driver);
        WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
        WebElement searchInput = driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
        action
                .moveToElement(searchInput)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("aaaaa")
                .build()
                .perform();

        Thread.sleep(2000);
        driver.close();
    }
}
