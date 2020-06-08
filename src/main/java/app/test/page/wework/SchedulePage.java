package app.test.page.wework;

import app.test.page.common.AppClicker;
import app.test.viewer.wework.ScheduleView;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulePage extends WeWorkBasePage {

    public SchedulePage(AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }
    public SchedulePage 添加(String name , String time){
        AppClicker.clickById(ScheduleView.ADD_BUTTON_ID,wait);
        AppClicker.inputTextById(ScheduleView.TITLE_INPUTTEXT_ID,name,wait);
        AppClicker.clickById(ScheduleView.SAVE_BUTTON_ID10,wait);
        return  this;
    }

    public List<Object> 获取日程列表(String day){
        if (day!=null){
            AppClicker.clickByContentDesc(day,wait);
        }
        return driver.findElements(AppClicker.byId(ScheduleView.SCHEDULE_NAME_ID)).stream().map(x->x.getText()).collect(Collectors.toList());
    }
    public void tearsDown(){
        driver.quit();

    }
}
