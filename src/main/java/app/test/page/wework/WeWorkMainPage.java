package app.test.page.wework;

import app.test.page.common.CommonBasePage;

public class WeWorkMainPage extends WeWorkBasePage {
    public WeWorkMainPage() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }
    public 日程Page to日程(){
        return  new 日程Page(driver,wait);
    }
}
