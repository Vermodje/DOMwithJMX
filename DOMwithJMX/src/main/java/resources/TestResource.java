package resources;

public class TestResource {
    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    @Override
    public String toString() {
        return "TestResource: name = " + this.getName() +" " + "age = " + this.getAge();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}

