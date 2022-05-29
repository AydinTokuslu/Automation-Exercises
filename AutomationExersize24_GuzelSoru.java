package AutomationExercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AutomationExersize24_GuzelSoru extends TestBase {
    @Test
    public void test() throws IOException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
        //4. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        driver.findElement(By.xpath("(//button[text()='Continue Shopping'])[1]")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='28'])[1]")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//u[text()='View Cart'])[1]")).click();
        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//tbody")).isDisplayed());
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
        //9. Fill all details in Signup and create account
        Faker faker=new Faker();
        WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().name());
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
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
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("techpro");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
        WebElement ddm3=driver.findElement(By.xpath("//select[@id='country']"));
        Select select3=new Select(ddm3);
        select3.selectByVisibleText("New Zealand");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().cityName());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("00905664544788");
        driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
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
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='address item box']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Review Your Order']")).isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("thank you");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@class='form-control card-number']")).sendKeys("1234567891234567");
        driver.findElement(By.xpath("//input[@class='form-control card-cvc']")).sendKeys("311");
        driver.findElement(By.xpath("//input[@class='form-control card-expiry-month']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@class='form-control card-expiry-year']")).sendKeys("2033");
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[normalize-space()='Pay and Confirm Order']")).click();
        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']")).isDisplayed());
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();

        Path filePath = Path.of("C:\\Users\\aydin\\Downloads\\invoice.txt");
        String invoice = Files.readString(Path.of(filePath.toString()));
        System.out.println(invoice);
        //20. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='text-center']")).isDisplayed());
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
    }
}
