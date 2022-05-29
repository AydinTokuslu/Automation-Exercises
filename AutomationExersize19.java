package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class AutomationExersize19 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //4. Verify that Brands are visible on left side bar
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Brands']")).isDisplayed());
        //5. Click on any brand name
        driver.findElement(By.xpath("//a[text()='Babyhug']")).click();
        //6. Verify that user is navigated to brand page and brand products are displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Brand - Babyhug Products']")).isDisplayed());
        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[text()='Madame']")).click();
        //8. Verify that user is navigated to that brand page and can see products
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Brand - Madame Products']")).isDisplayed());
    }
}
