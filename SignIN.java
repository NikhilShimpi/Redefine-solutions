package Cooprate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignIN 
{

    WebDriver driver;

    @BeforeMethod
    public void setup() 
    {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to Main Page
        driver.get("https://beta-cg.parsonskellogg.shop/");
    }
    
    @AfterClass
    public void tearDown() 
    {
        driver.quit();
    }

    @Test(priority = 1)
    public void testSignInButtonVisibility() 
    {
        // Test Case #1: Check if the sign-in button is visible
        WebElement signInButton = driver.findElement(By.xpath("//button[@title=\"Login\"]")); 
        Assert.assertTrue(signInButton.isDisplayed(), "Sign-in logo is not visible.");
    }

    @Test(priority = 2)
    public void testSignInPopup() 
    {
        // Test Case #2: Check if clicking the sign-in button opens the popup
        WebElement signInButton2 = driver.findElement(By.xpath("//button[@title=\"Login\"]")); 
        signInButton2.click();
        WebElement popup = driver.findElement(By.xpath("//div[text()=\"Sign in to Your\"]"));
        Assert.assertTrue(popup.isDisplayed(), "Sign-in popup did not appear.");
    }

    
    @Test(priority = 3)
    public void test_Email_and_password_Field_Presence() 
    {
        // Test Case #3: Check if email and password text field is present
       
    	WebElement signInButton2 = driver.findElement(By.xpath("//button[@title=\"Login\"]")); 
        signInButton2.click();
    	
        WebElement email = driver.findElement(By.name("email")); 
        Assert.assertTrue(email.isDisplayed(), "Email field is not visible in the popup.");

        WebElement password = driver.findElement(By.name("password")); 
        Assert.assertTrue(password.isDisplayed(), "Password field is not visible in the popup.");
    }
    

    @Test(priority = 4)
    public void testValidSignIn() {
        // Test Case #4: Check with valid sign-in functionality
    	
    	WebElement signInButton2 = driver.findElement(By.xpath("//button[@title=\"Login\"]")); 
        signInButton2.click();
    	
        WebElement email = driver.findElement(By.name("email")); 
        email.sendKeys("nikhilshimpi03@gmail.com");
      
        WebElement password = driver.findElement(By.name("password")); 
        password.sendKeys("123456780");
       
        WebElement signInButton = driver.findElement(By.xpath("//button[text()=\"SIGN IN\"]")); 
        signInButton.click();

        // Wait for the new page to load
        // Use WebDriverWait for dynamic waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
        wait.until(ExpectedConditions.urlContains("parsonskellogg")); //  "parsonskellogg" is a unique part of the new page's URL

        // Verify the URL of the new page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("parsonskellogg"), "User is not redirected to the correct page after sign-in.");
    } 

    @Test(priority = 5)
    public void testInvalidSignIn() 
    {
        // Test Case #5: Check with invalid sign-in functionality
       
    	WebElement signInButton2 = driver.findElement(By.xpath("//button[@title=\"Login\"]")); 
        signInButton2.click();
    	
        WebElement email = driver.findElement(By.name("email")); 
        email.sendKeys("xyz@gmail.com");
      
        WebElement password = driver.findElement(By.name("password")); 
        password.sendKeys("123456780");
       
        WebElement signInButton = driver.findElement(By.xpath("//button[text()=\"SIGN IN\"]")); 
        signInButton.click();
        
        // Wait for the error popup to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
        WebElement errorPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Error\"]"))); 

        // Assert that the popup window is displayed
        Assert.assertTrue(errorPopup.isDisplayed(), "Error popup is not displayed for invalid credentials.");

        // Verify the error message text
        WebElement errorMessage = errorPopup.findElement(By.xpath("//div[text()=\"User name and password invalid.\"]"));
        String expectedErrorMessage = "User name and password invalid."; 
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage, "Error message does not match.");
    
    }
    
}
    

