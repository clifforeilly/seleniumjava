

/**
 * Created by co17 on 07/03/2017.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

public class MyWebDriver {

    org.openqa.selenium.WebDriver driver;

    public MyWebDriver(String browser)
    {
        try {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\co17\\LocalStuff\\MyStuff\\Projects\\seleniumjava\\chromedriver.exe");
                driver = new ChromeDriver();
            }

            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\co17\\LocalStuff\\MyStuff\\Projects\\seleniumjava\\geckodriver.exe");
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

            if(Value.equals("isDisplayed")){
                if(e.isDisplayed()){
                    output = true;
                }
            }
            else{
                if(type2.equals("textIs")){
                    if(e.getText().equals(Value)){
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
            System.out.println("Assertion fails - element does not exist");
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

            if(action.equals("click")){
                WebElement e = findMyElement(type, Identifier);
                e.click();
            }

            if(action.equals("assert")){
                myAssert(type, Identifier, Value, type2);
            }

            Thread.sleep(2000);

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}