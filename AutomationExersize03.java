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

public class AutomationExersize03 {
    /*
    Test Case 3: Login User with incorrect email and password
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfaElementi=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(anaSayfaElementi.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        //String expectedYazi="Login to your account";
        WebElement loginYazisi=driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(loginYazisi.isDisplayed());
        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("alitokkks@egmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("222222");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        String expectedYazi="Your email or password is incorrect!";
        WebElement hataElementi=driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        String actualHataYazisi=hataElementi.getText();
        Assert.assertEquals(expectedYazi,actualHataYazisi);
        driver.close();


    }
}
