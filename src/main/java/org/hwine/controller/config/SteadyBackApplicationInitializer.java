package org.hwine.controller.config;

import java.util.TimeZone;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SteadyBackApplicationInitializer implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent sce) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Do nothing, no need to clean up
    }
}
