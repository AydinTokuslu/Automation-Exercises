package AutomationExercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AutomationExersize11 extends TestBase {

    @Test
    public void test() throws AWTException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        //5. Scroll down to footer
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_END);
        //6. Verify text 'SUBSCRIPTION'
        WebElement verifyElement=driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(verifyElement.isDisplayed());
        //7. Enter email address in input and click arrow button
        Faker faker = new Faker();
        String fakeMail=faker.internet().emailAddress();
        driver.findElement(By.id("susbscribe_email")).sendKeys(fakeMail);
        //driver.findElement(By.id("susbscribe_email")).sendKeys("aydin@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement verifyElement2=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(verifyElement2.isDisplayed());

    }
}
