package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/cahe1/IdeaProjects/seleniumCourse/src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        System.out.println(driver.getTitle()); // validtae if you're on correct title
        System.out.println(driver.getCurrentUrl()); // validate if you're on correct url
        System.out.println(driver.getPageSource()); // print page src

        driver.get("http://yahoo.com");
        driver.navigate().back();
        driver.close(); // closes current browser
        //driver.quit(); // closes ALL browsers open by Selenium script

    }
}
