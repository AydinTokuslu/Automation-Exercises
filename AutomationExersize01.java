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

public class AutomationExersize01 {

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
        driver.close();
    }


    @Test
    public void test01() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.xpath("/html"));
        if (homePage.isDisplayed()){
            System.out.println("homepage test PASSED");
        }else{
            System.out.println("homepage test FAILED");
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUser=driver.findElement(By.xpath("//div[@class='signup-form']"));
        if (newUser.isDisplayed()){
            System.out.println("user test PASSED");
        }else{
            System.out.println("user test FAILED");
        }
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("aydin");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("aydin@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInf=driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
        if (enterAccountInf.isDisplayed()){
            System.out.println("enter account test PASSED");
        }else{
            System.out.println("enter account test FAILED");
        }
        //9. Fill details:Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22222");
        driver.findElement(By.xpath("(//option[@value='3'])[1]")).click();
        driver.findElement(By.xpath("(//option[@value='3'])[2]")).click();
        driver.findElement(By.xpath("//option[@value='1978']")).click();

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@name='optin']")).click();
       // 12. Fill details:First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("aydin");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("tokuslu");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("techpro");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("menderes mah. barbaros cad.");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("karabulutlar sitesi e blok d:12");
        driver.findElement(By.xpath("//option[@value='Canada']")).click();
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("halifax");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("halifax");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("00905066905844");


        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
       // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCheck=driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        if (accountCheck.isDisplayed()){
            System.out.println("account check test PASSED");
        }else{
            System.out.println("account check test FAILED");
        }
       // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
       // 16. Verify that 'Logged in as username' is visible
        WebElement loginCheck=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a/b"));
        if (loginCheck.isDisplayed()){
            System.out.println("login check test PASSED");
        }else{
            System.out.println("login check test FAILED");
        }
       // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
       // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement delAccount=driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
        String arananKelime = "ACCOUNT DELETED!";
        if (delAccount.equals(arananKelime)) {
            System.out.println("'ACCOUNT DELETED!' is visible");
        } else System.out.println("'ACCOUNT DELETED!' isn`t visible");

    }



}
