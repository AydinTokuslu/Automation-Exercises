package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExersize06 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());
        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("aydin");
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("aydin@gmail.com");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("sipariş iptali");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("geçen hafta sonu aldığım ürünün iptal edilmesini istiyorum.teşekkürler.");

        //7. Upload file
        WebElement upload=driver.findElement(By.xpath("//input[@type='file']"));
        upload.sendKeys("C:\\Users\\aydin\\Desktop\\YAZILIM\\1.pdf");

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successElement=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(successElement.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        WebElement homePage2=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage2.isDisplayed());
    }
}
