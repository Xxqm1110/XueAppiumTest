package appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public BasePage()  {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("platformVersion", "6.0.1");
        desiredCapabilities.setCapability("noReset", "true");
//        desiredCapabilities.setCapability("skipLogcatCapture", "true");
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
    protected   void  tearsDown(){
        driver.quit();
    }
    protected void click(By by){
        driver.findElement(by).click();
    }
    protected void find(By by){
        driver.findElement(by);
    }
    protected void clickByIndex(By by,int index){
        driver.findElements(by).get(index).click();
    }
//    protected  void waitElement(){
//        long start=System.currentTimeMillis();
//        new WebDriverWait(driver, 40)
//                .until(x ->{
//                    String xml=driver.getPageSource();
//                    Boolean exist=xml.contains("home_search") || xml.contains("image_cancel") ;
//                    System.out.println((System.currentTimeMillis() - start)/1000);
//                    System.out.println(exist);
//                    return exist;
//                });
//        new WebDriverWait(driver,40).until(x->{
//            String xml = driver.getPage
//
//        });
//
//    }
}
