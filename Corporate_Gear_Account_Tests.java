package Cooprate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Corporate_Gear_Account_Tests 
{

	WebDriver driver;

    @BeforeMethod
    public void setup() 
    {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the form page
        driver.get("https://beta-cg.parsonskellogg.shop/peter-millar-corporate-sales.html");
    }
    
    @AfterMethod
    public void teardown() 
    {
        driver.quit(); // Close the browser
    }
	
   
    // 1. Test Case: Verify that the form page loads successfully
    @Test
    public void testFormPageLoad() 
    {
        String expectedTitle = "Custom Peter Millar | Corporate Apparel Sales";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page did not load as expected.");
    }
    

//+++++++++++++++++++++++++++++++++++
   
    // 2. Test Case: Verify that all form fields are present
    @Test
    public void testFormFieldsPresence() 
    {
        // Check the First Name field
        WebElement firstName = driver.findElement(By.name("firstName"));;
        Assert.assertTrue(firstName.isDisplayed(), "Enter your First Name.");        

        // Check the Last Name field
        WebElement lastName = driver.findElement(By.name("lastName"));
        Assert.assertTrue(lastName.isDisplayed(), "Enter your Last Name.");

        // Check the Company field
        WebElement company = driver.findElement(By.name("companyName"));
        Assert.assertTrue(company.isDisplayed(), "Enter Company name.");

        // Check the Are You An ASI Distributor
        WebElement Distributor = driver.findElement(By.xpath("//label[text()=\"Are You An ASI Distributor?*\"]"));
        Assert.assertTrue(Distributor.isDisplayed(), "Please select an option.");
        
        // Check the Email field
        WebElement email = driver.findElement(By.name("email"));
        Assert.assertTrue(email.isDisplayed(), "Enter your Email Address..");

        // Check the WebSite field
        WebElement Website = driver.findElement(By.name("website"));
        Assert.assertTrue(Website.isDisplayed(), "Enter a Website");
        
       // Check the Password field
        WebElement Password = driver.findElement(By.name("password"));
        Assert.assertTrue(Password.isDisplayed(), "Password is required");
     
        // Check the Confirm Password field
        WebElement CNFPassword = driver.findElement(By.name("confirmPassword"));
        Assert.assertTrue(CNFPassword.isDisplayed(), "Confirm Password is required 	.");
        
        // Check the Shipping address field
        WebElement Shipping = driver.findElement(By.name("address1"));
        Assert.assertTrue(Shipping.isDisplayed(), "Shipping address is required.");
        
       // Check the Shipping address field
        WebElement Shipping2 = driver.findElement(By.name("address2"));
        Assert.assertTrue(Shipping2.isDisplayed(), "Shipping address is required.");
        
        // Check the Phone field
        WebElement phone = driver.findElement(By.name("phone"));
        Assert.assertTrue(phone.isDisplayed(), "Enter your Phone Number..");

        // Check the Phone field
        WebElement zipcode = driver.findElement(By.name("zipcode"));
        Assert.assertTrue(zipcode.isDisplayed(), "Enter your Postal Code.");

        // Check the city field
        WebElement city = driver.findElement(By.name("city"));
        Assert.assertTrue(city.isDisplayed(), "City is Required.");

        // Check the purpose of order field
        WebElement purpose = driver.findElement(By.name("purpose"));
        Assert.assertTrue(purpose.isDisplayed(), "Purpose is required");
        
        // Check the state field
        WebElement state = driver.findElement(By.name("state"));
        Assert.assertTrue(state.isDisplayed(), "Enter your State");
        
        // Check the UnitedStates field
        WebElement UnitedStates = driver.findElement(By.name("country"));
        Assert.assertTrue(UnitedStates.isDisplayed(), "Purpose is required");

         // Check the UnitedStates field
        WebElement Quantity = driver.findElement(By.name("quantity"));
        Assert.assertTrue(Quantity.isDisplayed(), "Quantity is required");

        // Check the date field
        WebElement date = driver.findElement(By.name("inHandDate"));
        Assert.assertTrue(date.isDisplayed(), "In hands Date is required");
      
       //Check the message field
       WebElement message = driver.findElement(By.name("comment"));
       Assert.assertTrue(message.isDisplayed(), "Message is a required");
      
       // Check the submit button
       WebElement submit1 = driver.findElement(By.name("SUBMIT"));
    
    }
   
  
  // ++++++++++++++++++++++++++++++++++++ 
    
    
    
       // 3. Test Case: Verify Mandatory Fields with valid data
        @Test
        public void Verify_Mandatory_Fields() 
        {
        	
            // Check the First Name field
            WebElement firstName = driver.findElement(By.name("firstName"));; 
            firstName.sendKeys("Nikhil");

            // Check the Last Name field
            WebElement lastName = driver.findElement(By.name("lastName"));
            lastName.sendKeys("Shimpi");
            
            // Check the Company field
            WebElement company = driver.findElement(By.name("companyName"));
            company.sendKeys("xyz");
            
            // Check the Are You An ASI Distributor
            WebElement Distributor = driver.findElement(By.xpath("//input[@id=\"yes\"]"));
            Distributor.click();
            
            // Check the Email field
            WebElement email = driver.findElement(By.name("email"));
            Assert.assertTrue(email.isDisplayed(), "Enter your Email Address..");
            email.sendKeys("nikhil@gmail.com");
            
            // Check the WebSite field
            WebElement Website = driver.findElement(By.name("website"));
            Website.sendKeys("www.abc.com");
            
           // Check the Password field
            WebElement Password = driver.findElement(By.name("password"));
            Password.sendKeys("123456789");
         
            // Check the Confirm Password field
            WebElement CNFPassword = driver.findElement(By.name("confirmPassword"));
            CNFPassword.sendKeys("123456789");
            
            // Check the Shipping address field
            WebElement Shipping = driver.findElement(By.name("address1"));
            Shipping.sendKeys("abc road, near xyz, pune.");
            
           // Check the Shipping address field
            WebElement Shipping2 = driver.findElement(By.name("address2"));
            Shipping2.sendKeys("abc road, near xyz, pune.");
            
            // Check the Phone field
            WebElement phone = driver.findElement(By.name("phone"));
            phone.sendKeys("9876543210");
            
            // Check the Phone field
            WebElement zipcode = driver.findElement(By.name("zipcode"));
            zipcode.sendKeys("452468");
            
            // Check the city field
            WebElement city = driver.findElement(By.name("city"));
            city.sendKeys("pune");
            
            // Check the purpose of order field
            WebElement purpose = driver.findElement(By.name("purpose"));
            purpose.sendKeys("hoby");
            
            // Check the state field
            WebElement state = driver.findElement(By.name("state"));
            Select s1 = new Select(state);
            s1.selectByVisibleText("New York");
            
           // Check the UnitedStates field
            WebElement UnitedStates = driver.findElement(By.name("country"));
            Select s2 = new Select(UnitedStates);
            s2.selectByValue("Canada");
            
            // Check the UnitedStates field
            WebElement Quantity = driver.findElement(By.name("quantity"));
            Select s3 = new Select(Quantity);
            s3.selectByValue("200 +");  

            // Check the date field
            WebElement date = driver.findElement(By.name("inHandDate"));
            date.sendKeys("2024-12-16");
          
            // Check the style of intrest field
            WebElement intrest = driver.findElement(By.xpath("//input[@id=\"Polos\"]"));
            intrest.click();
          
          //Check the message field
           WebElement msg = driver.findElement(By.name("comment"));
           msg.sendKeys("yyyyyyyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzzzzxxxxxxxxxxxxxxxxxxxxxxxxxxx888888888888887777777777777 yyyyyyyyyyyyy ffffffffffffffffffffffffffffffffffffffff uuuuuuuuuuuuuuuuuuuu");
    
           // Check the submit button
           WebElement submit2 = driver.findElement(By.name("SUBMIT"));
           submit2.click();
        }
    
    
     //++++++++++++++++++++++++++++
     
           
    
    // 4. Test Case: Verify all fields with Invalid Credentials
    @Test
    public void Verify_with_Invalid_Credentials() 
    {
    	
            // Check the First Name field
            WebElement firstName = driver.findElement(By.name("firstName"));;
            firstName.sendKeys("4578 #$^& 555   hhhh");
            Assert.assertTrue(firstName.isDisplayed(), "Enter your First Name.");        

            // Check the Last Name field
            WebElement lastName = driver.findElement(By.name("lastName"));
            lastName.sendKeys("9986  00");
            Assert.assertTrue(lastName.isDisplayed(), "Enter your Last Name.");

            // Check the Company field
            WebElement company = driver.findElement(By.name("companyName"));
            company.sendKeys("4578 #$^&h");
            Assert.assertTrue(company.isDisplayed(), "Enter Company name.");

            // Check the Are You An ASI Distributor
            WebElement Distributor = driver.findElement(By.xpath("//label[text()=\"Are You An ASI Distributor?*\"]"));
            WebElement YES = driver.findElement(By.name("asiDistributor"));
            YES.click();
            Assert.assertTrue(Distributor.isDisplayed(), "Please select an option.");
            
            // Check the Email field
            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("457");
            Assert.assertTrue(email.isDisplayed(), "Enter your Email Address..");

            // Check the WebSite field
            WebElement Website = driver.findElement(By.name("website"));
            Website.sendKeys("SDFSADFASDVSDV4578 #$^& 555   hhhh");
            Assert.assertTrue(Website.isDisplayed(), "Enter a Website");
            
           // Check the Password field
            WebElement Password = driver.findElement(By.name("password"));
            Password.sendKeys("                   WEEEEE     DDDDDDD4578 #$^& 555   hhhh");
            Assert.assertTrue(Password.isDisplayed(), "Password is required");
         
            // Check the Confirm Password field
            WebElement CNFPassword = driver.findElement(By.name("confirmPassword"));
            CNFPassword.sendKeys("                   WEEEEE     DDDDDDD4578 #$^& 555   hhhh");
            Assert.assertTrue(CNFPassword.isDisplayed(), "Confirm Password is required 	.");
            
            // Check the Shipping address field
            WebElement Shipping = driver.findElement(By.name("address1"));
            Shipping.sendKeys("ASGT34CCV SXC3456784578 #$^& 555   hhhh");
            Assert.assertTrue(Shipping.isDisplayed(), "Shipping address is required.");
            
           // Check the Shipping address field
            WebElement Shipping2 = driver.findElement(By.name("address2"));
            Shipping2.sendKeys("DGFEGSDFBV VEGRVSF4578 #$^& 555   hhhh");
            Assert.assertTrue(Shipping2.isDisplayed(), "Shipping address is required.");
            
            // Check the Phone field
            WebElement phone = driver.findElement(By.name("phone"));
            phone.sendKeys("SSSSSSSSSSSSSSSSSSSSSSSSSSF4578 #$^& 555   hhhh");
            Assert.assertTrue(phone.isDisplayed(), "Enter your Phone Number..");

            // Check the Phone field
            WebElement zipcode = driver.findElement(By.name("zipcode"));
            zipcode.sendKeys("ASADFWARG4578 #$^& 555   hhhh");
            Assert.assertTrue(zipcode.isDisplayed(), "Enter your Postal Code.");

            // Check the city field
            WebElement city = driver.findElement(By.name("city"));
            city.sendKeys("WGGWT4578 SDGG#$^& 555   hhhh");
            Assert.assertTrue(city.isDisplayed(), "City is Required.");

            // Check the purpose of order field
            WebElement purpose = driver.findElement(By.name("purpose"));
            purpose.sendKeys("457SFFGG DFG8 #$^& 555   hhhh");
            Assert.assertTrue(purpose.isDisplayed(), "Purpose is required");
            
            // Check the state field
            WebElement state = driver.findElement(By.name("state"));
            Assert.assertTrue(state.isDisplayed(), "Enter your State");
            
            // Check the UnitedStates field
            WebElement UnitedStates = driver.findElement(By.name("country"));
            Assert.assertTrue(UnitedStates.isDisplayed(), "Purpose is required");

             // Check the Quantity field
            WebElement Quantity = driver.findElement(By.name("quantity"));
            Assert.assertTrue(Quantity.isDisplayed(), "Quantity is required");

            // Check the date field
            WebElement date = driver.findElement(By.name("inHandDate"));
            date.sendKeys("2016/87/96");
            Assert.assertTrue(date.isDisplayed(), "In hands Date is required");
          
            // Check the style of intrest field
            WebElement intrest = driver.findElement(By.xpath("//input[@id=\"Polos\"]"));
            intrest.click();
            
           //Check the message field
           WebElement message = driver.findElement(By.name("comment"));
           message.sendKeys("4578 #$^& 555 4444444566k   78dfccjadc7hxbvhkhsdduvhsduADF");
           Assert.assertTrue(message.isDisplayed(), "Message is a required");
    
            // Check the submit button
            WebElement submit3 = driver.findElement(By.name("SUBMIT"));
            submit3.click();
     }
      
    
}

       


