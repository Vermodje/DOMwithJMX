package servlet;

import org.xml.sax.SAXException;
import resourceServer.ResourceServer;
import resourceServer.ResourceServerImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class ResourceServerServlet extends HttpServlet {
    private ResourceServer resourceServer;

    public ResourceServerServlet() {
        resourceServer = new ResourceServerImpl();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filePath = req.getParameter("path");
        if(resourceServer.getPath() == null){
            try {
                resourceServer.initialize(filePath);
            } catch (SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }
    public ResourceServer getResourceServer() {
        return resourceServer;
    }
}
