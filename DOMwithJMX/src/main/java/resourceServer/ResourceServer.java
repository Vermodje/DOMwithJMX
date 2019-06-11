package resourceServer;

import org.xml.sax.SAXException;
import resources.TestResource;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ResourceServer {
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    String getPath();
    void setPath(String filePath);
    TestResource getTestResource();
    void initialize(String filePath) throws IOException, SAXException, ParserConfigurationException;
}
