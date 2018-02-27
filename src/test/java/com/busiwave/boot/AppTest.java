package com.busiwave.boot;

import com.busiwave.boot.controller.HomeController;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest 
{

    @Test
    public void testApp()
    {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals( result, "Das Boot, reporting for duty!");
    }
}
