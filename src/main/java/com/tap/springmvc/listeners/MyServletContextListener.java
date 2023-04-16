package com.tap.springmvc.listeners;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        //
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Code to clean up and deregister JDBC drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                // Handle any exceptions that occur during driver deregistration
                e.printStackTrace();
            }
        }
        
        try {
            // Stop the MySQL Connector/J abandoned connection cleanup thread
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Exception e) {
            // Handle any exceptions that occur during thread shutdown
            e.printStackTrace();
        }
    }
}
  