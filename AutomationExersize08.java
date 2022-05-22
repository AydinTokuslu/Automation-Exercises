package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class AutomationExersize08 extends TestBase {

    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]")).isDisplayed());
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //8. User is landed to product detail page
        System.out.println(driver.findElement(By.xpath("//div[@class='product-details']")).getText());
        //9. Verify that detail detail is visible:
        // product name, category, price, availability, condition, brand
        System.out.println(driver.findElement(By.xpath("//div[@class='product-details']")).getText());

    }

}
