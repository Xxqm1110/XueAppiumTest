package app.test.page.xueqiu;

import app.test.page.common.AppClicker;
import app.test.page.common.CommonBasePage;
import app.test.viewer.xueqiu.SearchPageView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends CommonBasePage {

    public SearchPage(AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }
    public SearchPage search(String keword){
        AppClicker.inputTextAndCheckId(driver,SearchPageView.SEARH_INPUT_ID,keword,SearchPageView.SEARCHLIST_STOCK_NAME_ID);
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
        AppClicker.clickByIndextid("name",wait,0);
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }

    public SearchPage addStock(String keyword){
        //输入搜索值
        AppClicker.inputTextById(SearchPageView.SEARH_INPUT_ID,keyword,wait);
        //点击搜索内容的第一条
        AppClicker.clickByIndextid(SearchPageView.SEARCHLIST_STOCK_NAME_ID,wait,0);
        //点关注
        AppClicker.clickByIndextid(SearchPageView.FOLLOW_BUTTON_ID,wait,0);
        //等待弹框并点掉
//        AppClicker.clickById(CommonView.DIALOG_LEFT_ID,wait);
        //清除选项
//        AppClicker.clickById(SearchPageView.CLEAR_INPUT_ID,wait);
        // 取消搜索
        AppClicker.clickById(SearchPageView.EXIT_SEARCH_BUTTON_ID,wait);

        return  this;

    }
    public void tearsDown(){
        super.tearsDown();
    }
}
