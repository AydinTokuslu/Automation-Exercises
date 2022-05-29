package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class AutomationExersize22 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Scroll to bottom of page
        JavascriptExecutor jse6 = (JavascriptExecutor) ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //4. Verify 'RECOMMENDED ITEMS' are visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='recommended items']")).isDisplayed());
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("//a[@data-product-id='4']")).click();

        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        //7. Verify that product is displayed in cart page
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id='product-4']")).isDisplayed());

    }
}
