import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
class testPopup {
	public static void main(String[] args)
	{
	WebDriver driver = new ChromeDriver();
	driver.get("http://10.0.1.86//tatoc");
	
	String mainWindow = driver.getWindowHandle();	
		
	driver.findElement(By.linkText("Basic Course")).click();
	driver.findElement(By.className("greenbox")).click();
	
	
	driver.switchTo().frame(0);
	String box1 = driver.findElement(By.id("answer")).getAttribute("class");
	
	while(true){
	driver.findElement(By.cssSelector("a")).click();
	driver.switchTo().frame("child");
	String box2 = driver.findElement(By.id("answer")).getAttribute("class");
	driver.switchTo().parentFrame();
	if(box1.equals(box2))
	{
	driver.findElements(By.cssSelector("a")).get(1).click();
	break;
	}
	}
	
		
	WebElement element = driver.findElement(By.id("dragbox")); 

	WebElement target = driver.findElement(By.id("dropbox"));

	(new Actions(driver)).dragAndDrop(element, target).perform();
	driver.findElement(By.cssSelector("a")).click();
	
	driver.findElement(By.linkText("Launch Popup Window")).click();
	String winHandleBefore = driver.getWindowHandle();
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	
	driver.findElement(By.id("name")).sendKeys("M");
    driver.findElement(By.id("submit")).click();
    
    
    
    driver.switchTo().window(mainWindow);
    driver.findElements(By.cssSelector("a")).get(1).click();
    driver.findElement(By.cssSelector("a")).click();
    String Tokenvalue = driver.findElement(By.id("token")).getText();
     Tokenvalue = (Tokenvalue.substring(7));
     System.out.println(Tokenvalue);
    
    
    Cookie ck = new Cookie("Token", Tokenvalue);
    driver.manage().addCookie(ck);
    
	
    
     
    driver.findElements(By.cssSelector("a")).get(1).click(); 
	
	}

	}
