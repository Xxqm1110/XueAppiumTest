package app.test.page.xueqiu;

import app.test.page.common.AppClicker;
import app.test.page.common.CommonBasePage;
import app.test.viewer.xueqiu.MainPageView;
import org.openqa.selenium.By;

public class MainPage extends XueqiuBasePage {
    public MainPage() {
        super("com.xueqiu.android",".view.WelcomeActivityAlias");
    }
    public SearchPage toSearch() {
        AppClicker.clickById(MainPageView.SEARCH_BUTTON_ID,wait);
        return new SearchPage(driver,wait);
    }

    public DetailsPage toDetailPage(){
        AppClicker.clickByIndextid(MainPageView.TAB_ITEM_ID,wait,1);
        return  new DetailsPage(driver,wait);

    }


}
