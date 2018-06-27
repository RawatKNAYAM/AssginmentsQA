package TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class testingtat {

WebDriver web;
//		public testingtat() 
//	{
//		
//		this.web = new ChromeDriver();
//        web.get("https://hris.qainfotech.com/login.php");
//	}
//	
//	@Test 
//	public void user_Name()
//	{
//	web.findElement(By.id("txtUserName")).sendKeys("mayankrawat");
//	web.findElement(By.id("txtPassword")).sendKeys("lalsjdajv");
//	//web.findElement(By.name("Submit")).click();//Assert.assertEquals(actual, expected);
//	//web.findElement(By.cssSelector(".btn pull-left")).click();	
//	web.findElement(By.cssSelector("input[name=Submit]")).click();
//	String Exurl = ("https://hris.qainfotech.com:8086/employee/profile?gid=3674");
//	String login_error_made = web.findElement(By.className("loginTxt txtHideDiv alert alert-error")).getText();
//	Assert.assertEquals(Exurl,web.getCurrentUrl(),login_error_made);
//	
//	System.out.println(login_error_made);
//	}
	
	public testingtat() 
	{
		Paths.get(System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "chromedriver.exe");
		web = new ChromeDriver();
        web.get("http://10.0.1.86/tatoc");
	}
	
	@Test 
	public void first_page_test()
	{	
		web.findElement(By.linkText("Basic Course")).click();
		String expectedurl = ("http://10.0.1.86/tatoc/basic/grid/gate");
		Assert.assertEquals(expectedurl, web.getCurrentUrl(), "Error Occur....Unable to load new page");
	}



		@Test (dependsOnMethods = "first_page_test")
		public void green_Box_Testing()
		{
		  web.findElement(By.className("greenbox")).click();
		  String expected_url_of_this_test_afterclick =("http://10.0.1.86/tatoc/basic/frame/dungeon"); 
		  Assert.assertEquals(expected_url_of_this_test_afterclick, web.getCurrentUrl(), "Navigation Error Occur");
		}

		@Test (dependsOnMethods = "green_Box_Testing")
	    public void frameDungeon() {

	        web.switchTo().frame("main");
	        String box1 = web.findElement(By.id("answer")).getAttribute("class");
	        int n=0;
	        while (n==0)
	        
	        {

	            web.findElement(By.cssSelector("a")).click();
	            web.switchTo().frame("child"); 
	            String box2 = web.findElement(By.id("answer")).getAttribute("class");
	            web.switchTo().parentFrame();
	            if (box1.equals(box2)) {
	                web.findElements(By.cssSelector("a")).get(1).click();
	                n=1;
	            }
	        }

	        String expectedUrl = "http://10.0.1.86/tatoc/basic/drag";
	        Assert.assertEquals(expectedUrl, web.getCurrentUrl(), "Didn't navigate to correct webpage");
	       
		}

	@Test (dependsOnMethods= "frameDungeon")
	public void Dragdropbox()
	{
		Actions act = new Actions(web);
		WebElement drag= web.findElement(By.id("dragbox"));
		WebElement drop = web.findElement(By.id("dropbox"));
		act.dragAndDrop(drag, drop).build().perform();
		web.findElement(By.linkText("Proceed")).click();
		 String expectedUrl = "http://10.0.1.86/tatoc/basic/windows";
	        Assert.assertEquals(expectedUrl, web.getCurrentUrl(), "Didn't navigate to correct webpage");
	}
	@Test (dependsOnMethods= "Dragdropbox")
	public void Launchpopup()
	{
		web.findElement(By.linkText("Launch Popup Window")).click();
		ArrayList<String> windowsList=new ArrayList(web.getWindowHandles());
        String windows1=  (windowsList.get(1));
        web.switchTo().window(windows1);
        web.findElement(By.id("name")).sendKeys("M");
        web.findElement(By.id("submit")).click();
        String windows2=(windowsList.get(0));
        web.switchTo().window(windows2);
        web.findElement(By.linkText("Proceed")).click();
        String expectedUrl = "http://10.0.1.86/tatoc/basic/cookie";
        Assert.assertEquals(expectedUrl, web.getCurrentUrl(), "Didn't navigate to correct webpage");

	}
	@Test (dependsOnMethods = "Launchpopup")
	public void Createcookie()
	{
		web.findElement(By.linkText("Generate Token")).click(); 
        String Token = web.findElement(By.id("token")).getText();
        String substring1=Token.substring(7);
        Cookie name = new Cookie("Token", substring1);
		  web.manage().addCookie(name);
		  web.findElement(By.linkText("Proceed")).click(); 
		  String expectedUrl = "http://10.0.1.86/tatoc/end";
	        Assert.assertEquals(expectedUrl, web.getCurrentUrl(), "Didn't navigate to correct webpage");
 
	}

}