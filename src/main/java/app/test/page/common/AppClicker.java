package app.test.page.common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AppClicker {
    public static void clickById(String id,WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(byId(id))).click();
    }
    public static void clickByText(String text, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(byText(text))).click();
    }
    public static By byText(String text){
        return By.xpath("//*[@text='"+ text + "']");
    }
    public static By byId(String id){
//        return By.xpath("//*[@id='"+ id + "']");
        return By.id(id);
    }
    public static By findByIdAndText(String appPackge,String id,String text){
      String   xpath="//*[@resource-id='"+appPackge+":id/"+id+"'][@text='"+text+"']";
      return  By.xpath(xpath);

    }
    public static By findByTextAndIndex(int index,String text){
        String   xpath="//*[@text="+text+" and @index="+index+"\""+"]";
        return  By.xpath(xpath);

    }
    public static void click(By by,WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }
    public  static  void clickByIndextid(String id,WebDriverWait wait,int index){
        List<WebElement> elements= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
        if (elements.size()>0){
            elements.get(index).click();
        }
    }
    public static void clickByXpath(String xPath,WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
    }

    public static void inputTextById(String id,String content,WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(byId(id))).sendKeys(content);
    }
    public static void inputTextById(WebDriver driver, String id, String content){
        driver.findElement(By.id(id)).sendKeys(content);
    }
    public static void clickByContentDesc(String contentDesc,WebDriverWait wait){
        String xpath="//android.view.View[@content-desc="+"'"+contentDesc+"']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
    public static void inputTextAndCheckId(WebDriver driver, String id, String content,String checker){
       do{
           driver.findElement(By.id(id)).sendKeys(content);
       }while(driver.findElement(By.id(checker))==null);
        driver.findElement(By.id(id)).sendKeys(content);
    }
    public static WebElement findEleMentById(WebDriverWait wait,String id){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byId(id)));
        return  element;
    }

}
