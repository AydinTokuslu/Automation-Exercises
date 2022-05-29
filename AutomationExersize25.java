package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

import java.io.IOException;

public class AutomationExersize25 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
        //4. Scroll down page to bottom
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed());
        //6. Click on arrow at bottom right side to move upward
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("aydin@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-angle-up']")).click();

        //7. Verify that page is scrolled up and 'Full-Fledged practice website
        // for Automation Engineers' text is visible on screen
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).isDisplayed());
    }
}
