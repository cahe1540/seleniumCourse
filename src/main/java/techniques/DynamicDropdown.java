package techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        try{
            //elements
            WebElement dynamicDrop = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
            WebElement location = driver.findElement(By.xpath("//*[@value='BLR']"));

            //actions
            dynamicDrop.click();
            System.out.println(location.getAttribute("innerHTML"));

        }finally{
            driver.close();
        }
    }
}
