package app.test.page.wework;

import app.test.page.common.AppClicker;
import app.test.viewer.wework.MainPageView;

public class WeWorkMainPage extends WeWorkBasePage {
    public WeWorkMainPage() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }
    public SchedulePage to日程(){
        AppClicker.clickById(MainPageView.SCHEDULE_ID,wait);
        return  new SchedulePage(driver,wait);
    }
}
