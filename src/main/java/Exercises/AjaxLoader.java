package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxLoader {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            WebElement toggleLoaderBtn = driver.findElement(By.xpath("//div[@id='content']/a[2]"));
            toggleLoaderBtn.click();
            WebElement loaderModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#modal")));
            WebElement fadeBG = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#fade")));
            System.out.println(fadeBG.getAttribute("style"));
            System.out.println(loaderModal.getAttribute("style"));
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#results")));
            System.out.println(notification.getText());
        }
        finally {
            driver.close();
        }
    }
}
