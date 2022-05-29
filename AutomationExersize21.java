package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class AutomationExersize21 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //5. Click on 'View Product' button
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
        //6. Verify 'Write Your Review' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//a[text()='Write Your Review'])[1]")).isDisplayed());
        //7. Enter name, email and review
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("aydın");
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("aydin@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='review']")).sendKeys("thank you for good and qualified products");
        //8. Click 'Submit' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //9. Verify success message 'Thank you for your review.'
        String expectedYazi="Thank you for your review.";
        //String tumSayfa=driver.findElement(By.xpath("//body")).getText();
        Assert.assertTrue(driver.findElement(By.xpath("//body")).getText().contains(expectedYazi));


    }
}
