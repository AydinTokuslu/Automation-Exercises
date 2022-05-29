package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class AutomationExersize20 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Jeans");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        //6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());
        //7. Verify all the products related to search are visible
        List<WebElement> genelUrunListesi=driver.findElements(By.xpath("//div[@class='features_items']"));
        List<WebElement> arananUrunler=driver.findElements(By.xpath("//div[@class='features_items']"));
        for (WebElement each: arananUrunler
             ) {
            if (genelUrunListesi.contains(each)){
                System.out.println(each.getText()+" ");

            }
        }
        //8. Add those products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='33'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='35'])[1]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='37'])[1]")).click();
        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//a[normalize-space()='View Cart']")).click();
        List<WebElement> tumSecilenUrunler=driver.findElements(By.xpath("//tbody"));
        Assert.assertEquals(tumSecilenUrunler.size(),arananUrunler.size());
        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("(//a[@href='/login'])[1]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("aydin@ail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //11. Again, go to Cart page
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        //12. Verify that those products are visible in cart after login as well
        Assert.assertTrue(driver.findElement(By.xpath("//tbody")).isDisplayed());

    }
}
