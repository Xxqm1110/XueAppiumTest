package appium.pages;

import org.openqa.selenium.By;

public class MainPage extends  BasePage{
    public MainPage() {
        super();
    }
    public  SearchPage  toSearch() {
        click(By.id("home_search"));
        return new SearchPage(driver);
    }

    public DetailsPage toDetailPage(){
        clickByIndex(By.id("tab_name"),1);
        return  new DetailsPage(driver);

    }


}
