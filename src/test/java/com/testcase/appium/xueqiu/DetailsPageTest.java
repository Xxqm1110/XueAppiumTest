package com.testcase.appium.xueqiu;

import app.test.page.xueqiu.DetailsPage;
import app.test.page.xueqiu.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DetailsPageTest {
    static DetailsPage detailsPage;
    @BeforeAll
    static void beforeAll ()throws MalformedURLException{
        detailsPage = new MainPage().toDetailPage();
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
                "tengxun, 腾讯控股",
        })
        void addStocks(String keyword, String name) {
            assertTrue(detailsPage.addStock(keyword).getStocksList().contains(name));
        }
    }
    @AfterAll
    static void tearsDown(){
        detailsPage.quit();
    }
}