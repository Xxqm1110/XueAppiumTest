package app.test.page.wework;

import app.test.page.common.AppClicker;
import app.test.viewer.wework.Constant;
import app.test.viewer.wework.ScheduleView;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulePage extends WeWorkBasePage {

    public SchedulePage(AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    /**
     * 添加日程
     * @param name 日程名称
     * @param time 日程时间 null 表示当月显示的第一个日期
     * @return
     */
    public SchedulePage 添加(String name , String time){
        chooseDay(time);
        AppClicker.clickById(ScheduleView.ADD_BUTTON_ID,wait);
        AppClicker.inputTextById(ScheduleView.TITLE_INPUTTEXT_ID,name,wait);
        AppClicker.clickById(ScheduleView.SAVE_BUTTON_ID10,wait);
        return  this;
    }

    /**
     * 删除日程
     * @param name 日程名称
     * @param time 日程时间 null 表示当月显示的第一个日期）
     * @param index 日程所在列表位置
     * @return
     */
    public SchedulePage deleteSchedule(String name,String time,int index){
        chooseDay(time);
        AppClicker.clickByText(name,wait);
        ScheduleDetailsPage detailsPage = new ScheduleDetailsPage(driver,wait);
        detailsPage.deleteSchedule();
        return this;
    }

    /**
     * 获取日程列表
     * @param day 日程时间  null 表示当月当天时间
     * @return
     */
    public List<Object> 获取日程列表(String day){
        chooseDay(day);
        return driver.findElements(AppClicker.byId(ScheduleView.SCHEDULE_NAME_ID)).stream().map(x->x.getText()).collect(Collectors.toList());
    }

    /**
     * 选择日程
     * @param day 日程时间  null 表示当月显示的第一个日期
     */
    public void chooseDay(String day){
        if (day!=null){
            AppClicker.clickByText(day,wait);
        }else{
            AppClicker.clickByIndextid(ScheduleView.DATE_DAY_TEXT_ID,wait,0);
        }
    }
    public void tearsDown(){
        driver.quit();

    }
}
