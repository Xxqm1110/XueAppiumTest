package com.testcase.junit5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LoginAndBuyCars {
    private static  HashMap<String ,Object> dataMap = new HashMap<String, Object>();
    @Test
    void loginTest(){
        dataMap.put("login","登录成功");
        System.out.println("准备登录");
    }
    @Nested
    class goHomeTest{
        @Test
        void ThinkTest(){
            if(dataMap.get("shop")!=null){
                System.out.println(("买到了")+dataMap.get("shop"));
            }
        }
    }
    @Nested
    class payTest{
        @Test
        void payTest(){
            if(dataMap.get("things")!=null){
                System.out.println("正在支付购买"+dataMap.get("things"));
                dataMap.put("shop",dataMap.get("things"));
            }else{
                System.out.println("没有东西要买");
            }
        }
    }
    @Nested
    class ThinkTest{
        @Test
        void ThinkTest(){
            dataMap.put("things","口红");
            System.out.println("准备买"+dataMap.get("things"));
        }
    }
    @Nested
    class BuyTest{
        @Test
        void buyTest(){
            if(dataMap.get("login").equals("登录成功")){
                System.out.println(("登录成功,可以买东西啦"));
            }else{
                System.out.println("去登录吧");
            }
        }
    }
}
