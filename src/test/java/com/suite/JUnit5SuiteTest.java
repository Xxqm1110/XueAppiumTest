package com.suite;

import com.testcase.junit5.JUnit5DemoTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
    "com.testcase"
        })
@IncludePackages("com.testcase.junit5.testcase2")
@SelectClasses(JUnit5DemoTest.class)
@IncludeTags("FUN3")
public class JUnit5SuiteTest {
}
