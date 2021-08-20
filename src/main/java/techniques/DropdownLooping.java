package techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DropdownLooping {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        try{
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            WebElement dropdown = driver.findElement(By.cssSelector("div#divpaxinfo"));
            dropdown.click();
            WebElement adultAdd = driver.findElement(By.id("hrefIncAdt"));
            adultAdd.click();
            WebElement childAdd = driver.findElement(By.id("hrefIncChd"));
            childAdd.click();
            WebElement infantAdd = driver.findElement(By.id("hrefIncInf"));
            infantAdd.click();
            WebElement btnClose = driver.findElement(By.id("btnclosepaxoption"));
            for(int i = 0; i<3; i++) {
                infantAdd.click();
            }
            btnClose.click();
            System.out.println(dropdown.getText());
        }finally{
            Thread.sleep(500);
            driver.close();
        }
    }
}
