package testngPackage;

import basePackage.CrossBrowserBaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddJacketToCartParallelBrowser extends CrossBrowserBaseClass
{
    @Test
    public void doLogin()
    {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Test(dependsOnMethods = "doLogin")
    public void selectProduct()
    {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();

        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Test(dependsOnMethods = "selectProduct")
    public void fillDetailsAndPurchaseItem()
    {
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("sai");

        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("asd");

        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("2145654");

        driver.findElement(By.xpath("//input[@id='continue']")).click();

        driver.findElement(By.xpath("//button[@name='finish']")).click();

        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
    }
}
