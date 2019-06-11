package resourceServer;

public class ResourceServerController implements ResourceServerControllerMBean {
    private ResourceServer resourceServer;

    public ResourceServerController(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }

    @Override
    public void setName(String name) {
        resourceServer.setName(name);
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }

    @Override
    public void setAge(int age) {
        resourceServer.setAge(age);
    }
}
