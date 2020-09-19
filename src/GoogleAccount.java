import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoogleAccount {
    WebDriver driver;
    @Before
    public  void openBrowser(){
        //creating a google account
        System.setProperty("webdriver.gecko.driver","C:\\shop\\sejal\\Sejal Testing\\software\\Firefox Driver\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.get("https://www.google.co.uk/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void googleAccount(){
        driver.findElement(By.linkText("I agree")).click();
        driver.findElement(By.id("gb_70")).click();
        driver.findElement(By.linkText("Use another account")).click();
        driver.findElement(By.linkText("I agree")).click();


        driver.findElement(By.linkText("Create account")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Radha");
       driver.findElement(By.id("lastName")).sendKeys("Krishna");
        driver.findElement(By.id("username")).sendKeys("testcase.makrubiya@gmail.com");
       driver.findElement(By.name("passwd")).sendKeys("Testing1");
       driver.findElement(By.name("Confirmpasswd")).sendKeys("Testing1");
        driver.findElement(By.id("month")).sendKeys("march");
        driver.findElement(By.name("day")).sendKeys("08");
        driver.findElement(By.name("year")).sendKeys("67");
        driver.findElement(By.id("gender")).click();
        driver.findElement(By.className("VfPpkd-RLmnJb")).click();





    }
    @After
    public  void closingBrowser(){
        driver.quit();
    }

}
