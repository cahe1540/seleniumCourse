package FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCart {

    public static void addProducts(List<WebElement> products, List<WebElement> buttons, ArrayList <String> names){
        for(String name: names){
            for(int i = 0; i< products.size(); i++){
                if(products.get(i).getText().contains(name)){
                    buttons.get(i).click();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // set up
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 15);

        // main page
        WebElement checkoutBtn = driver.findElement(By.xpath("//div[@class='action-block']/button"));
        WebElement cartIcon = driver.findElement(By.cssSelector("a.cart-icon"));

        List<WebElement> products = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By
                                .cssSelector("h4.product-name")));

        List<WebElement> buttons = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By
                                .xpath("//div[@class='product-action']/button")));

        ArrayList <String> itemsToAdd = new ArrayList<>();
        products.forEach((product) -> {
            itemsToAdd.add(product.getText().split("-")[0].trim());
        });

        addProducts(products, buttons, itemsToAdd);
        cartIcon.click();
        checkoutBtn.click();

        // shopping-cart page
        WebElement promoCodeInput = driver.findElement(By.cssSelector("input.promoCode"));
        WebElement applyPromoBtn = driver.findElement(By.cssSelector("button.promoBtn"));
        WebElement cartButton = driver.findElement(By.xpath("//div[@class='products']/div/button"));

        promoCodeInput.sendKeys("abcdefg");
        applyPromoBtn.click();
        cartButton.click();
        Thread.sleep(1000);
        driver.close();
    }
}
