package com.testcase.appium.wework;

import app.test.page.wework.WeWorkMainPage;
import app.test.page.wework.SchedulePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertTrue;
class SchedulePageTest {
    public static SchedulePage page;
    @BeforeAll
    public static void setUp(){
        page = new WeWorkMainPage().to日程();
    }
    @ParameterizedTest
    @CsvSource({
            "上班打卡,",
            "端午放假, 25"
    })

    @Order(1)
    void 添加(String name ,String time) {
        assertTrue(page.添加(name,time).获取日程列表(time).contains(name));

    }

    @ParameterizedTest
    @CsvSource({
            "上班打卡,",
            "端午放假, 25"
    })
    @Order(2)
    void deleSchedule(String name,String time){
        page.deleteSchedule(name,time,0);
        assert(page.获取日程列表(time).size()==0);
    }

    @AfterAll
    public static void tearsDown(){
        page.tearsDown();
    }

}