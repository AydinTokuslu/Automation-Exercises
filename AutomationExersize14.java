package AutomationExercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class AutomationExersize14 extends TestBase {

    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.tagName("html")).isDisplayed());
        //4. Add products to cart
        Actions actions=new Actions(driver);
        WebElement urun1=driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]"));
        actions.moveToElement(urun1).perform();
        actions.click(urun1).perform();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        WebElement urun2=driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[45]"));
        actions.moveToElement(urun2).perform();
        actions.click(urun2).perform();

        //5. Click 'Cart' button
        WebElement cart=driver.findElement(By.xpath("//a[@href='/view_cart']"));
        actions.click(cart).perform();

        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='cart_items']")).isDisplayed());
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.linkText("Register / Login")).click();
        //9. Fill all details in Signup and create account
        Faker faker=new Faker();
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().name());
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        //actions.keyDown(Keys.TAB).perform();
        //actions.keyDown(Keys.TAB).perform();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(faker.internet().password());
        WebElement ddm=driver.findElement(By.xpath("//select[@id='days']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("3");
        WebElement ddm1=driver.findElement(By.xpath("//select[@id='months']"));
        Select select1=new Select(ddm1);
        select1.selectByVisibleText("May");
        WebElement ddm2=driver.findElement(By.xpath("//select[@id='years']"));
        Select select2=new Select(ddm2);
        select2.selectByVisibleText("1980");
        //actions.keyDown(Keys.TAB).perform();
        //actions.keyDown(Keys.TAB).perform();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("techpro");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
        //actions.keyDown(Keys.TAB).perform();
        WebElement ddm3=driver.findElement(By.xpath("//select[@id='country']"));
        Select select3=new Select(ddm3);
        select3.selectByVisibleText("New Zealand");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().cityName());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("00905664544788");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String expectedYazi="ACCOUNT CREATED!";
        WebElement actualYaziElementi= driver.findElement(By.xpath("//h2"));
        String actualYazi= actualYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //12.Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement adressElementi=driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(adressElementi.isDisplayed());
        WebElement reviewElementi=driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(reviewElementi.isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("thank you");
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("2233112244557788");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("311");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2026");

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[normalize-space()='Pay and Confirm Order']")).click();
        //18. Verify success message 'Your order has been placed successfully!'
        WebElement mesajElementi=driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(mesajElementi.isDisplayed());
        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        //this page is not available


    }
}
