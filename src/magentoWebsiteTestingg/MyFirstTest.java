package magentoWebsiteTestingg;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


import dev.failsafe.internal.util.Durations;

public class MyFirstTest {
	WebDriver driver=new ChromeDriver();

	String myWebsite="https://magento.softwaretestingboard.com/";
	String logoutPage="https://magento.softwaretestingboard.com/customer/account/logout/";
	Random rand=new Random();
	String password="Ilovemymom123#";
	String emailToLogin="";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(myWebsite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@Test (priority =1 , enabled=false)
	public void createAnaccount() {
		//WebElement createAccountPage=driver.findElement(By.linkText("Create an Account"));
		WebElement createAccountPage=driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		createAccountPage.click();
		String [] First_Name={"John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Laura", "David", "Sophie"};
		String [] Last_Name={"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};
		
		
int randomindexFortheFirstName=rand.nextInt(First_Name.length);
int randomindexFortheLastName=rand.nextInt(Last_Name.length);

System.out.println(randomindexFortheFirstName);
System.out.println(randomindexFortheLastName);
int randomnumber=rand.nextInt(9876);

String firstname=First_Name[randomindexFortheFirstName];
String lastname=Last_Name[randomindexFortheLastName];
String emaildomain="@gmail.com";

WebElement FirstNameInput=driver.findElement(By.id("firstname"));

FirstNameInput.sendKeys(firstname);
WebElement LastNameInput=driver.findElement(By.id("lastname"));
LastNameInput.sendKeys(lastname);
WebElement EmailInput=driver.findElement(By.id("email_address"));
EmailInput.sendKeys(firstname + lastname +   randomnumber   +emaildomain);
WebElement PasswordInput=driver.findElement(By.id("password"));
PasswordInput.sendKeys(password);
WebElement PasswordConfirmation=driver.findElement(By.id("password-confirmation"));
PasswordConfirmation.sendKeys(password);
emailToLogin=firstname +lastname +randomnumber + emaildomain;

WebElement CreateAnAccountButton=driver.findElement(By.xpath("//button[@title='Create an Account']"));
CreateAnAccountButton.click();


WebElement MessageWebElement=driver.findElement(By.className("messages"));
String ActualMessage= MessageWebElement.getText();
String ExpectedMessage="Thank you for registering with Main Website Store.";
Assert.assertEquals(ActualMessage, ExpectedMessage);
if (ActualMessage==ExpectedMessage) {
	System.out.println("passed");
} else {
	System.out.println("failed");
	}

	}

	@Test (priority =2 ,enabled=false )
	public void LogoutTest()	{
		driver.get(logoutPage);
		WebElement LogoutMessage=driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
		String ActualMessage=LogoutMessage.getText();
		String ExpectedMessage="You are signed out";
		Assert.assertEquals(ActualMessage,ExpectedMessage);
		if (ActualMessage==ExpectedMessage) {
			System.out.println("passed");
		}
		else {
			System.out.println("failed");
		}
	}
	@Test (priority=3 , enabled=false )
	public void LoginTest() {
		WebElement LoginPage=driver.findElement(By.linkText("Sign In"));
		LoginPage.click();
		WebElement EmailLoginInput=driver.findElement(By.id("email"));
		WebElement passwordInput=driver.findElement(By.id("pass"));
		WebElement SignInButton=driver.findElement(By.cssSelector(".action.login.primary"));
		EmailLoginInput.sendKeys(emailToLogin);
		passwordInput.sendKeys(password);
		SignInButton.click();
		
		
		
		String WelcomeMessage= driver.findElement(By.className("logged-in")).getText();
		boolean ActualValue=WelcomeMessage.contains("Welcome");
		boolean ExpectedValue=true;
		Assert.assertEquals(ActualValue, ExpectedValue);
	} 
	@Test( priority=4 ,enabled=false)
	public void addMenitem() {
	WebElement MenSection=driver.findElement(By.id("ui-id-5"));
	MenSection.click();
	
	
	WebElement ProductItemsContainer=driver.findElement(By.className("product-items"));
	List <WebElement> AllItems=ProductItemsContainer.findElements(By.tagName("li"));
	int TotalNumberofItems=AllItems.size();
	int randomItem=rand.nextInt(TotalNumberofItems);
	AllItems.get(randomItem).click();
	
	
	WebElement SizesContainer=driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
	List <WebElement> AllSizes=SizesContainer.findElements(By.className("swatch-option"));
	int TotalNumberofallSizs=AllSizes.size();
	int randomSize=rand.nextInt(TotalNumberofallSizs);
	AllSizes.get(randomSize).click();
	
	WebElement ColorsContainer=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
	List <WebElement> AllColors=ColorsContainer.findElements(By.tagName("div"));
	int TotalNumberofAllColors=AllColors.size();
	int randomColor=rand.nextInt(TotalNumberofAllColors);
	AllColors.get(randomColor).click();;
	
	
	WebElement AddToCartButton=driver.findElement(By.id("product-addtocart-button"));
	AddToCartButton.click();
	
	WebElement MassageAdded=driver.findElement(By.className("message-success"));
	System.out.println(MassageAdded.getText().contains("You added"));
	Assert.assertEquals(MassageAdded.getText().contains("You added"), false);
	
	}
	
	@Test (priority=4)
	public void addWomenitem() {
		WebElement WomenSection=driver.findElement(By.id("ui-id-4"));
		WomenSection.click();
		
		WebElement ProductItemsContainer=driver.findElement(By.className("product-items"));
		List <WebElement> AllItems=ProductItemsContainer.findElements(By.tagName("li"));
		int TotalNumberofItems=AllItems.size();
		int randomItem=rand.nextInt(TotalNumberofItems);
		AllItems.get(randomItem).click();
		
		
		WebElement SizesContainer=driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
		List <WebElement> AllSizes=SizesContainer.findElements(By.className("swatch-option"));
		int TotalNumberofallSizs=AllSizes.size();
		int randomSize=rand.nextInt(TotalNumberofallSizs);
		AllSizes.get(randomSize).click();
		
		WebElement ColorsContainer=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List <WebElement> AllColors=ColorsContainer.findElements(By.tagName("div"));
		int TotalNumberofAllColors=AllColors.size();
		int randomColor=rand.nextInt(TotalNumberofAllColors);
		AllColors.get(randomColor).click();;
		
		
		WebElement AddToCartButton=driver.findElement(By.id("product-addtocart-button"));
		AddToCartButton.click();
		
		WebElement MassageAdded=driver.findElement(By.className("message-success"));
		System.out.println(MassageAdded.getText().contains("You added"));
		Assert.assertEquals(MassageAdded.getText().contains("You added"), true);
		
		
		driver.navigate().refresh();
		//ReviewSection
		WebElement ReviewSection =driver.findElement(By.id("tab-label-reviews-title"));
		ReviewSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1200)");
		WebElement RatingStars=driver.findElement(By.cssSelector(".control.review-control-vote"));
		System.out.println(RatingStars.findElements(By.tagName("label")).size()+"***********************");
		String [] ids = {"Rating_1","Rating_2","Rating_3","Rating_4","Rating_5"};
		int randomIndex=rand.nextInt(ids.length);
WebElement element=driver.findElement(By.id(ids[randomIndex]));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		WebElement NickName=driver.findElement(By.id("nickname_field"));
		NickName.sendKeys("mayoosh");
		
		WebElement Summary=driver.findElement(By.id("summary_field"));
		Summary.sendKeys("NA");
		
		WebElement Review=driver.findElement(By.id("review_field"));
		Review.sendKeys("Hello this is test");
		WebElement submitReviewButton=driver.findElement(By.cssSelector(".action.submit.primary"));
		submitReviewButton.click();
		
		String ActualMessagaeForReview=driver.findElement(By.cssSelector(".message-success.success.message")).getText();
		String ExpectedMessageForReview="You submitted your review for moderation.";
		Assert.assertEquals(ActualMessagaeForReview,ExpectedMessageForReview);
		

		
	}
			
		}
		
	
	

