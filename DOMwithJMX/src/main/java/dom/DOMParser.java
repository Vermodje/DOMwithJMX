package dom;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import reflection.ReflectionHelper;
import resources.TestResource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class DOMParser {
    private NodeList nodes;
    private Element element;
    private TestResource testResource;

    public DOMParser(String filePath) throws ParserConfigurationException, IOException, SAXException {
        nodes = createDocumentBuilder().parse(new File(filePath)).getElementsByTagName("class");
        this.createObject();
        this.setFields();
    }

    private DocumentBuilder createDocumentBuilder() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    private void createObject() {
        testResource = (TestResource) ReflectionHelper.createInstance(this.getClassName());
    }

    private String getClassName() {
        element = (Element) nodes.item(0);
        return element.getAttribute("name");
    }

    public TestResource getObject() {
        return testResource;
    }

    private void setFields() {
        element = (Element) nodes.item(0);
        try {
            ReflectionHelper.setFieldValue(testResource, "age", this.getField("age"));
            ReflectionHelper.setFieldValue(testResource, "name", this.getField("name"));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private String getField(String fieldName) {
        return element.getElementsByTagName(fieldName).item(0).getChildNodes().item(0).getTextContent();
    }

}
