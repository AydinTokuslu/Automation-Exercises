package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class AutomationExersize18 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that categories are visible on left side bar
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Category']")).isDisplayed());
        //4. Click on 'Women' category
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[normalize-space()='Tops']")).click();
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Category']")).isDisplayed());
        String expectedYazi="WOMEN - TOPS PRODUCTS";
        String actualYazi=driver.findElement(By.xpath("//h2[normalize-space()='Women - Tops Products']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
        driver.findElement(By.xpath("//a[text()='Jeans ']")).click();
        //8. Verify that user is navigated to that category page
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Men - Jeans Products']")).isDisplayed());
    }
}
