package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AutomationExersize10 extends TestBase {

    @Test
    public void test() throws AWTException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
        //4. Scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Robot rbt = new Robot();
        //rbt.keyPress(KeyEvent.VK_END);
        //5. Verify text 'SUBSCRIPTION'
        String expectedYazi="SUBSCRIPTION";
        String actualYazi=driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("aydin@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement verifyElement=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(verifyElement.isDisplayed());
    }
}
