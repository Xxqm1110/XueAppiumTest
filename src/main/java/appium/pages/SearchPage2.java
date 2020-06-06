package appium.pages;

import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchPage2 {
    private AndroidDriver driver;
    public SearchPage2(){}
    public SearchPage2(AndroidDriver driver){
        this.driver =driver;
    }
    public SearchPage2 search(String keword){
        return this;
    }
    public List<SearchPage2> getSearchList(){
        return new ArrayList<SearchPage2>();
    }

    public double getPrice(){
        return  1.1;
    }
}
