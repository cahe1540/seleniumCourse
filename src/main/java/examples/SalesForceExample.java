package examples;

import okio.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SalesForceExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/cahe1/IdeaProjects/seleniumCourse/src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        try{
            driver.findElement(By.id("username")).sendKeys("hello");
            driver.findElement(By.id("password")).sendKeys("hello2");
            driver.findElement(By.xpath("//*[@id='Login']")).click();
            Thread.sleep(400);
            System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
        }finally {
            driver.close();
        }
    }
}
