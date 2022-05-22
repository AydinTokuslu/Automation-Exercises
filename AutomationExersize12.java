package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class AutomationExersize12 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed());
        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //5. Hover over first product and click 'Add to cart'
        WebElement firstProductElementi=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[1]"));
        System.out.println(firstProductElementi.getText());
        System.out.println("");
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        //7. Hover over second product and click 'Add to cart'
        WebElement secondProductElementi=driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));
        System.out.println(secondProductElementi.getText());
        System.out.println("");
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        //9. Verify both products are added to Cart
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Men Tshirt']")).isDisplayed());
        //10. Verify their prices, quantity and total price
        String ilkUrunFiyat=driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]")).getText().replaceAll("\\D","");
        System.out.println(ilkUrunFiyat);
        Assert.assertEquals("500",ilkUrunFiyat);
        String ilkUrunQuantity=driver.findElement(By.xpath("(//button[text()='1'])[1]")).getText().replaceAll("\\D","");
        System.out.println(ilkUrunQuantity);
        Assert.assertEquals("1",ilkUrunQuantity);
        String ilkUrunTotalFiyat=driver.findElement(By.xpath("(//p[text()='Rs. 500'])[2]")).getText().replaceAll("\\D","");
        System.out.println(ilkUrunTotalFiyat);
        Assert.assertEquals("500",ilkUrunTotalFiyat);
        System.out.println("");
        String ikinciUrunFiyat=driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]")).getText().replaceAll("\\D","");
        System.out.println(ikinciUrunFiyat);
        Assert.assertEquals("400",ikinciUrunFiyat);
        String ikinciUrunQuantity=driver.findElement(By.xpath("(//button[text()='1'])[2]")).getText().replaceAll("\\D","");
        System.out.println(ikinciUrunQuantity);
        Assert.assertEquals("1",ikinciUrunQuantity);
        String ikinciUrunTotalFiyat=driver.findElement(By.xpath("(//p[text()='Rs. 400'])[2]")).getText().replaceAll("\\D","");
        System.out.println(ikinciUrunTotalFiyat);
        Assert.assertEquals("400",ikinciUrunTotalFiyat);


    }
}
