package com.testcase.appium.wework;

import app.test.page.wework.TODOPage;
import app.test.page.wework.WeWorkMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TODOPageTest {
    public static TODOPage page;
    @BeforeAll
    public static void setUp(){
        page = new WeWorkMainPage().todoPage();
    }

    @Test
    @Order(1)
    void addTODO() {
        assertTrue(page.addTODO("买菜啦").getTODOList().contains("买菜啦"));
    }

    @Test
    @Order(2)
    void setDone(){
        assertFalse(page.setDone("买菜啦").getTODOList().contains("买菜啦"));
    }


    @AfterAll
    public static void tearsDown(){
        page.tearsDown();
    }

}