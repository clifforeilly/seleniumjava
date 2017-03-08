

/**
 * Created by co17 on 07/03/2017.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.interactions.Actions;

public class MyWebDriver {

    org.openqa.selenium.WebDriver driver;

    public MyWebDriver(String browser)
    {
        try {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", seleniumjava.getFolder() + "\\chromedriver.exe");
                driver = new ChromeDriver();
            }

            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", seleniumjava.getFolder() + "\\geckodriver.exe");
                driver = new MarionetteDriver();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public WebElement findMyElement(String type, String Identifier){

        WebElement e = null;

        if(type.equals("xpath")){
            e = driver.findElement(By.xpath(Identifier));
        }
        else if(type.equals("linktext")){
            e = driver.findElement(By.linkText(Identifier));
        }
        return e;
    }

    public void myClose()
    {
        driver.quit();
    }

    public boolean myAssert(String type, String Identifier, String Value, String type2){

        boolean output = false;
        try {
            WebElement e = findMyElement(type, Identifier);

            if(type2.equals("isDisplayed")){
                if(e.isDisplayed()){
                    output = true;
                    System.out.println("Test case asserted successfully");
                }
            }
            else if(type2.equals("isNotDisplayed")){
                if(e.isDisplayed()){
                    output = false;
                    System.out.println("Test case failed");
                }
            }
            else{
                if(type2.equals("textIs")){
                    if(e.getText().equals(Value)){
                        output = true;
                        System.out.println("Test case asserted successfully");
                    }
                    else
                    {
                        System.out.println("Test case failed");
                    }
                }
                else if(type2.equals("textIsNot")){
                    if(e.getText().equals(Value)){
                        output = true;
                        System.out.println("Test case asserted successfully");
                    }
                    else
                    {
                        System.out.println("Test case failed");
                    }
                }
            }
        }
        catch(NoSuchElementException ex){
            if(type2.equals("isNotDisplayed")){
                System.out.println("Assertion succeeds - element is not displayed");
            }
            else{
                System.out.println("Assertion fails - element does not exist");
            }
        }
        return output;
    }

    public void doAction(String action, String type, String Identifier, String Value, String type2){

        try {

            if(action.equals("navigate")){
                driver.get(Value);
            }

            if(action.equals("sendkeys")){
                WebElement e = findMyElement(type, Identifier);

                if(Value.contains("{{RETURN}}"))
                {
                    e.sendKeys(Keys.RETURN);
                }
                else {
                    e.sendKeys(Value);
                }
            }

            if(action.equals("movetoandclick")){
                WebElement e = findMyElement(type, Identifier);
                Actions a = new Actions(driver);
                a.moveToElement(e).build().perform();
                WebElement e2 = findMyElement(type, Value);
                a.click(e2).build().perform();
            }

            if(action.equals("doubleclickandsendkeys")){
                WebElement e = findMyElement(type, Identifier);
                Actions a = new Actions(driver);
                a.moveToElement(e).doubleClick().sendKeys(Value).sendKeys(Keys.RETURN).build().perform();
            }

            if(action.equals("click")){
                WebElement e = findMyElement(type, Identifier);
                e.click();
            }

            if(action.equals("assert")){
                myAssert(type, Identifier, Value, type2);
            }

            Thread.sleep(1000);

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}