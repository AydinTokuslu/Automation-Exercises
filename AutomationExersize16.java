package AutomationExercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExersize16 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed());
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("aydin@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("22222");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //6. Verify 'Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
        //7. Add products to cart
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[45]")).click();
        //8. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        //9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='cart_items']")).isDisplayed());
        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //11. Verify Address Details and Review Your Order
        WebElement adressElementi=driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(adressElementi.isDisplayed());
        WebElement reviewElementi=driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(reviewElementi.isDisplayed());
        //12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("thank you");
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        Faker faker=new Faker();
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("2233112244557788");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("311");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2026");
        //14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[normalize-space()='Pay and Confirm Order']")).click();
        //15. Verify success message 'Your order has been placed successfully!'
        WebElement mesajElementi=driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(mesajElementi.isDisplayed());
        //16. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}
