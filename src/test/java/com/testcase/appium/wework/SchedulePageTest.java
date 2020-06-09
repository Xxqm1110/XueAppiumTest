package com.testcase.appium.wework;

import app.test.page.wework.WeWorkMainPage;
import app.test.page.wework.SchedulePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;
class SchedulePageTest {
    public static SchedulePage page;
    @BeforeAll
    public static void setUp(){
        page = new WeWorkMainPage().to日程();
    }
    @Test
    @Order(1)
    void 添加() {
        assertTrue(page.添加("上班打卡", null).获取日程列表(null).contains("上班打卡"));
        assert(page.获取日程列表(null).size()==1);
    }
    @Test
    @Order(2)
    void deleSchedule(){
        page.deleteSchedule("上班打卡",0);
        assert(page.获取日程列表(null).size()==0);
    }
//    @Test
//    void getScheduleList() {
//        assert(page.获取日程列表(null).size()==1);
//    }
    @AfterAll
    public static void tearsDown(){
        page.tearsDown();
    }

}