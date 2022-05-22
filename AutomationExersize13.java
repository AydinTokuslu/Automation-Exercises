package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExersize13 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed());
        //4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("//a[@href='/product_details/4']")).click();
        //5. Verify product detail is opened
        WebElement productDetailElement=driver.findElement(By.xpath("//div[@class='product-details']"));
        Assert.assertTrue(productDetailElement.isEnabled());
        System.out.println(productDetailElement.getText());
        //6. Increase quantity to 4
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4");
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Stylish Dress']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='4']")).isDisplayed());

    }
}
