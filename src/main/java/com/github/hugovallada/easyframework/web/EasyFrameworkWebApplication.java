package com.github.hugovallada.easyframework.web;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import com.github.hugovallada.easyframework.EasyFrameworkApplication;
import com.github.hugovallada.easyframework.explorer.ClassExplorer;
import com.github.hugovallada.easyframework.util.EasyLogger;

public class EasyFrameworkWebApplication {
    public static void run() {
        Logger.getLogger("org.apache").setLevel(Level.OFF); // desliga os logs do apache
        EasyLogger.showBanner();
        List<String> allClasses = ClassExplorer.retrieveAllClasses(EasyFrameworkApplication.class);
        EasyLogger.log("Class Explorer", "Class founds: " + allClasses);
        try {
            var ini = System.currentTimeMillis();
            EasyLogger.log("Main Module", "Starting web application");
            Tomcat tomcat = new Tomcat();
            Connector connector = new Connector();
            connector.setPort(8081);
            tomcat.setConnector(connector);

            Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());
            Tomcat.addServlet(ctx, "EasyDispatchServlet", new EasyDispatchServlet());

            ctx.addServletMappingDecoded("/*", "EasyDispatchServlet");
            tomcat.start();
            var fim = System.currentTimeMillis();
            EasyLogger.log("Main module", "Easy framework started in " + (double) (fim - ini) + " ms");
            tomcat.getServer().await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
