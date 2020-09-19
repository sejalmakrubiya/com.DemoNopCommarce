import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;

public class Boots {
    WebDriver driver;
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\shop\\sejal\\Sejal Testing\\software\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.boots.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void medicineShopping() {
        //instantiate action class
        Actions actions=new Actions(driver);
        //retrieve webElement 'shop by department' to perform mouse hover
        WebElement target=driver.findElement(By.linkText("Shop by department"));
        // Mouse Hover  menuOption 'shop by department'
        actions.moveToElement(target).build().perform();
        WebElement SubTarget=driver.findElement(By.linkText("health & pharmacy"));
        actions.moveToElement(SubTarget).build().perform();
        WebElement SubTarget1=driver.findElement(By.linkText("medicines & treatments"));
        actions.moveToElement(SubTarget1).build().perform();
        WebElement SelectTarget=driver.findElement(By.linkText("pain"));
        actions.moveToElement(SelectTarget).build().perform();
        actions.click().build().perform();
        String expectedValue="Order online now";
        String actualValue=driver.findElement(By.xpath("//span[text()='Order online now']")).getText();
        Assert.assertTrue("User is in the pain page",expectedValue.equalsIgnoreCase(actualValue));




    }
@After
    public void closeBrowser(){
        driver.quit();
}

}