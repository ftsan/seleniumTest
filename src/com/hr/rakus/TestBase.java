package com.hr.rakus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.SeleneseTestBase;


public class TestBase extends SeleneseTestBase {
	private static SeleniumServer seleniumServer;

    public TestBase() { super(); }

    @BeforeClass
    public static void init() throws Exception {
        seleniumServer = new SeleniumServer();
        seleniumServer.start();
    }

    @Before
    public void before() throws Exception {
        setUp("http://example.com/", "*googlechrome");
    }

    @After
    public void after() throws Exception {
        tearDown();
    }

    @AfterClass
    public static void finish() {
        seleniumServer.stop();
    }
}
