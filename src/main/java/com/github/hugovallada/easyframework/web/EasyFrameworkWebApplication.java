package com.github.hugovallada.easyframework.web;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class EasyFrameworkWebApplication {
    public static void run() {
        try {
            Tomcat tomcat = new Tomcat();
            Connector connector = new Connector();
            connector.setPort(8081);
            tomcat.setConnector(connector);

            Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());
            Tomcat.addServlet(ctx, "EasyDispatchServlet", new EasyDispatchServlet());

            ctx.addServletMappingDecoded("/*", "EasyDispatchServlet");
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
