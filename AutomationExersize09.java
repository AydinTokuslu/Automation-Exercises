package AutomationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class AutomationExersize09 extends TestBase {

    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("Sleeves");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        String expectedYazi="SEARCHED PRODUCTS";
        String actualYazi=driver.findElement(By.xpath("//h2[text()='Searched Products']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //8. Verify all the products related to search are visible
        List<WebElement> productList= driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (WebElement each: productList
             ) {
            System.out.println(each.getText());
        }
        productList.forEach(WebElement::isDisplayed);

    }
}
