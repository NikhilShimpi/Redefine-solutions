package Cooprate;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class JoinUS 
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

    // Test Case 1: Verify "Join Us" button navigates to "Create New Customer Account" page
    @Test(priority = 1)
    public void testJoinUsButtonNavigation() 
    {
        WebElement signInLogo = driver.findElement(By.xpath("//button[@title= \"Login\"]")); 
        signInLogo.click();

        WebElement joinUsButton = driver.findElement(By.xpath("//button[text()= \"JOIN US\"]")); 
        joinUsButton.click();
                              
        String expectedUrl = "https://beta-cg.parsonskellogg.shop/"; 
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Navigation to Create New Customer Account page failed.");
    }

 // =============================
    		
    // Test Case 2: Verify form elements are displayed on "Create New Customer Account" page
    @Test(priority = 2)
    public void testFormElementsDisplayed() 
    {
    
    	driver.findElement(By.xpath("//button[@title= \"Login\"]")).click(); // Replace with actual ID or locator
    	driver.findElement(By.xpath("//button[text()= \"JOIN US\"]")).click(); // Replace with actual ID or locator
        System.out.print(driver.getTitle());
        System.out.println();      
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
              
        Assert.assertTrue(driver.findElement(By.name("firstname")).isDisplayed(), "Enter your First Name..");
        Assert.assertTrue(driver.findElement(By.name("lastName")).isDisplayed(), "Enter your Last Name..");
        Assert.assertTrue(driver.findElement(By.name("companyName")).isDisplayed(), "Company field is not displayed.");
        Assert.assertTrue(driver.findElement(By.name("email")).isDisplayed(), "Enter your Email Address.");
        Assert.assertTrue(driver.findElement(By.name("phone")).isDisplayed(), "Enter your Phone Number.");
        Assert.assertTrue(driver.findElement(By.name("jobTitle")).isDisplayed(), "Enter your Job Title");
        Assert.assertTrue(driver.findElement(By.name("password")).isDisplayed(), "Please Enter more than 8 character.");
        Assert.assertTrue(driver.findElement(By.name("confirmPassword")).isDisplayed(), "Confirm Password does not match.");
        Assert.assertTrue(driver.findElement(By.name("address1")).isDisplayed(), "Enter your Address Line 1");
        Assert.assertTrue(driver.findElement(By.name("address2")).isDisplayed(), "Enter your Address Line 2");
        Assert.assertTrue(driver.findElement(By.name("zipCode")).isDisplayed(), "Enter your Zip Code.");
        Assert.assertTrue(driver.findElement(By.name("city")).isDisplayed(), "Enter your City.");
        Assert.assertTrue(driver.findElement(By.name("state")).isDisplayed(), "Enter your State.");
        Assert.assertTrue(driver.findElement(By.name("country")).isDisplayed(), "Country dropdown is not displayed.");
        Assert.assertTrue(driver.findElement(By.xpath("//label[@class=\"block mb-[7px]\"]")).isDisplayed(), "Tax Exempt Status radio button is not displayed.");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='SIGN UP']")).isDisplayed(), "Sign Up button is not displayed.");
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Cancel']")).isDisplayed(), "Cancel button is not displayed.");
   
   
    }

  //=====================================

	// Test Case 3: Verify form submission with valid data
    @Test(priority = 3)
    public void testFormSubmission() 
    {
        
    	driver.findElement(By.xpath("//button[@title= \"Login\"]")).click(); // Replace with actual ID or locator
    	driver.findElement(By.xpath("//button[text()= \"JOIN US\"]")).click(); // Replace with actual ID or locator
        System.out.print(driver.getTitle());  
   
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        driver.findElement(By.name("email")).sendKeys("johndoe@example.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("companyName")).sendKeys("Example Inc.");
        driver.findElement(By.name("jobTitle")).sendKeys("Developer");
        driver.findElement(By.name("password")).sendKeys("SecurePassword123");
        driver.findElement(By.name("confirmPassword")).sendKeys("SecurePassword123");
        driver.findElement(By.name("address1")).sendKeys("123 Main St");
        driver.findElement(By.name("address2")).sendKeys("Apt 4B");
        driver.findElement(By.name("zipCode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("Anytown");

        Select stateDropdown = new Select(driver.findElement(By.name("state")));
        stateDropdown.selectByVisibleText("New York");
 
        Select countryDropdown = new Select(driver.findElement(By.name("country")));
        countryDropdown.selectByVisibleText("United States");

        driver.findElement(By.name("isTaxableuser")).click();
        driver.findElement(By.xpath("//button[text()='SIGN UP']")).click();

    }

    // Test Case 4: Verify cancel button functionality
    @Test(priority = 4)
    public void testCancelButtonFunctionality() 
    {
    	driver.findElement(By.xpath("//button[@title= \"Login\"]")).click(); // Replace with actual ID or locator
    	driver.findElement(By.xpath("//button[text()= \"JOIN US\"]")).click(); // Replace with actual ID or locator
   
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath("//a[text()='Cancel']")).click();
        
        String expectedUrl = "https://beta-cg.parsonskellogg.shop/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Cancel button did not navigate back to the homepage.");
    }
    
}


