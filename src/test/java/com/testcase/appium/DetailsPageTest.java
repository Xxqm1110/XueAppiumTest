package com.testcase.appium;

import appium.pages.DetailsPage;
import appium.pages.MainPage;
import appium.pages.SearchPage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.net.MalformedURLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DetailsPageTest {
    static DetailsPage detailsPage;
    static SearchPage searchPage;
    static  MainPage  mainPage;
    @BeforeAll
    static void beforeAll ()throws MalformedURLException{
        mainPage =new MainPage();
        detailsPage = mainPage.toDetailPage();
    }
    @Test
    void  ClearStocks(){
        assertTrue(detailsPage.ClearStocks().getStocksList().size()==0);
    }

    @Nested
    class addStocksTest {
        public addStocksTest(){}
        @ParameterizedTest
        @CsvSource({
                "alibaba, 阿里巴巴",
                "jd, 京东",
                "tengxun, 腾讯",
        })
        void addStocks(String keyword, String name) {
            assertTrue(detailsPage.goToSearch().addStock(keyword).exitSearch().getStocksList().contains(name));
        }
    }

}