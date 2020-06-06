package appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    private AndroidDriver driver;
    public SearchPage(){
    }

    public SearchPage(AndroidDriver driver){
        this.driver =driver;
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
        return nameList;
    }

    public double getPrice(){
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
        el3.click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }
    public SearchPage addStock(String keyword){
        MobileElement el7 = (MobileElement) driver.findElementById("com.xueqiu.android:id/action_search");
        el7.click();
//        for(String keyword : keywords){
        MobileElement el8 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el8.sendKeys(keyword);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.TextView");
        el10.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement el11 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_left");
        if (el11!=null){
            el11.click();
        }driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        MobileElement el12 = (MobileElement) driver.findElementById("com.xueqiu.android:id/action_delete_text");
        el12.click();

//        }
        MobileElement el13 = (MobileElement) driver.findElementById("com.xueqiu.android:id/action_close");
        el13.click();
        return  this;

    }
}
