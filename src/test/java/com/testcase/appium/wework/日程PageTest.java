package com.testcase.appium.wework;

import app.test.page.wework.WeWorkMainPage;
import app.test.page.wework.日程Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 日程PageTest {
    public static 日程Page page;
    @BeforeAll
    public static void setUp(){
        page = new WeWorkMainPage().to日程();
    }
    @Test
    void 添加() {
//        page.添加()
    }

    @Test
    void 获取日程列表() {
    }
}