package app.test.page.wework;

import app.test.page.common.AppClicker;
import app.test.viewer.wework.ScheduleView;
import app.test.viewer.wework.TODOView;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class TODOPage extends WeWorkBasePage{
    public TODOPage(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public TODOPage addTODO(String content){
        AppClicker.clickById(TODOView.ADD_BUTTON_ID,wait);
        AppClicker.inputTextById(TODOView.INPUT_TOTO_ID,content,wait);
        AppClicker.clickById(TODOView.SAVE_BUTTON_ID,wait);
        return  this;
    }
    public List<String> getTODOList(){
        return driver.findElements(AppClicker.byId(TODOView.TODO_NAME_ID)).stream().map(x->x.getText()).collect(Collectors.toList());
    }
    public void tearsDown(){
        driver.quit();
    }
}
