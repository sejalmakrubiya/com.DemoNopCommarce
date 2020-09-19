
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NopCommerce {

    private static String browserName = "Firefox";
    private WebDriver driver;

    @Before

    public void openBrowser() {
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\shop\\sejal\\Sejal Testing\\software\\BrowserDriver\\chromedriver.exe");
            driver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\shop\\sejal\\Sejal Testing\\software\\Firefox Driver\\geckodriver.exe");
            driver = new FirefoxDriver();

        }
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    //program 1
    @Test
    public void clothingShoppingWithScreenShot() {
        //click on Apparel on home page
        driver.findElement(By.linkText("Apparel")).click();
        //click on clothing
        driver.findElement(By.linkText("Clothing")).click();
        //click on sort by
       Select select = new Select (driver.findElement(By.id("products-orderby")));
       //select price : low to high
        select.selectByVisibleText("Price: Low to High");
        //click on display
        Select select1 = new Select(driver.findElement(By.id("products-pagesize")));
        //display 3 per page
        select1.selectByVisibleText("3");
        //click on list
        driver.findElement(By.linkText("List")).click();
        //Take a screen shot and store in life
        //Take Screenshot=As(OutputType.file);
        //file source = ts.getScreenshotAs(outputType.file)
        //FileUtils.copyFile(source,new File());

        //add to compare list Custom T-shirt
        driver.findElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //add to compare list oversized women t-shirt
        driver.findElement(By.xpath("//div[@class='product-list']//div[3]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //Click on product comparison in green link
        driver.findElement(By.linkText("product comparison")).click();
        //asserting product name custom t-shirt
        String expectedResult = "Custom T-Shirt";
        String actualResult = driver.findElement(By.xpath("//a[contains(text(),'Custom T-Shirt')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        //clear compare list
        driver.findElement(By.xpath("//a[@class='clear-list']")).click();
        //asserting message you have no items to compare
        String expectedText = "You have no items to compare.";
        String actualText = driver.findElement(By.xpath("//div[@class='no-data']")).getText();
        Assert.assertEquals(expectedText, actualText);



    }

    //program2
    @Test
    public void clothingShoppingWithoutScreenShot() {
        //click on Apparel
        driver.findElement(By.linkText("Apparel")).click();
        //click on clothing
        driver.findElement(By.linkText("Clothing")).click();
        //click on sort by
        Select select = new Select(driver.findElement(By.id("products-orderby")));
        //select price:High to low
        select.selectByVisibleText("Price: High to Low");
        //click on display
        Select select1 = new Select(driver.findElement(By.id("products-pagesize")));
        //select 9 per page
        select1.selectByVisibleText("9");
        //click on list
        driver.findElement(By.xpath("//a[text()='List']")).click();
        //add oversized women t-shirt to compare List
        driver.findElement(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[2]")).click();
        //click on product comparison from green line link
        driver.findElement(By.xpath("//a[text()='product comparison']")).click();
        //asserting product name oversized women t-shirt
        //String expected Name="oversized women t-shirt
        //String actualName=driver
       // Assert.assertEquals(expectedName,actualName);
        Assert.assertTrue(driver.findElement(By.linkText("Oversized Women T-Shirt")).isDisplayed());
        //clear compare list
        driver.findElement(By.xpath("//a[@class ='clear-list']")).click();
        //asserting message you have no items to compare
        String expectedText = "You have no items to compare.";
        String actualText = driver.findElement(By.xpath("//div[@class='no-data']")).getText();
        Assert.assertEquals(expectedText, actualText);



    }
    //program6
     @Test
    public void buyingBook(){
    //click on books
     driver.findElement(By.linkText("Books")).click();
    //click on fahrenheit 451 by ray bradbury
    driver.findElement(By.linkText("Fahrenheit 451 by Ray Bradbury")).click();
    //clear the quantity
    driver.findElement(By.xpath("//input[@id='product_enteredQuantity_37']")).clear();
    //enter the quantity 4
    driver.findElement(By.xpath("//input[@id='product_enteredQuantity_37']")).sendKeys("4");
    //add the book in wishlist
     driver.findElement(By.id("add-to-wishlist-button-37")).click();
    //verify the product has been added to your wishlist from green line
    String expectedMessage="the product has been added to your wishlist";
    String actualMessage= driver.findElement(By.className("content")).getText();
   // Assert.assertEquals("Verify passed",expectedMessage, actualMessage);
    //add product in to cart
    driver.findElement(By.id("add-to-cart-button-37")).click();
    // go to cart from top green message
    driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();
    //click on terms and condition
    driver.findElement(By.id("termsofservice")).click();
    //click on checkout
     driver.findElement(By.id("checkout")).click();
    //click on checkout as guest
      driver.findElement(By.xpath("//input[@class='button-1 checkout-as-guest-button']")).click();
      //filling all personal details
         driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Reena");
         driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Roy");
         driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("reenaRoy@test.com");
         Select select = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
         select.selectByVisibleText("United Kingdom");
         driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
         driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("609 RamNagar");
         driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("gr6 8lo");
         driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("08563423905");
         driver.findElement(By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")).click();
         driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page div.page-body.checkout-data ol.opc li.tab-section.allow.active:nth-child(3) div.step.a-item form:nth-child(1) div.buttons:nth-child(2)> input.button-1.shipping-method-next-step-button")).click();
         driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
         driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
         //add card details
         Select select1 =new Select(driver.findElement(By.id("CreditCardType")));
         select1.selectByVisibleText("Master card");
         driver.findElement(By.id("CardholderName")).sendKeys("Mr Roy");
         driver.findElement(By.id("CardNumber")).sendKeys("567896432670004");
         driver.findElement(By.id("ExpireMonth")).sendKeys("04");
         driver.findElement(By.id("ExpireYear")).sendKeys("2021");
         driver.findElement(By.id("CardCode")).sendKeys("324");
         driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
         //continue
         driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.checkout-page div.page-body.checkout-data ol.opc li.tab-section.allow.active:nth-child(6) div.step.a-item div.buttons:nth-child(2) > input.button-1.confirm-order-next-step-button")).click();

         //asserting confirmation message
         String expectedText= "Your order has been successfully processed!";
         String actualText = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();
         Assert.assertEquals("Order Completed",expectedText,actualText);




     }
     //program5
     @Test
     public void verifyRegistration(){
         DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss");
         //get current date time with Date()
         Date date = new Date();
         //now format the date
         String date1 = dateFormat.format(date);
         String email = "abc" + date1 + "@yahoo.com";
         // click on register
         driver.findElement(By.className("ico-register")).click();
         driver.findElement(By.id("gender-male")).click();
         driver.findElement(By.id("FirstName")).sendKeys("Sejal");
         driver.findElement(By.id("LastName")).sendKeys("Makrubiya");
         driver.findElement(By.name("DateOfBirthDay")).sendKeys("2");
         driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("March");
         driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1989");
         driver.findElement(By.id("Email")).sendKeys(email);
         driver.findElement(By.name("Company")).sendKeys("xyz");
         driver.findElement(By.id("Password")).sendKeys("gujrati23");
         driver.findElement(By.id("ConfirmPassword")).sendKeys("gujrati23");
         driver.findElement(By.id("register-button")).click();
         // To Verify message "your registration completed";
         String expectedMessage ="Your registration completed";
         String actualMessage = driver.findElement(By.className("result")).getText();
         Assert.assertEquals("Registered successfully", expectedMessage, actualMessage);
         //now log out and log in again with registered email address
         driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
         driver.findElement(By.className("ico-login")).click();
         driver.findElement(By.id("Email")).sendKeys(email);
         driver.findElement(By.id("Password")).sendKeys("gujrati23");
         driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();


     }
     //program7
     @Test
    public void addingVirtualGiftCard() {

         DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss");
         //get current date time with Date()
         Date date = new Date();
         //NOw format the date
         String date1 = dateFormat.format(date);
         String myEmail = "abc" + date1 + "@yahoo.com";
         String recipientEmail = "automation" + date1 + "@yahoo.com";

         //click on register
         driver.findElement(By.className("ico-register")).click();
         driver.findElement(By.id("gender-male")).click();
         driver.findElement(By.id("FirstName")).sendKeys("Sejal");
         driver.findElement(By.id("LastName")).sendKeys("Makrubiya");
         driver.findElement(By.name("DateOfBirthDay")).sendKeys("2");
         driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("March");
         driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1989");
         driver.findElement(By.id("Email")).sendKeys(myEmail);
         driver.findElement(By.name("Company")).sendKeys("xyz");
         driver.findElement(By.id("Password")).sendKeys("gujrati23");
         driver.findElement(By.id("ConfirmPassword")).sendKeys("gujrati23");
         driver.findElement(By.id("register-button")).click();

         //now log out and log in again with registered email address
         driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
         driver.findElement(By.className("ico-login")).click();
         driver.findElement(By.id("Email")).sendKeys(myEmail);
         driver.findElement(By.id("Password")).sendKeys("gujrati23");
         driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
         //click on gift card
         driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Gift Cards')]")).click();
         //adding a virtual gift card in the cart
         driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
         //filling all the personal details
         driver.findElement(By.id("giftcard_43_RecipientName")).sendKeys("Sita");
         driver.findElement(By.id("giftcard_43_RecipientEmail")).sendKeys(recipientEmail);
         driver.findElement(By.id("giftcard_43_SenderName")).sendKeys("Radha");
         driver.findElement(By.id("giftcard_43_SenderEmail")).sendKeys(myEmail);
         //click on send an email a friend
         driver.findElement(By.xpath("//input[@value='Email a friend']")).click();
     }


     @After
    public void  closingBrowser() {
        driver.quit();
     }
























}