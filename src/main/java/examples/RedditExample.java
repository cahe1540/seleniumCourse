package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RedditExample {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/cahe1/IdeaProjects/seleniumCourse/src/main/java/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.reddit.com");
        try{
            driver.findElement(By.xpath("//*[@href='https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com%2F']"))
                    .click();
              WebDriverWait wait = new WebDriverWait(driver, 30);
              WebElement input = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#loginUsername"))));
              input.sendKeys("aaaaaaa");
            //driver.findElement(By.id("input#loginUsername")).sendKeys("hahaha");
            //driver.findElement(By.xpath("//*[@name = 'password']")).sendKeys("hohoho");
            //driver.findElement(By.xpath("//*[@name = 'login']")).click();
            //Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally{
            driver.close();
        }
    }
}
