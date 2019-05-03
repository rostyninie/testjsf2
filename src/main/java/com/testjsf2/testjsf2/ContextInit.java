/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testjsf2.testjsf2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author viper
 */
public class ContextInit implements ServletContextListener{
private static final String APP_CONTEXT="app_context";
public static ApplicationContext appContext;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   //ServletContext servletcontext=sce.getServletContext();
   appContext=new AnnotationConfigApplicationContext(Configurations.class);
   //servletcontext.setAttribute(APP_CONTEXT, this.appContext);
   
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
