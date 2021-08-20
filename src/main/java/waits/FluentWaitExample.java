package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        try{
            WebElement start = driver.findElement(By.xpath("//div[@id='start']/button"));
            start.click();
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchElementException.class);

            WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement el = driver.findElement(By.xpath("//*[@id='finish']/h4"));
                    if(el.isDisplayed()) return el;
                    else return null;
                }
            });
            System.out.println(foo.getText());
        }finally {
            Thread.sleep(1000);
            driver.close();
        }
    }
}
