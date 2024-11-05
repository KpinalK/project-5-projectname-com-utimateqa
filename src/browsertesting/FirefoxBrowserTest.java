package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Set up Firefox browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Click on the ‘Sign In’ link
 * 7. Print the current URL
 * 8. Enter the email in the email field.
 * 9. Enter the password in the password field.
 * 10. Click on the Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to the Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class FirefoxBrowserTest {

    public static void main(String[] args) {
        String baseUrl = "https://courses.ultimateqa.com/";
        //1.Set up Firefox browser
        WebDriver driver = new FirefoxDriver();

        //2.Open URL
        driver.get(baseUrl);
        //Maximise the browser window
        driver.manage().window().maximize();
        //We give implicit time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3.Print the title of the page
        System.out.println(driver.getTitle());

        //4.Print the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The Current URL " + currentUrl);

        //5.Print the page source
        System.out.println("The page source : " + driver.getPageSource());

        //6.Click on the 'Sign In' link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();

        //7.Print the current URL
        System.out.println("The Current URL " + driver.getCurrentUrl());

        //8.Enter the email in the email field
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("Pinal@gmail.com");

        //9.Enter the password in the password field
        WebElement password = driver.findElement(By.name("user[password]"));
        password.sendKeys("12345");

        //10.Click on the Login Button
        WebElement loginButton = driver.findElement(By.className("g-recaptcha"));
        loginButton.click();

        //11.Navigate to baseUrl
        driver.navigate().to(baseUrl);

        //12.Navigate forward to the Homepage
        driver.navigate().forward();
        System.out.println("The Current URL " + driver.getCurrentUrl());

        //13.Navigate back to baseUrl
        driver.navigate().back();

        //14.Refresh the page
        driver.navigate().refresh();

        //15.Close the browser
        driver.quit();

    }
}
