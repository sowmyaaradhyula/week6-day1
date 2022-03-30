package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition 
{
	ChromeDriver driver;
	
	@Given("A Chrome Browser is launched")
	public void openChromeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@And("Load the Leaftaps URL {string}")
	public void loadUrl(String url)
	{
		driver.get(url);
	}
	
	@And("Maximize the browser")
	public void maximizeTheBrowser()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Given("Enter the username as {string}")
	public void enterUsername(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@And("Enter the password as {string}")
	public void enterPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	
	@When("The Login button is clicked")
	public void clickLoginButton()
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("Welcome page should be displayed")
	public void verifyLoginPage()
	{
		System.out.println("Login Page is displayed");
	}
	
	@When("Clicked on CRM\\/SFA link")
	public void clicked_On_CRMSFA_Link()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Clicked on Leads")
	public void clickOnLeads()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@And("Clicked on Create Lead")
	public void clickOnCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@And("Enter companyname as {string}")
	public void enterCompanyName (String companyname) 
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}
	
	@And("Enter firstname as {string}")
	public void enterfirstName(String firstname) 
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
	}
	
	@And("Enter lastname as {string}")
	public void enterlastName (String lastname) 
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
	}
	
	@And("Click on Create Lead Button")
	public void clickOnCreateLeadButton()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("View Lead page should be displayed")
	public void View_Lead_page_should_be_displayed()
	{
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("Create lead - Success");
			driver.quit();
		}
	}
	
	@Given("Clicked on Find Leads")
	public void clickOnFindLeads()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@And("Clicked on Phone")
	public void clickOnPhone()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	
	@And("Enter Phone Number as {string}")
	public void enterPhoneNumber(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
	}
	
	@And("Clicked on Find Leads Button")
	public void clickOnFindLeadsButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	
	@And("Click on first result lead")
	public void clickOnFirstResultLead()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@And("Click on Delete")
	public void clickOnDelete()
	{
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@Then("My Lead page should be displayed")
	public void my_Lead_page_should_be_displayed()
	{
		if(driver.getTitle().contains("My Leads"))
		{
			System.out.println("Delete Lead - Success");
			driver.quit();
		}
	}
	
	@And("Click on Edit")
	public void clickOnEdit()
	{
		driver.findElement(By.linkText("Edit")).click();
	}
	
	@And("Update companyname as {string}")
	public void update_Company_Name_as (String updatecompanyname) 
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updatecompanyname);
	}
	
	@And("Click on Update")
	public void clickOnUpdate()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("View Lead page should be displayed after editing the lead")
	public void View_Lead_page_should_be_displayed_after_editing_the_lead()
	{
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("Edit Lead - success");
			driver.quit();
		}
	}
	
	@And("Clicked on Duplicate Lead")
	public void clicked_On_Duplicate_Lead()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	@Then("View Lead page should be displayed after Duplicating the lead")
	public void View_Lead_page_should_be_displayed_after_Duplicating_the_lead()
	{
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("Duplicate Lead - success");
			driver.quit();
		}
	}
	
	@Given("Clicked on Merge Leads")
	public void clickOnMergeLead()
	{
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	
	@And("Clicked on From Lead image")
	public void fromLeadImage()
	{
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}
	
	
	@And("Clicked first resulting lead in From Lead Image {string}")
	public void clicked_first_resulting_lead_in_From_Lead_Image (String fromfirstname) throws InterruptedException
	{
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fromfirstname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
	}
	
	@And("Clicked on To Lead image")
	public void clicked_On_To_Lead_Image()
	{
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
	
	@And("Clicked first resulting lead in To Lead Image {string}")
	public void clicked_first_resulting_lead_in_To_Lead_Image(String tofirstname) throws InterruptedException
	{
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(tofirstname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	}
	
	@When("Click on Merge")
	public void cickOnMerge()
	{
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	
	@Then("View Lead page should be displayed after merging the lead")
	public void View_Lead_page_should_be_displayed_after_merging_the_lead()
	{
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("Merge Lead - success");
			driver.quit();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


