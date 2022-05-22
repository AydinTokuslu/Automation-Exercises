package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExersize02 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }


    @Test
    public void test01() {

    //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    //  3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("//html"));
        if (homePage.isDisplayed()){
            System.out.println("homepage test PASSED");
        }else{
            System.out.println("homepage test FAILED");
        }
     // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    //  5. Verify 'Login to your account' is visible
        WebElement login=driver.findElement(By.xpath("//h2"));
        if (login.isDisplayed()){
            System.out.println("login test PASSED");
        }else{
            System.out.println("login test FAILED");
        }
    //  6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("elif@hotmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("22222");
    //  7. Click 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    //  8. Verify that 'Logged in as username' is visible
        WebElement loginCheck=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[9]/a"));
        if (loginCheck.isDisplayed()){
            System.out.println("login check test PASSED");
        }else{
            System.out.println("login check test FAILED");
        }
    //  9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
    //  10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement delAccount=driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
        String arananKelime = "ACCOUNT DELETED!";
        if (delAccount.equals(arananKelime)) {
            System.out.println("'ACCOUNT DELETED!' is visible");
        } else System.out.println("'ACCOUNT DELETED!' isn`t visible");


    }
}
