import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeftMenuTest {
    WebDriver wd;
    WebDriverWait wait;

   @BeforeMethod
    public void setUp() throws InterruptedException {
       wd = new ChromeDriver();
       wait = new WebDriverWait(wd, 3000);
       openSite("http://localhost/litecart/admin");
       logIn("admin", "admin");
   }



    private void logIn(String userName, String password) throws InterruptedException {
       wd.findElement(By.name("username")).sendKeys(userName);
        wd.findElement(By.name("password")).sendKeys(password);

       Thread.sleep(2000);//WebElement loginForm = wd.findElement(By.cssSelector("#box-login-wrapper div#box-login"));

    }

    private void openSite(String url) {
       wd.navigate().to(url);
    }

    @Test
    public void testLeftMenu() throws InterruptedException {
        wd.findElement(By.xpath("//button[@name='login']")).click();
        Thread.sleep(2000);
        WebElement leftSideMenu = wd.findElement(By.cssSelector("ul.list-vertical"));
        WebElement menu = leftSideMenu.findElement(By.cssSelector("li"));
        List<WebElement> items = leftSideMenu.findElements(By.cssSelector("li"));
        for (WebElement item : items){
            String title = item.getText();//
                    // leftSideMenu.findElement(By.cssSelector("li span.name")).getText();
//items.add(item);
            System.out.println(title);
            item.click();
            List <WebElement> subMenus = menu.findElements(By.tagName("li"));
            for(WebElement subMenu : subMenus){
                subMenu.click();
                String titleIs = wd.findElement(By.tagName("h1")).getText();
                System.out.println(" title is" + titleIs);
                Assert.assertTrue(isElementPresent(By.tagName("h1")));
            }

        }
    }

    private boolean isElementPresent(By locator) {
       return wd.findElements(locator).size() > 0;
    }

    @AfterMethod
        public void stop(){
            wd.quit();

   }
}
