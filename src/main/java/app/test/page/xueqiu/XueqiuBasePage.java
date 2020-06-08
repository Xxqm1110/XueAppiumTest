package app.test.page.xueqiu;

import app.test.page.common.CommonBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XueqiuBasePage extends CommonBasePage {
    public  XueqiuBasePage(){
        super();

    }
    public  XueqiuBasePage(AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }
    public  XueqiuBasePage( String appPackge, String lauchActivity){
        super(appPackge,lauchActivity);
    }
}
