package appium.pages;

import com.google.common.base.Strings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DetailsPage  extends BasePage{

    public DetailsPage(AppiumDriver driver){
        super(driver);
    }
    public DetailsPage ClearStocks(){
        //判断列表是否为空
        if (getStocksList().size()>0){
            //点击列表管理菜单
            click(By.id("edit_group"));
            //点击全选
            click(By.id("check_all"));
            //点击取消关注
            click(By.id("cancel_follow"));
            //点击确定取消关注
            click(By.id("tv_right"));
            //等待优化
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //点击退出列表管理菜单
            click(By.id("action_close"));
        }
        return  this;
    }

    public DetailsPage goToSearch(){
        click(By.id("action_search"));
        return this;
    }
    public DetailsPage exitSearch(){
        click(By.id("action_close"));
        return  this;
    }
    public DetailsPage addStock(String keyword){

        MobileElement el8 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el8.sendKeys(keyword);
        //选中
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
        el9.click();
        //等待加载
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //点关注
        MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.TextView");
        el10.click();
        //等待弹框并点掉
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        MobileElement el11 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_left");
//        if (el11!=null){
//            el11.click();
//        }
        //清除选项
        MobileElement el12 = (MobileElement) driver.findElementById("com.xueqiu.android:id/action_delete_text");
        el12.click();

        return  this;

    }
    public List<String> getStocksList(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<String>  stocksList = new ArrayList<String>();
        for(Object element  : driver.findElements(By.id("portfolio_stockName"))){
            stocksList.add(((MobileElement)element).getText());
        }
        return  stocksList;
    }
    public  void quit(){
        tearsDown();
    }
}
