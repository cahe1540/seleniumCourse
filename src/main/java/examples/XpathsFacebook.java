package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathsFacebook {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cahe1\\IdeaProjects\\seleniumCourse\\src\\main\\java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        //xpaths
        /*driver.findElement(By.xpath("//*[@name='email']")).sendKeys("selenium1");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@name='login']")).click();
        */
        //css selectors
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("selenium1");;
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("password");
        driver.findElement(By.cssSelector("button[name='login']")).click();

        driver.close();
    }
}
