package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class AutomationExersize17 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed());
        //4. Add products to cart
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='3']")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='7']")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='8']")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//u")).click();
        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='container'])[2]")).isDisplayed());
        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
        //8. Verify that product is removed from the cart
        //Assert.assertFalse(driver.findElement(By.xpath("//tbody")).getText().contains(driver.findElement(By.xpath("//tr[@id='product-1']")).getText()));
        //Assert.assertNotSame(driver.findElement(By.xpath("//tbody")).getText(),driver.findElement(By.xpath("//tr[@id='product-1']")).getText());
        Assert.assertNotEquals(driver.findElement(By.xpath("//tbody")).getText(),driver.findElement(By.xpath("//tr[@id='product-1']")).getText());
    }
}
