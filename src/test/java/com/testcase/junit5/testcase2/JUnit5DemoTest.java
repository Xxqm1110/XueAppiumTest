package com.testcase.junit5.testcase2;


import org.junit.jupiter.api.*;

@DisplayName("junit5 JUnit5DemoTest")
public class JUnit5DemoTest {
    @BeforeAll
    public  static void befere(){
        System.out.println("befeore");
    }
    @Test
    @Disabled
    @DisplayName("fun  method")
    @RepeatedTest(3)
    void  fun(){
        System.out.println("fun1");
    }
    @Test
    @DisplayName("fun 2 method")
    @RepeatedTest(3)
    @Tag("FUN2")
    void  fun2(){
        System.out.println("fun2");
    }
    @Test
    @DisplayName("fun 2 method")
    @RepeatedTest(3)
    @Tag("FUN3")
    void  fun3(){
        System.out.println("fun3");
    }
    @AfterAll
    public static  void after(){
        System.out.println("after");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("befereTest");
    }
    @AfterEach
    public void afterTest(){
        System.out.println("afterTest");
    }

}
