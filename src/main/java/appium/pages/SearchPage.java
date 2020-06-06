package appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage{

    public SearchPage(){
    }

    public SearchPage(AppiumDriver driver){
        super(driver);
    }
    public SearchPage search(String keword){
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys(keword);
        return this;
    }
    public  List<String> getSearchList(){
        List<String> nameList = new ArrayList<String>();
        for(Object element  : driver.findElements(By.id("name"))){
            nameList.add(((MobileElement)element).getText());
        }
//        driver.findElement()
        return nameList;
    }

    public double getPrice(){
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
        el3.click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }

    public void tearsDown(){
        super.tearsDown();
    }
}
