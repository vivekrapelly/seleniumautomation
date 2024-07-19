import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\chrome web driver\chrome-win64\chrome-win64\chrome.exe");

        // Initializing WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            //  URL
            driver.get("https://juice-shop.herokuapp.com/#/login");

            // Locating username and password fields
            WebElement usernameField = driver.findElement(By.id("username")); // Use appropriate locator
            WebElement passwordField = driver.findElement(By.id("password")); // Use appropriate locator

            // Enter the username and password
            String Username = "vivek";
            String Password = "898568"

            usernameField.sendKeys(Username);
            passwordField.sendKeys(Password);

            passwordField.submit();

           
           
            // Check for error messages
            if (driver.getPageSource().contains("Invalid username or password")) {
                System.out.println("Login failed: Invalid username or password");
            } else if (driver.getPageSource().contains("SQL error")) {
                System.out.println("Login failed: SQL error detected");
            } else {
                System.out.println("Login response received without common error messages");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
