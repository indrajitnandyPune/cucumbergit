package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



//import cucumber.api.java.en.Given;

public class LoginTest {
	public static WebDriver driver;
	PageObjects po;
	@Given("^when i am on home page$")
	public void wheniamonhomepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		po=new PageObjects(driver);
	}
	
	@When("^i enter uname and pwd$")
	public void ienterunameandpwd() {
		po.SignIn.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.login.click();
	}
	
	@Then("^i am able to login$")
	public void iamabletologin() {
		System.out.println("User login successfully");
	}
	
	@When("^Larry searches below products in the search box:$")
	public void larry_searches_below_products_in_the_search_box(DataTable dt) {
		List<String> product=dt.asList(String.class);
		
		for(String s:product ) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//*[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
			driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
			driver.findElement(By.xpath("//a[@href='fetchcat.htm']")).click();
		}
	}
	
	@Then("^product should be added in the cart if available$")
	public void product_should_be_displayed_if_available_in_TestMeApp() {
		System.out.println("Successfully added in the cart");
	}
	
	@When("^user enters \"([^\"]*)\"and\"([^\"]*)\"$")
	public void Loginwithvalidcredentials(String username,String password) {
		po.SignIn.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.login.click();
	}
	
}
