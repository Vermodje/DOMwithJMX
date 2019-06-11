package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resourceServer.ResourceServerController;
import resourceServer.ResourceServerControllerMBean;
import servlet.ResourceServerServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        try {
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            ResourceServerServlet servlet = new ResourceServerServlet();
            context.addServlet(new ServletHolder(servlet), "/resources");
            ResourceServerControllerMBean controllerMBean = new ResourceServerController(servlet.getResourceServer());
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("Admin:type=ResourceServerController");
            mBeanServer.registerMBean(controllerMBean, name);
            Server server = new Server(8080);
            server.setHandler(context);
            server.start();
            logger.info("Server started");
            server.join();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }

