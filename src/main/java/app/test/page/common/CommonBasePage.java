package app.test.page.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonBasePage {
    protected AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    public long timeOutInSecondsDefault=10;
    public CommonBasePage(AppiumDriver<MobileElement> driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait =wait;
    }
    public CommonBasePage(){

    }

    public CommonBasePage(String appPackage, String lauchActivity)  {
        startApp(appPackage,lauchActivity);

    }
    protected void startApp(String appPackage,String LauchActivity){
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
            // 优化等待
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver, timeOutInSecondsDefault);
    }
    protected void  tearsDown(){
        driver.quit();
    }


}
