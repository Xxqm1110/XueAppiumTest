package app.test.page.wework;

import app.test.page.common.CommonBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeWorkBasePage extends CommonBasePage {
    public WeWorkBasePage(){
        super();

    }
    public WeWorkBasePage(AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }
    public WeWorkBasePage(String appPackge, String lauchActivity){
        super(appPackge,lauchActivity);
    }
}
