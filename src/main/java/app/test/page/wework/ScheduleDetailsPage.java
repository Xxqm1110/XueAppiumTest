package app.test.page.wework;

import app.test.page.common.AppClicker;
import app.test.viewer.wework.ScheduleDetailsView;
import app.test.viewer.wework.ScheduleView;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleDetailsPage extends WeWorkBasePage {

    public ScheduleDetailsPage(AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    public ScheduleDetailsPage deleteSchedule(){
        AppClicker.click(AppClicker.byId(ScheduleDetailsView.DELETE_BUTTON_ID4),wait);
        AppClicker.click(AppClicker.byId(ScheduleDetailsView.DIALOG_CONFIRM_BUTTON_ID),wait);
        return this;
    }
    public void goBack(){
        AppClicker.click(AppClicker.byId(ScheduleDetailsView.BACK_BUTTON_ID),wait);
    }

}
