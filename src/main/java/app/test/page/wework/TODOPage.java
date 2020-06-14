package app.test.page.wework;

import app.test.page.common.AppClicker;
import app.test.viewer.wework.ScheduleView;
import app.test.viewer.wework.TODOView;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TODOPage extends WeWorkBasePage{
    public TODOPage(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * 添加待办
     * @param content 待办内容
     * @return
     */
    public TODOPage addTODO(String content){
        AppClicker.clickById(TODOView.ADD_BUTTON_ID,wait);
        AppClicker.inputTextById(TODOView.INPUT_TOTO_ID,content,wait);
        AppClicker.clickById(TODOView.SAVE_BUTTON_ID,wait);
        return  this;
    }

    /**
     * 设置已办
     * @param content 待办内容
     * @return
     */
    public TODOPage setDone(String content){
        List<String> todoList = getTODOList();
        for (int i=0;i<todoList.size();i++){
            if(todoList.get(i).equals(content)){
                AppClicker.clickByIndextid(TODOView.TODO_CHECKBOX_ID,wait,i);
            }
        }
        return  this;
    }
    public List<String> getTODOList(){
        //界面显示太快
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        if(driver.findElement(AppClicker.byId(TODOView.TODO_NAME_ID))!=null)
            return driver.findElements(AppClicker.byId(TODOView.TODO_NAME_ID)).stream().map(x->x.getText()).collect(Collectors.toList());
        else{
            return  new ArrayList<String>();
        }
    }
    public void tearsDown(){
        driver.quit();
    }
}
