package reflect;

public class User {

    public String name;

    public int age;

    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public   void test1(String parmet1, int parmet2){
          System.out.println(parmet1+"+++"+parmet2);
    }
}
