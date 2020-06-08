package app.test.page.xueqiu;

import app.test.page.common.AppClicker;
import app.test.page.common.CommonBasePage;
import app.test.viewer.xueqiu.CommonView;
import app.test.viewer.xueqiu.SearchPageView;
import app.test.viewer.xueqiu.StockListPageView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DetailsPage  extends XueqiuBasePage {

    public DetailsPage(AppiumDriver<MobileElement> driver,WebDriverWait wait){
        super(driver,wait);
    }
    public DetailsPage ClearStocks(){
        //判断列表是否为空
        if (getStocksList().size()>0){
            //点击列表管理菜单
            AppClicker.clickById(StockListPageView.EDIDT_BUTTON_ID,wait);
            //点击全选
            AppClicker.clickById(StockListPageView.CHECK_ALL_BUTTON_ID,wait);
            //点击取消关注
            AppClicker.clickById(StockListPageView.CANCEL_FOLLOW_BUTTON_ID,wait);
            //点击确定取消关注
            AppClicker.clickById(CommonView.DIALOG_RIGHT_ID,wait);
            //等待优化
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //点击退出列表管理菜单
            AppClicker.clickById(StockListPageView.EXIT_EDIT_BUTTON_ID,wait);
        }
        return  this;
    }

    public DetailsPage addStock(String keyword){
        AppClicker.clickById(SearchPageView.SEARCH_BUTTON_ID,wait);
        SearchPage searchPage = new SearchPage(driver,wait);
        searchPage.addStock(keyword);
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
