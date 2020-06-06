package app.test.page.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonBasePage {
    protected AppiumDriver<MobileElement> driver;
    public CommonBasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public CommonBasePage(){

    }
    public CommonBasePage(String appPackage, String LauchActivity)  {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", LauchActivity);
        desiredCapabilities.setCapability("platformVersion", "6.0.1");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("skipLogcatCapture", "true");
//        desiredCapabilities.setCapability("skipDeviceInitialization", "true");
//        desiredCapabilities.setCapability("skipServerInstallation", "true");

        try {
            URL remoteUrl  = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    protected void  tearsDown(){
        driver.quit();
    }
    protected void click(By by){
        driver.findElement(by).click();
    }
    protected void find(By by){
        driver.findElement(by);
    }
    public By byText(String text){
        return By.xpath("//*[@text='"+ text + "']");
    }
    protected  void clickByText(String text){
        driver.findElement(byText(text)).click();
    }
    protected  void clickById(String id){
        driver.findElement(byId(id)).click();
    }
    public By byId(String id){
        return By.xpath("//*[@id='"+ id+ "']");
    }
    protected void clickByIndex(By by,int index){
        driver.findElements(by).get(index).click();
    }
    protected  void waitElement(String name,int waitTime){
        long start=System.currentTimeMillis();
        new WebDriverWait(driver,waitTime).until(x->{
            String xml = driver.getPageSource();
            Boolean exist =xml.contains(name);
            System.out.println(exist);
            return  exist;

        });

    }
}
