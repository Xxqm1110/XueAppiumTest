package app.test.page.wework;

import app.test.page.common.CommonBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class 日程Page extends WeWorkBasePage {
    private final String  taskName_id = "b2k";
    private final String save_text = "保存";
    private final  String taskList_id = "gg_";
    private final String  add_id ="gym";

    public 日程Page (AppiumDriver driver, WebDriverWait wait){
        super(driver,wait);
    }
    public 日程Page  添加(String name , String time){
//        click(add);
//        sendKeys(taskName, name);
//        click(save);
//        clickById(add_id);
//        sendKeys
        return  this;
    }

    public List<Object> 获取日程列表(){
        return new ArrayList<Object>();
    }
}
