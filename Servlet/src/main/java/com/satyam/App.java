package com.satyam;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);



        //to get hold on the different pages we use context
        //first parameter is the directory (/home) "" for
        Context context = tomcat.addContext("",null);
        Tomcat.addServlet(context,"hello",new HelloServlet());
        context.addServletMappingDecoded("/hello","hello");

        tomcat.getConnector();  //creates default http container
        tomcat.start();
        tomcat.getServer().await();   //keep running on the server


    }
}
