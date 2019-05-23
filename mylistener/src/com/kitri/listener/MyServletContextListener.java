package com.kitri.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyServletContextListener implements ServletContextListener {

    public MyServletContextListener() {
    	System.out.println("Create object of MyServletContextListener");
  
    }
    
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("MyservletContextListener contextInitialized() call");

    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("MyservletContextListener contextdestroyed() call");

    }

	
}
