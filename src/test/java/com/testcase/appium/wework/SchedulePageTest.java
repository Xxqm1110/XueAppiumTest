package com.testcase.appium.wework;

import app.test.page.wework.WeWorkMainPage;
import app.test.page.wework.SchedulePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
class SchedulePageTest {
    public static SchedulePage page;
    @BeforeAll
    public static void setUp(){
        page = new WeWorkMainPage().to日程();
    }
    @Test
    void 添加() {
        assertTrue(page.添加("上班打卡", null).获取日程列表(null).contains("上班打卡"));
    }
    @Test
    void getScheduleList() {
        assert(page.获取日程列表(null).size()==1);
    }
    @AfterAll
    public static void tearsDown(){
        page.tearsDown();
    }

}