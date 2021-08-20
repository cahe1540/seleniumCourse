package techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            WebElement element = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText("USD");
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByIndex(2);
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByValue("INR");
            System.out.println(dropdown.getFirstSelectedOption().getText());
        }finally{
            driver.close();
        }

    }
}
