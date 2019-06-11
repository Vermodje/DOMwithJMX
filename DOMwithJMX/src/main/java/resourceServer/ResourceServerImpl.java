package resourceServer;

import dom.DOMParser;
import org.xml.sax.SAXException;
import resources.TestResource;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ResourceServerImpl implements ResourceServer {
    private TestResource testResource;
    private String filePath;
    public ResourceServerImpl() {

    }

    @Override
    public void initialize(String filePath) throws IOException, SAXException, ParserConfigurationException {
        this.filePath = filePath;
        DOMParser domParser = new DOMParser(this.getPath());
        testResource = domParser.getObject();
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public void setName(String name) {
        testResource.setName(name);
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public void setAge(int age) {
        testResource.setAge(age);
    }

    @Override
    public String getPath() {
        return filePath;
    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public TestResource getTestResource() {
        return testResource;
    }
}
